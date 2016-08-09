package com.javacodegeeks.example;

/**
 * Created by gangfan on 8/9/16.
 */

/*
 *This class takes the input of numbers in string format
 *and split them up based on the defined delimiters.
 *The delimiters are defined at the beginning of the string,
 *the start of the delimiters is marked by // and the end
 *of the delimiters is marked by \n.
 *Each delimiter is enclosed within the open and closed brackets.
 *e.g.//[***][%]\n1***2%3
*/

public class InputNormalizer {

    public String[] normalize(String input){
        String delimiters = "\n|,";
        if(input.contains("//")){
            delimiters = getDelimiters(input, delimiters);
            input = stripDelimiters(input);
        }
        return input.split(delimiters);
    }

    private String getDelimiters(String numbers, String defaultDelimiters){
        StringBuilder delimiters = new StringBuilder(defaultDelimiters);
        while(numbers.indexOf("[") >= 0){
            delimiters.append("|");
            String delimiter = numbers.substring(numbers.indexOf("[") + 1,
                    numbers.indexOf("]"));
            for (char delimiterChar: delimiter.toCharArray()){
                delimiters.append("\\").append(delimiterChar);
            }
            numbers = numbers.substring(numbers.indexOf("]")+1);
        }
        System.out.println(" delimiters.toString() = " + delimiters.toString());
        return delimiters.toString();
    }

    private String stripDelimiters(String numbers){
        return numbers.substring(numbers.indexOf("\n") + 1);
    }
}
