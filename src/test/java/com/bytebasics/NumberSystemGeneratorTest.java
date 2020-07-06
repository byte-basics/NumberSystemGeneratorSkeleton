package com.bytebasics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberSystemGeneratorTest
{
    private final int maxValue = 36;
    private final int minValue = 2;
    private final int decimalNumberBase = 10;
    private NumberSystemGenerator testGenerator;

    @Before
    public void setUp() {
        testGenerator = new NumberSystemGenerator();
    }

    @Test
    public void testDecimalSingleDigitValueGeneration() {
        String singleDigitValueResult = testGenerator.generateSingleDigitValueString(decimalNumberBase);
        Assert.assertEquals("0 1 2 3 4 5 6 7 8 9", singleDigitValueResult);
    }

    @Test
    public void testSingleDigitValueGenerationHex() {
        int hexadecimalNumberBase = 16;
        String singleDigitValueResult = testGenerator.generateSingleDigitValueString(hexadecimalNumberBase);
        Assert.assertEquals("0 1 2 3 4 5 6 7 8 9 A B C D E F", singleDigitValueResult);
    }

    @Test
    public void testSingleDigitValueGenerationLowerBoundary() {
        String singleDigitValueResult = testGenerator.generateSingleDigitValueString(minValue);
        Assert.assertEquals("0 1", singleDigitValueResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSingleDigitValueGenerationLowerBoundaryMinusOne() {
        testGenerator.generateSingleDigitValueString(minValue - 1);
    }

    @Test
    public void testSingleDigitValueGenerationUpperBoundary() {
        String singleDigitValueResult = testGenerator.generateSingleDigitValueString(maxValue);
        Assert.assertEquals("0 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z",
                singleDigitValueResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSingleDigitValueGenerationUpperBoundaryPlusOne() {
        NumberSystemGenerator testGenerator = new NumberSystemGenerator();
        testGenerator.generateSingleDigitValueString(maxValue + 1);
    }


    @Test
    public void testColumnValuesGenerationDecimal() {
        String columnValues = testGenerator.generateColumnValues(decimalNumberBase);
        Assert.assertEquals("1 10 100 1000 10000", columnValues);
    }

    @Test
    public void testColumnValuesGenerationLowerBound() {
        String columnValues = testGenerator.generateColumnValues(minValue);
        Assert.assertEquals("1 2 4 8 16", columnValues);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testColumnValuesGenerationLowerBoundMinusOne() {
        String columnValues = testGenerator.generateColumnValues(minValue - 1);
    }

    @Test
    public void testColumnValuesGenerationUpperBound() {
        String columnValues = testGenerator.generateColumnValues(maxValue);
        Assert.assertEquals("1 36 1296 46656 1679616", columnValues);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testColumnValuesGenerationUpperBoundPlusOne() {
        testGenerator.generateColumnValues(maxValue + 1);
    }
}
