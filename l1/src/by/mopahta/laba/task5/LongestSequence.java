package by.mopahta.laba.task5;

import java.util.Arrays;
import java.util.Random;

public class LongestSequence {

    public void testFunction () {

        Random random = new Random();
        int n = random.nextInt(10, 30);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(getMinElementQuantity(arr));
    }


    public int getMinElementQuantity (int[] arr) {
        int temp;
        int result = 0;

        temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < temp) {
                result++;
            } else {
                temp = arr[i];
            }
        }
        return result;
    }

}
