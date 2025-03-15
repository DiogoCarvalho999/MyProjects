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

public class Server {
    private Socket clientSocket;
    private ServerSocket serverSocket;
    private final CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>();

    public Server(int port) {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Created a socket in port: " + serverSocket.getLocalPort());

            ExecutorService cachedPool = Executors.newCachedThreadPool();
            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Connected client: " + clientSocket.getPort());

                ClientHandler clientHandler = new ClientHandler(clientSocket);

                cachedPool.submit(clientHandler);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        int portNumber = 8585;
        new Server(portNumber);
    }

    public class ClientHandler implements Runnable {
        Socket clientSocket;
        String name;
        BufferedReader in;
        PrintWriter out;

        public ClientHandler(Socket socket) {
            clientSocket = socket;
        }

        @Override
        public void run() {

            try {

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                out.println("Whats your name? ");
                name = in.readLine();

                clients.add(this);

                out.println("Write your mensage: ");
                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("/quit")) {
                        out.println("Connection closed.");
                        clients.remove(this);
                        break;
                    }

                    if (message.equalsIgnoreCase("/list")) {
                        out.println("List of clients:");
                        for (ClientHandler client : clients) {
                            out.println(client.getName());

                        }
                    } else if(message.startsWith("/whisper ") ){
                        String[] parts = message.split(" ", 3);
                        if (parts.length < 3) {
                            out.println("Invalid format. Use: /whisper <name> <message>");
                            continue;
                        }
                        String targetName = parts[1];
                        String whisperMessage = parts[2];

                        boolean found = false;
                        for (ClientHandler client : clients) {
                            if (client.getName().equalsIgnoreCase(targetName)) {
                                client.getOut().println("(Whisper from " + name + ") " + whisperMessage);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            out.println("User '" + targetName + "' not found.");
                        }
                    } else {
                        for (ClientHandler client : clients) {
                            if (client != this) {
                                client.getOut().println(name + ": " + message);
                            }
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public String getName() {
            return name;
        }

        public PrintWriter getOut() {
            return out;
        }
    }
}
