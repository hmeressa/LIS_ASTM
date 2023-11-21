package org.example.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class FormattedMessage {
    Socket socket;
    public static final int PORT = 6663;
    public static final String HOST = "localhost";

    public static String patientOrder() throws IOException {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String header = "H||LIS|ICL|||||ASTM|||||||||||";
            String patientInfo = "P|1|Doe^John|||M|19900101||123 Main St^Anytown^CA^12345||";
            String patientOrder = "O|1|SID-818||^^^TestId-12|S|20070812140500|||||A||||ORH||||||||||Q";
            String message = "";

            // Construct the message
            message += Commands.STX.getValue() + header + Commands.CR.getValue() +
                    patientInfo + Commands.CR.getValue() +
                    patientOrder + Commands.CR.getValue() +
                    Commands.ETX.getValue();

            // Calculate and append the checksum for the constructed message
            String checksum = getCheckSum(message);
            message += checksum + Commands.CR.getValue() + Commands.LF.getValue();

            // Send the message to the server
            out.println(message);
            System.out.println("Message sent to the server: " + Commands.STX);

            return message;
        }
    }

    public static String getCheckSum(String msg) {
        int sum = 0;
        for (int i = 0; i < msg.length(); i++) {
            sum += msg.charAt(i);
        }
        sum += 16;
        sum = sum % 256;
        String checksum = Integer.toHexString(sum).toUpperCase();
        if (checksum.length() == 1) {
            checksum = "0" + checksum;
        }
        return checksum;
    }
}
