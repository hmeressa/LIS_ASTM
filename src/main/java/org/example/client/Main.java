package org.example.client;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Client.sendMessage(FormattedMessage.patientOrder());
    }

}