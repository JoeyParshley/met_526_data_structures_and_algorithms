package cs526.module1.dataStructures.arrays;

public class InsertionSort {
  // Insertion sort of an array of characters into non decreasing order
  public static void insertionSort(char[] data) {
    int n = data.length;
    // begin with the second character and scan the elements to the right
    for (int k = 1; k < n; k++){
      // hold the current character in a temp variable
      char cur = data[k];
      // find the correct index j for cur
      int j = k;
      // in each iteration data[k] is moved to the right position
      while (j > 0 && data[j - 1] > cur){
        /**
         * index j is used as a pointer that scans the elements to the left of data[k] (cur) in each
         * iteration cur is compared with previous element data[j - 1] and if data[j - 1] i slarger
         * than cur, it is shifted to the right data[j] = data[j - 1]. Then j gets decrimented and
         * the same is repeated unitl data[j - 1] is smaller thatn or equal to cur or j becomes 0.
         * Once this occurs data[j] is the correct position of cur
         */
        System.out.printf("data[%d]: %c, cur: %c, data[%d]: %c%n", k, data[k], cur, j - 1, data[j - 1]);
        data[j] = data[j - 1];
        j--;
      }
      // this is the proper place to put cur
      data[j] = cur;
    }
  }

  public static void main(String[] args) {
    char[] a = {'B', 'C', 'D', 'A', 'E', 'H', 'G', 'F'};
    System.out.println(java.util.Arrays.toString(a));
    insertionSort(a);
    System.out.println(java.util.Arrays.toString(a));
  }
}
