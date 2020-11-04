package com.app.tobeprecise.utils;

import java.util.Arrays;

public class MathUtils {

    public static double calculateStandardDeviation(double[] array) {
        double n= array.length;
        double sum = Arrays.stream(array).sum();
        double mean = sum / n;
        sum=0;
        for (double v : array) sum += Math.pow((v - mean), 2);
        mean=sum/(n-1);
        return Math.sqrt(mean);
    }
}
