package org.example.client;

import java.io.IOException;

public class FormattedMessage {

    public static String patientOrder() throws IOException {
        try {
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

            return message;
        } catch (Exception e) {
            return "";
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
