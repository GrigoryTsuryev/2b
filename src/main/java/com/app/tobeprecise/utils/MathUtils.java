package com.app.tobeprecise.utils;

import java.util.Arrays;

public class MathUtils {

    public static double calculateOverload(double[] array) {
        double n= array.length;
        double sum = Arrays.stream(array).sum();
        double average = sum / n;
        double mean = Arrays.stream(array).map(el -> Math.pow((el - average), 2)).sum() / (n - 1);
        return Math.sqrt(mean) + average;
    }
}
