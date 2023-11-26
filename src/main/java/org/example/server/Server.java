package org.example.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import static org.example.client.Commands.*;

public class Server {
    private static final int LISTEN_PORT = 6668;
    public static Vector<String> vecMessages = new Vector<>();
    private static int currentMsgCount = 0;

    public static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(LISTEN_PORT)) {
            System.out.println("Server started. Listening for connections...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }
        @Override
        public void run() {
            try (BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream())) {
                int clientIntMessage;
                while (true) {
                    clientIntMessage = inFromClient.read();
                    System.out.println("message: " + clientIntMessage);

                    if (clientIntMessage == CR.getValue()) {
                        System.out.println("[ACK] on Analyzer [ENQ]");
                    } else if (clientIntMessage == STX.getValue()) {
                        System.out.println("Analyzer [ACK]");
                        if (vecMessages.size() == currentMsgCount) {
                            vecMessages.clear();
                            currentMsgCount = 0;
                            outToClient.writeBytes("" + ETX);
                            System.out.println("Host [EOT]");
                        } else {
                            String msg = vecMessages.get(currentMsgCount++);
                            outToClient.writeBytes(msg);
                        }
                    } else if (clientIntMessage == LF.getValue()) {
                        outToClient.writeBytes("" + LF);
                    } else {
                        System.out.println("error two");
                    }

                    if (clientIntMessage == ETX.getValue() || clientIntMessage == -1) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
