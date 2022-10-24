package by.mopahta.laba.task7;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {

    public void testFunction () {
        Random random = new Random();

        int n = random.nextInt(20, 30);
        double[] arr = new double[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * 50 - 25;
        }
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    private void sortArray (double[] arr) {
        double temp;
        double eps = 0.001;

        for (int i = 0; i < arr.length - 1; ) {
            if ((arr[i+1] > arr[i])
                    || (Math.abs(arr[i+1] - arr[i]) < eps)) {
                i++;
            } else {
                temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
                if (i != 0) {
                    i--;
                }
            }
        }
    }
}
