package io.zipcoder.casino.utilities.io;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import java.util.Scanner;


// ALL printing is to be done through this class!
public final class ConsoleServices {

    public static void print(String message) {
        System.out.println(message);
    }

    public static Float getFloatInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        Util.println(prompt);
        String userInput = scanner.nextLine();
        try {
            return Float.parseFloat(userInput);
        } catch (NumberFormatException e) { e.printStackTrace(); }
        return 0.0f;
    }


    public static Double getDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        Util.println(prompt);
        String userInput = scanner.nextLine();
        try {
            return Double.parseDouble(userInput);
        } catch (NumberFormatException e) { e.printStackTrace(); }
        return 0.0;
    }

    public static Integer getIntegerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        Util.println(prompt);
        String userInput = scanner.nextLine();
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) { e.printStackTrace(); }
        return 0;
    }

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        Util.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
