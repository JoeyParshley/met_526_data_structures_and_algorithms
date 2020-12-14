package cs526.hw2.problem4;

import java.util.Arrays;

public class Hw2_P4 {

    /**
     * reverseFirstN  : this method receives two arguments, an integer array `a`
     *                  and an integer `n`. It reverses the order of the first `n`
     *                  elements in the given array `a`. No additional arrays are used.
     * @param a       : integer array
     * @param n       : integer representing the length of the subarray of `a` to be reversed
     *
     *                : output : there is no return to this method however it does modify the
     *                  original array since it is passed in by reference
     */
    public static void reverseFirstN(int[] a, int n){
        // base case is when the low index is no longer less than the high index
        int low = 0;
        int high = n -1;

        reverseFirstN(a, low, high);

    }

    /**
     * reversFirstN    : Recursive helper method used to reverse a subarray of integers. It
     *                   receives three arguments, an integer array `a`, a beginning index of the
     *                   subarray `low` and a the an ending index of the array `high`.
     * @param a        : integer array
     * @param low      : integer representing the first index of the subarray
     * @param high     : integer representing the last index of the subarray
     *
     *                 : output : there is no return to this method however it does modify the
     *                   original array since it is passed in by reference
     *
     */
    private static void reverseFirstN(int[]a, int low, int high){
        // The base case of this swap is when the high index is no longer greater than the low index
        if (low < high) {
            // use a temp variable to hold the value of the element at the `low` index of the array
            int temp = a[low];
            // set the value of the low index of the subarray to the value at the high index
            a[low] = a[high];
            // set the value at the high index of the subarray to the value at the low index which
            // is currently being held in `temp`
            a[high] = temp;
            // recursive case. call the method recursively while incrementing the low index
            // and decrementing the high index before passing the indices in.
            reverseFirstN(a, ++low, --high);
        }
    }

    /**
     * evenBeforeOdd  : this recursive method receives an array of integers 'a'. It
     *                  rearranges the order of the integers in `a` in such a way that
     *                  all the even integers come before the odd integers. No
     *                  additional arrays are used
     * @param a       : array of integers
     *                : output : there is no return to this method however it does modify the
     *                  original array since it is passed in by reference
     */
    public static void evenBeforeOdd(int[] a){
        evenBeforeOdd(a, a.length);
    }

    /**
     * evenBeforeOdd    : Recursive helper method that receives an integer array `a` and arranges
     *                    the odd integers after the even integers.
     * @param a         : array if integers
     * @param length    : length of the array `a`
     *                  : output : there is no return to this method however it does modify the
     *                    original array since it is passed in by reference
     */
    private static void evenBeforeOdd(int[] a, int length){

        // Base case is when the length of the sub-array is zero
        if (length == 0){
            return;
        } else if (a[length - 1] %2 == 0){
            /**
             * If the last element in the sub-array is even loop through the sub-array up to the end
             * of the current sub-array if any of those elements are odd, swap them with the end of the
             * current sub-array
             */
            for (int i = 0; i < length - 1; i++){
                if (a[i] % 2 != 0){
                    int temp = a[i];
                    a[i] = a[length - 1];
                    a[length - 1] = temp;
                    // recursively call the the method on the next element in from the end
                    evenBeforeOdd(a, length - 1);
                }
            }
        } else {
            // recursively call the the method on the next element in from the end
            evenBeforeOdd(a, length - 1);
        }
    }

    /**
     * main method to test the two recursive methods above.
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[10];

        for (int i=0; i<a.length; i++) {
            a[i]= (i+1) * 10;
        }

        System.out.println("Initial array: ");
        System.out.println(Arrays.toString(a));
        System.out.println();

        // make a copy and use it for testing
        int[] intArrayCopy;
        intArrayCopy = a.clone();

        int N = 2;
        reverseFirstN(intArrayCopy, N);
        System.out.println("\nAfter reversing first " + N + " elements: ");
        System.out.println(Arrays.toString(intArrayCopy));
        System.out.println();

        intArrayCopy = a.clone();
        N = 7;
        reverseFirstN(intArrayCopy, N);
        System.out.println("\nAfter reversing first " + N + " elements: ");
        System.out.println(Arrays.toString(intArrayCopy));
        System.out.println();

        int[] b = {10, 15, 20, 30, 25, 35, 40, 45};
        System.out.println("\nBefore rearrange: ");
        System.out.println(Arrays.toString(b));
        System.out.println();

        evenBeforeOdd(b);
        System.out.println("\nAfter rearrange: ");
        System.out.println(Arrays.toString(b));
        System.out.println();

    }
}
