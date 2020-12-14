package cs526.hw5.problem7;

import java.util.Arrays;
import java.util.Random;

/**
 * Compare an observe how running times of sorting algorithms grow as the input size (number of
 * elements to be sorted) grows. The running time of the algorithm will be approximated using an
 * elpased time.
 *
 * <p>Four sorting algoritms are used - insertion-sort - merge-sort - quick-sort - heap-sort
 */
public class Hw5_P7 {

  /**
   * Generates an array of random integers using the Random() method
   *
   * @param count : Number of the elements to be in the array
   * @param maxRange : Top of the range to be used for the integers (1 - maxRange)
   * @return : int type array filled with random integers
   */
  public static int[] buildArray(int count, int maxRange) {
    int[] myArray = new int[count];
    Random random = new Random();

    for (int i = 0; i < count; i++) {
      // Assign a random integer to each element in the array
      myArray[i] = random.nextInt(maxRange) + 1;
    }

    return myArray;
  }

  public static void main(String[] args) {
    final int TOP_RANGE = 1000000;
    InsertionSort insertionSort = new InsertionSort();
    MergeSort mergeSort = new MergeSort();
    QuickSort quickSort = new QuickSort();
    HeapSort heapSort = new HeapSort();

    // for n = 10k, 20k, 30k, 40k, 50k, 60k, 70k, 80k, 90k, 100k values of n
    System.out.printf("%-13s","n");
    for (int n = 10000; n <= 100000; n += 10000){
        // print out the table header
        System.out.printf("%8d ",n);
    }
    // print the first column of the insertion sort row
    System.out.printf("%n%-12s ","Insertion");
    for (int n = 10000; n <= 100000; n += 10000) {
      // create an array of n random integers
      int[] myArray = buildArray(n, TOP_RANGE);
      int[] insertionSortArray = myArray.clone();
      new SortingComparison(insertionSortArray,1).runComparison(insertionSortArray);
    }

    // print the first column of the merge sort row
    System.out.printf("%n%-12s ","Merge");
    for (int n = 10000; n <= 100000; n += 10000) {
      // create an array of n random integers
      int[] myArray = buildArray(n, TOP_RANGE);
      int[] mergeSortArray = myArray.clone();
      new SortingComparison(mergeSortArray,2).runComparison(mergeSortArray);
    }

    // print the first column of the quick sort row
    System.out.printf("%n%-12s ","Quick");
    for (int n = 10000; n <= 100000; n += 10000) {
      // create an array of n random integers
      int[] myArray = buildArray(n, TOP_RANGE);
      int[] quickSortArray = myArray.clone();
      new SortingComparison(quickSortArray,3).runComparison(quickSortArray);
    }

    // print the first column of the insertion sort row
    System.out.printf("%n%-12s ","Heap");
    for (int n = 10000; n <= 100000; n += 10000) {
      // create an array of n random integers
      int[] myArray = buildArray(n, TOP_RANGE);
      int[] heapSortArray = myArray.clone();
      new SortingComparison(heapSortArray,4).runComparison(heapSortArray);
    }
  }
}
