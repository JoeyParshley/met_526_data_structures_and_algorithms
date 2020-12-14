package cs526.module4;

import java.util.Arrays;

public class sorting {

  public static void sortForK(int[] arr, int k, int start, int end) {
    if (start > end){
      return;
    }

    else {
      if(arr[start] >= k){
        int temp  = arr[start];  // constant
        arr[start] = arr[end];
        arr[end] = temp;

        sortForK(arr, k, start, end - 1);  // linear O(N)
      } else {
        sortForK(arr, k,start + 1, end);  // linear O(N)
      }
    }
  }

  public static void main(String[] args) {
    int[] myArray = {4,45,13,6,9,2,3,595,23,20,1,99,0,2,1,10};
    int k = 10;
    System.out.println("Array before sorting based on k = " + k);
    System.out.println(Arrays.toString(myArray));
    System.out.println();
    sortForK(myArray, k, 0, myArray.length - 1);
    System.out.println("Array after sorting based on k = " + k);
    System.out.println(Arrays.toString(myArray));
    System.out.println();

  }
}
