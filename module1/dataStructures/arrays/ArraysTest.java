package cs526.module1.dataStructures.arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraysTest {
  public static void main(String[] args) {
    int [] A = {1, 2, 3, 4, 5};

    int [] copyOfA = Arrays.copyOf(A, A.length);

    System.out.println("Array A: " + Arrays.toString(A));
    System.out.println("Array copyOfA:" + Arrays.toString(copyOfA));

    System.out.println("Array A equals copyof A is " + Arrays.equals(A, copyOfA));

    Arrays.fill(copyOfA, 10);

    System.out.println("Array copyOfA after filling with 10: " + Arrays.toString(copyOfA));

    System.out.println("Array A equals Array copyof A is " + Arrays.equals(A,copyOfA));

    int[] C = Arrays.copyOfRange(A, 1, 4);

    System.out.println("Array C: " + Arrays.toString(C));

    int position = Arrays.binarySearch(A, 3);
    System.out.println("Index of 3 in Array A is: " + position);

    Arrays.sort(A);
    System.out.println("Array A: " + Arrays.toString(A));

    /**
     * Random numbers
     */

    int data[] = new int[10];
    System.out.println("data = " + Arrays.toString(data));

    Random rand = new Random();
    rand.setSeed(System.currentTimeMillis());

    for (int i = 0; i < data.length; i++){
      data[i] = rand.nextInt(100);
    }
    System.out.println("data = " + Arrays.toString(data));

    int[] orig = Arrays.copyOf(data, data.length);
    System.out.println("orig = " + Arrays.toString(orig));

    System.out.println("arrays equal before sort: " + Arrays.equals(data, orig));

    Arrays.sort(data);

    System.out.println("arrays equal after sort: " + Arrays.equals(data,orig));
    System.out.println("orig = " + Arrays.toString(orig));
    System.out.println("data = " + Arrays.toString(data));
  }
}
