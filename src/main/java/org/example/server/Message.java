//package org.example;
//
//import org.example.model.Patient;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Vector;
//
//import static org.example.Server.*;
//
//public class Message {
//    public static Vector<String> vectorMessages = new Vector<String>();
//
//    public String HeaderMessage() {
//        String header = "H|@^\\|ccc6ade20d3623314sffa3e287f2314ad||LIS|||||ICU^GeneXpert^1.0||P|1394-97|20070521100245";
//        header = STX + header + CR + ETX + getCheckSum(header) + CR + LF;
//        return header;
//    }
//
//    public String PatientMessage(Patient patient) {
//
//        String patientInformation = "P|1|||" + patient.getId() + "|^" + patient.getFirstName() + "||" + patient.getLastName() + "|^" +
//                patient.getPhone() + "||" + patient.getAddress() + "|" + "||" + patient.getSex() + "|" + patient.getAddress() + "||" +
//                patient.getSex() + "|" + patient.getAge() + "|" + patient.getSex() + "|||||^Dr.SKM-LAS||||||||||||^^^EAST";
//        patientInformation = STX + patientInformation + CR + ETX + getCheckSum(patientInformation) + CR + LF;
//
//        return patientInformation;
//    }
//
//    public String orderMessage(String sampleId, String testIds, String orderType, String rackId, String positionNumber, String priority) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmSS");
//        String sysDate = dateFormat.format(new Date());
//        String retmsg = "3O|1|" + rackId + "^" + positionNumber + "^" + sampleId + "^B||" + testIds + "|" + priority + "|" + sysDate + "|||||" + orderType + "";
//        retmsg = STX + retmsg + CR + ETX + getCheckSum(retmsg) + CR + LF;
//        return retmsg;
//    }
//
//    public String terminatorMessage(String type) {
//        String terminator = "L|1|" + type;
//        terminator = STX + terminator + CR + ETX + getCheckSum(terminator) + CR + LF;
//        return terminator;
//    }
//
//    public String getCheckSum(String message) {
//        int sum = 0;
//        for (int i = 0; i < message.length(); i++) {
//            sum += message.charAt(i);
//        }
//        sum += 16;
//        sum = sum % 256;
//        String checksum = Integer.toHexString(sum).toUpperCase();
//        if (checksum.length() == 1) {
//            checksum = "0" + checksum;
//        }
//        return checksum;
//    }
//
//    public void parser(String input) {
//        if (input.charAt(1) == 'Q' || input.charAt(2) == 'Q') {
//            String rackId = "get from Query to check document";
//            String positionNumber = "get from Query to check document";
//            String sampleId = "get from Query to check document";
//            this.FetchOrders1("abc", sampleId);
//        }
//    }
//
//    public void FetchOrders1(String machineId, String sampleId) {
//        try {
//            this.vectorMessages.add(HeaderMessage());
////            this.vectorMessages.add(PatientMessage(sampleId)); //Define patient information
//            this.vectorMessages.add(orderMessage(sampleId, "test", "N", "rackId", "positionNumber", "R"));
//            this.vectorMessages.add(terminatorMessage("N"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
