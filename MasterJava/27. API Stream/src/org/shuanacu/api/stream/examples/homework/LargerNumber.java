package org.shuanacu.api.stream.examples.homework;

import java.util.Arrays;

public class LargerNumber {

    public static void main(String[] args) {
        int[] array = {2, 6, 88, 43, 8};

        int largetNumber = Arrays.stream(array).summaryStatistics().getMax();
        System.out.println(largetNumber);

    }

}
