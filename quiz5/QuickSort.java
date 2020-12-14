package cs526.quiz5;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args){
        int[] a = {42, 10, 17, 45, 57, 31, 9, 5, 31, 29};

        partition(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void partition(int[] a, int x, int y) {
        int left = x;
        int right = y - 1;
        int z = a[y];

        while (left <= right){
            while (left <= right && a[left] < z){
                left += 1;
            }
            while (left <= right && a[right] > z){
                right -= 1;
            }
            if (left <= right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left += 1;
                right -= 1;
            }
        }
        int temp = a[left];
        a[left] = a[y];
        a[y] = temp;
    }
}
