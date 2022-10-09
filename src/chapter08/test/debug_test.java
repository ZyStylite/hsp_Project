package chapter08.test;

import java.util.Arrays;

public class debug_test {
    public static void main(String[] args) {
        int sum = 0;
        int[] arr = {3, -2, 33, 25};
        Arrays.sort(arr);
        for (int value : arr) {
//            sum = sum + arr[i];
            System.out.println(value);
//            System.out.println(sum);
        }
    }
}
