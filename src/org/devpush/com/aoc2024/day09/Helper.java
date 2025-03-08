package org.devpush.com.day09;

public class Helper {

     static void printNNoOfTimes(StringBuilder sb, int itemToPrint, int noOfTimesToPrint){
        for (int i = 0; i < noOfTimesToPrint; i++) {
            sb.append(itemToPrint);
        }
    }

    static void printNBlanksOfTimes(StringBuilder sb, String itemToPrint, int noOfTimesToPrint){
        for (int i = 0; i < noOfTimesToPrint; i++) {
            sb.append(itemToPrint);
        }
    }
}
