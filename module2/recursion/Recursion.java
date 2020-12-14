package cs526.module2.recursion;

import java.util.Arrays;
import jdk.swing.interop.SwingInterOpUtils;

public class Recursion {
    public static int factorial (int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();   // must be non negative
        }
        // base case
        else if ( n == 0){
            return 1;
        }
        // recursive case
        else {
            return  n * factorial(n - 1);
        }
    }

    public static boolean binarySearch(int[] data, int target, int low, int high){
        if (low > high) {
            return false; // interval empty, no match
        }
        else {
            int mid = (low + high) / 2;

            if (target == data[mid]) {
                return true;    // target found
            }
            else if (target < data[mid]){
                // recurse left of the middle
                return binarySearch(data, target, low, mid - 1);
            }
            else{
                // recurse right of the middle
                return  binarySearch(data, target, mid + 1, high);
            }
        }
    }

    public static void printArrayRecursively(int[] data, int i){

        if (i == data.length) {
            return;
        }
        else {
            System.out.print(data[i++] + " ");
            printArrayRecursively(data, i);
        }

    }

    public static void printReverse(int[] data, int n){
        if (n == 0){
            return;
        }
        else {
            System.out.print(data[n - 1] + " ");
            printReverse(data, n - 1);
        }
    }

    /**
     * reverseArray   : This recursive method reverses the `n` elements of an array `a`
     *                  so that the first element becomes the laste, the second element
     *                  becomes the second to last, and so on.
     *                  It is done with linear recursion by observing that a sequence
     *                  can be achieved by swapping the first and last elements and then
     *                  recursively
     * @param a
     * @param low
     * @param high
     */
    public static void reverseArray(int[]a, int low, int high){
        // If there are at least two elements in the subarray
        if (low < high){
            // create a temp variable to hold the value at the low index
            int temp = a[low];
            // assign the value of the element at the hish index to the low index
            a[low] = a[high];
            // assign the value of temp to the hish index
            a[high] = temp;
            // call the recursive app incrementing and decrementing the low and high indicies
            reverseArray(a, low + 1, high - 1);
        }
    }

    /**
     * evenBeforeOd take an array and places the odd integer at the end of the array and even
     * at the beginning.
     * @param a
     * @param length
     */
    public static void evenBeforeOdd(int[] a, int length){
        if (length == 0){
            return;
        } else if(a[length - 1] % 2 == 0) {
            for (int i=0; i < length - 1; i++){
                if(a[i] % 2 != 0){
                    int temp = a[i];
                    a[i] = a[length - 1];
                    a[length - 1] = temp;

                    evenBeforeOdd(a, length - 1);
                }
            }
        } else {
            evenBeforeOdd(a, length - 1);
        }
    }

    int method7( int m, int n){
        if ((m == 0) || (n==0))return 0;
        else if (n > 0) return m + method7(m, n - 1);
        else {
            if (m > 0) return method7(-n, m);
            else return method7(-m, -n);
        }
    }

    public static int method6(int a, int b){
        if (b ==0){
            return 1;
        } else {
            int x = method6(a, b/3);
            int y = 2 * x;
            if (b % 2 == 1){
                y = y + a;
            }
            return y;
        }
    }

    public static int method5(int a, int n){
        if ( n < 1) return 1;
        else {
            int x = n;
            while (x >= 1){
                a = a + a;
                x = x - 1;
            }
            return (a + method5(a, n - 1));
        }
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] searches = {-1, 0, 2, 5, 11, 100};

        //    for (int i = 0; i < numbers.length; i++){
        //      System.out.printf("The factorial of %d is %d%n", numbers[i], factorial(numbers[i]));
        //    }
        //
        //    for (int i = 0; i < searches.length; i++){
        //      System.out.printf("%n%d is present in %s is: %b%n",
        //          searches[i],
        //          Arrays.toString(numbers),
        //          binarySearch(numbers, searches[i], 0, numbers.length - 1));
        //    }
        //    System.out.println();
        //    System.out.println();
        //    printArrayRecursively(numbers,0);
        //    System.out.println();
        //    printArrayRecursively(searches,0);
        //
        //    System.out.println();
        //    System.out.println();
        //    printReverse(numbers,numbers.length);
        //    System.out.println();
        //    printReverse(searches,searches.length);

//        System.out.println("Initial Array");
//        System.out.println(Arrays.toString(numbers));
        System.out.println(method5(2, 3));
//        System.out.println();
//        System.out.println();
//        reverseArray(numbers,0,5);
//        System.out.println("Array after reverse:");
//        System.out.println(Arrays.toString(numbers));

//        System.out.println();
//        System.out.println();
//        evenBeforeOdd(numbers, numbers.length);
//        System.out.println("Array after reverse:");
//        System.out.println(Arrays.toString(numbers));
    }
}
