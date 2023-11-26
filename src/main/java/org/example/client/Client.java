package org.example.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String HOST = "localhost";
    private static final int SERVER_PORT = 6664;
    public static void sendMessage(String message) {
        try (Socket socket = new Socket(HOST, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            out.println(message);
            System.out.println("Message sent to the server: " + message);
        } catch (IOException e) {
            System.err.println("Error sending message: " + e.getMessage());
            e.printStackTrace();
        }
    }


//    public static void readServerResponse() {
//        try (ServerSocket serverSocket = new ServerSocket(CLIENT_PORT)) {
//            System.out.println("Client listening for server responses on port " + CLIENT_PORT);
//
//            while (true) {
//                Socket clientSocket = serverSocket.accept();
//                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                String response = in.readLine();
//                System.out.println("Received response from server: " + response);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

