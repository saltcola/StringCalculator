package com.javacodegeeks.example;

/**
 * Created by gangfan on 8/9/16.
 */

/*
 * This class validates that the numbers in a string are all positive numbers.
 * If a negative number is found an exception is raised that displays all the negative numbers.
 */

public class InputValidator {
    public static void validate(String[] numbers) throws RuntimeException {
        StringBuilder negativeNumbers = new StringBuilder();
        for (String number:numbers) {
            int numInt = Integer.parseInt(number);
            if(numInt < 0) { if(negativeNumbers.length()> 0) {
                negativeNumbers.append(",");
            }
                negativeNumbers.append(numInt);
            }
        }
        if(negativeNumbers.length()> 0) {
            throw new RuntimeException(String.format("[%s] negative numbers not allowed.", negativeNumbers.toString()));
        }
    }
}
