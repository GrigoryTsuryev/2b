package com.app.tobeprecise.utils;

import java.util.Arrays;

public class MathUtils {

    public static double calculateOverload(double[] array) {
        double average = Arrays.stream(array).average().getAsDouble();
        double mean = Arrays.stream(array).map(el -> Math.pow((el - average), 2)).sum() / (array.length - 1);
        return Math.sqrt(mean) + average;
    }
}
