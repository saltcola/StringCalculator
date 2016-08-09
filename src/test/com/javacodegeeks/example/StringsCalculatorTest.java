/**
 * Created by gangfan on 8/9/16.
 */

package com.javacodegeeks.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringsCalculatorTest {

    StringCalculator calculator;

    @Before
    public void init() {
        calculator = new StringCalculator();
    }

    @Test
    public void testDefaultDelimiters() {
        String input = "1\n2,3";
        assertEquals(6,calculator.add(input));
    }

    @Test
    public void testMultiDelimiters() {
        String input = "//[***][%]\n1***2%3";
        assertEquals(6,calculator.add(input));
    }

    @Test
    public void testNumbersMoreThan1000() {
        String input = "//[***][%]\n1***2%3,2000";
        assertEquals(6,calculator.add(input));
    }
    @Test
    public void testNumbers4Numbers() {
        String input = "//[***][%][,]\n1***2%3,2";
        assertEquals(8,calculator.add(input));
    }
}
