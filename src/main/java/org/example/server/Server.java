package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int LIS_PORT = 6666;
    private static final String BYE_COMMAND = "bye";

    public static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(LIS_PORT)) {
            System.out.println("Server started. Listening for connections...");
            while (true) {
                Socket clientSocket = serverSocket.accept(); // Wait for a client to connect
                System.out.println("Client connected: " + clientSocket);
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (Scanner in = new Scanner(clientSocket.getInputStream());
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                out.println("Connected to the server. Type 'bye' to exit.");
                Server.readASTMMessage(clientSocket);
                String message;
                do {
                    message = in.nextLine();
                    out.println("Server: " + message); // Echo the message back to the client
                } while (!message.equalsIgnoreCase(BYE_COMMAND));

                System.out.println("Client disconnected: " + clientSocket);
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readASTMMessage(Socket clientSocket) {
        try (Scanner in = new Scanner(clientSocket.getInputStream())) {
            StringBuilder ASTMMessageBuilder = new StringBuilder();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            String line;
            while (!(line = in.nextLine()).isEmpty()) {
                ASTMMessageBuilder.append(line).append("\n");
            }
            String ASTMMessage = ASTMMessageBuilder.toString();
            System.out.println("Received ASTM message: " + ASTMMessage);
            out.println("The response from the client is " + ASTMMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
