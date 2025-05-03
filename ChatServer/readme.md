ChatServer 💬
Aplicação de Chat TCP em Java (via terminal)

Este projeto implementa um servidor de chat multicliente em Java, utilizando Sockets e Threads. Os clientes podem comunicar entre si em tempo real através de um terminal, usando o comando netcat para conectar ao servidor. Ideal para compreender conceitos como redes, programação concorrente e protocolos simples de comunicação.

🚀 Funcionalidades
Comunicação em tempo real entre vários clientes

Comando /list para listar utilizadores online

Comando /whisper <nome> <mensagem> para mensagens privadas

Comando /quit para sair do chat

Comunicação via terminal usando netcat (sem cliente Java)

🛠️ Tecnologias Utilizadas
Java 17

Sockets TCP

ExecutorService (thread pool)

CopyOnWriteArrayList para gestão de clientes

📁 Estrutura do Projeto
ChatServer/
└── io/
    └── codeforall/
        └── kernelfc/
            └── Server.java

⚙️ Como Correr
1. Compilar o servidor
javac io/codeforall/kernelfc/Server.java

2. Correr o servidor
java io.codeforall.kernelfc.Server

Deverás ver:
Created a socket in port: 8585

3. Abrir clientes via netcat
Em outros terminais:
nc localhost 8585

Depois:
Introduz um nome de utilizador

Envia mensagens públicas ou comandos

💡 Exemplos de comandos suportados
Olá a todos! → mensagem pública

/list → ver utilizadores online

/whisper Maria Olá, estás aí? → mensagem privada

/quit → sair do chat

📸 Capturas de Ecrã
![Screenshot at 15-46-28](https://github.com/user-attachments/assets/307f88e5-f8d6-4480-a5d3-274f9630ae4c)
