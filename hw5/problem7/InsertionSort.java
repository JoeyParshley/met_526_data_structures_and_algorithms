package cs526.hw5.problem7;

// Java program for implementation of Insertion Sort
public class InsertionSort {

    /**
     * Sort performs a simple sort on `arr` by virtually splitting the array `arr` into
     * sorted and unsorted subarrays. Values from the unsorted subarray are picked and placed
     * at ther correct position in the sorted subarray.
     * @param arr
     */
    void sort(int arr[])
    {
        int n = arr.length;
        // Iterate through the array from 1 to n
        for (int i = 1; i < n; ++i) {
            // Holding the current element of arr in `key`
            int key = arr[i];
            // hold the index of the previous element in `arr`
            int j = i - 1;

            /**
             * compare the current element `key` to its previous element `a[i-1] = a[j]'
             * it the key's previous element is greater than the key element. compare the
             * key element to the elements before.
             */
            while (j >= 0 && arr[j] > key) {
                // move the greater elements one position up to make space for swapped element
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // move the current element
            arr[j + 1] = key;
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}