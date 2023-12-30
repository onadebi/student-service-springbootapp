package com.onadebi.test;

import org.junit.jupiter.api.Assertions;
// import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomTest {

    CalculateMethds calculateMethds;

    @BeforeEach
    public void InitTest() {
        calculateMethds = new CalculateMethds();
    }

    @Test
    public void testDivide() {
        System.out.println("RandomTest.testRandom()");
        Assertions.assertEquals(10, calculateMethds.divide(20, 2));
    }

    @Test
    public void testDivideByZero() {
        System.out.println("RandomTest.testRandom()");
        Assertions.assertThrows(ArithmeticException.class, () -> calculateMethds.divide(1, 0));
    }
}
