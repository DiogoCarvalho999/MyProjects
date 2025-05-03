ChatServer 💬
Java TCP Chat Application (via terminal)

This project implements a multiclient chat server in Java using Sockets and Threads. Clients can communicate in real-time via the terminal using netcat, without needing a Java client. It's ideal for learning about networking, concurrency, and simple communication protocols.

🚀 Features
Real-time communication between multiple clients

/list command to view connected users

/whisper <name> <message> to send private messages

/quit command to exit the chat

Terminal-based communication using netcat (no Java client required)

🛠️ Technologies Used
Java 17

TCP Sockets

ExecutorService (thread pool)

CopyOnWriteArrayList to manage connected clients

📁 Project Structure
arduino
Copy
Edit
ChatServer/
└── io/
    └── codeforall/
        └── kernelfc/
            └── Server.java
⚙️ How to Run
1. Compile the server
javac io/codeforall/kernelfc/Server.java

2. Run the server
java io.codeforall.kernelfc.Server

Expected output:
Created a socket in port: 8585

3. Connect clients using netcat
In separate terminal windows:

nc localhost 8585
Then:

Enter a username when prompted

Start sending messages or commands

💡 Supported Commands
Hello everyone! → public message

/list → show all connected users

/whisper Maria Hey, are you there? → private message

/quit → disconnect from the chat

📸 Screenshots
![Screenshot at 15-46-28](https://github.com/user-attachments/assets/ad79c35d-f448-40da-9bd3-ba72b32a6d8c)
