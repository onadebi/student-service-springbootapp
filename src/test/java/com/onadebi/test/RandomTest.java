package com.onadebi.test;

import org.junit.jupiter.api.Assertions;
// import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomTest {

    CalculateMethds calculateMethds;

    void contextLoads() {
    }

    @BeforeEach
    public void InitTest() {
        calculateMethds = new CalculateMethds();
    }

    @Test
    public void testDivide() {
        System.out.println("RandomTest.testRandom()");
        // given
        int num1 = 20;
        int num2 = 2;
        // when
        int result = calculateMethds.divide(num1, num2);
        // then
        Assertions.assertEquals(10, result);
    }

    @Test
    public void testDivideByZero() {
        System.out.println("RandomTest.testRandom()");
        Assertions.assertThrows(ArithmeticException.class, () -> calculateMethds.divide(1, 0));
    }
}
