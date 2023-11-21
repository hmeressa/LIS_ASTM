//package org.example;
//
//import static org.example.Server.*;
//
//public class formattedMessage {
//    public static String order() {
//        String message = "1H|@^\\|ODM-IdfDGIWA-36|||GeneXpert     PC^GeneXpert^4.8|||||LIS||P|1394-97|20070521100245" + ProtocolASCII.LF
//                + "P|1"
//                + "O|1|SID-818||^^^TestId-12|S|20070812140500|||||A||||ORH||||||||||Q"
//                + "L|1|F";
//        message = STX + message + CR + ETX + getCheckSum(message) + CR + LF;
//        return message;
//    }
//
//    public static String getCheckSum(String msg) {
//        int sum = 0;
//        for (int i = 0; i < msg.length(); i++) {
//            sum += msg.charAt(i);
//        }
//        sum += 16;
//        sum = sum % 256;
//        String checksum = Integer.toHexString(sum).toUpperCase();
//        if (checksum.length() == 1) {
//            checksum = "0" + checksum;
//        }
//       return checksum;
//    }
//}
