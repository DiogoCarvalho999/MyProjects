package io.codeforall.kernelfc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerOrganized {
    private final ServerSocket serverSocket;
    private final CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public ServerOrganized(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Created a socket in port: " + serverSocket.getLocalPort());
    }

    public void startServer() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected client: " + socket.getPort());
                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                executorService.submit(clientHandler);
            }
        } catch (IOException e) {
            System.err.println("Error accepting client connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int portNumber = 8585;
        try {
            ServerOrganized server = new ServerOrganized(portNumber);
            server.startServer();
        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }

    private class ClientHandler implements Runnable {
        private final Socket socket;
        private String name;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                this.in = in;
                this.out = out;

                out.println("What's your name?");
                this.name = in.readLine();

                sendMessage("Write your message: ");
                String message;

                while ((message = in.readLine()) != null) {
                    if (!handleCommand(message)) {
                        broadcastMessage(name + ": " + message);
                    }
                }

            } catch (IOException e) {
                System.err.println("Connection error with client " + name + ": " + e.getMessage());
            } finally {
                clients.remove(this);
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Failed to close socket: " + e.getMessage());
                }
            }
        }

        private boolean handleCommand(String message) {
            if (message.equalsIgnoreCase("/quit")) {
                sendMessage("Connection closed.");
                clients.remove(this);
                return true;
            }

            if (message.equalsIgnoreCase("/list")) {
                sendMessage("List of clients:");
                for (ClientHandler client : clients) {
                    sendMessage(client.name);
                }
                return true;
            }

            if (message.startsWith("/whisper ")) {
                String[] parts = message.split(" ", 3);
                if (parts.length < 3) {
                    sendMessage("Invalid format. Use: /whisper <name> <message>");
                    return true;
                }

                String targetName = parts[1];
                String whisperMessage = parts[2];

                boolean found = false;
                for (ClientHandler client : clients) {
                    if (client.name.equalsIgnoreCase(targetName)) {
                        client.sendMessage("(Whisper from " + name + ") " + whisperMessage);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    sendMessage("User '" + targetName + "' not found.");
                }
                return true;
            }

            return false; // Mensagem normal
        }

        private void broadcastMessage(String message) {
            for (ClientHandler client : clients) {
                if (client != this) {
                    client.sendMessage(message);
                }
            }
        }

        private void sendMessage(String message) {
            out.println(message);
        }
    }
}
