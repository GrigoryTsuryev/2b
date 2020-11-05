package com.app.tobeprecise.utils;

import java.util.Arrays;

public class MathUtils {

    public static double calculateOverload(double[] array) {
        double n= array.length;
        double sum = Arrays.stream(array).sum();
        double mean = sum / n;
        double mean1 = Arrays.stream(array).map(el -> Math.pow((el - mean), 2)).sum() / (n - 1);
        double average = Arrays.stream(array).average().getAsDouble();
        return Math.sqrt(mean1) + average;
    }
}
