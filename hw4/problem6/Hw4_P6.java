package cs526.hw4.problem6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * Program to observe the differences among the HashMap, ArrayList, and LinkedList
 * Java data structures in terms of insertion time and search time.
 */

public class Hw4_P6 {

  /**
   * Generates an array of random integers using the Random() method
   * @param count     :   Number of the elements to be in the array
   * @param maxRange  :   Top of the range to be used for the integers (1 - maxRange)
   * @return          :   int type array filled with random integers
   */
  public static int[] generateRandomIntegerArray(int count, int maxRange){
    int[] myArray = new int[count];
    Random random = new Random();

    for (int i = 0; i < count; i++){
      // Assign a random integer to each element in the array
      myArray[i] = random.nextInt(maxRange) + 1;
    }

    return myArray;
  }

  /**
   * Populates a HashMap with the contents of an integer type array
   * @param map   : Integer type HashMap to be populated
   * @param arr   : Integer type array used to populate the HashMap
   * @return      : HashMap populated with the contents of `arr` Array
   */
  public static HashMap<Integer,Integer> populateHashMap(HashMap<Integer,Integer> map, int[] arr){
    for (int i = 0; i < arr.length; i++){
      map.put(i,arr[i]);
    }
    return map;
  }

  /**
   * Searches a HashMap for each element of an integer type array
   * @param map   : Integer type HashMap to be searched
   * @param arr   : Integer type array used to search the HashMap
   */
  public static void searchHashMap(HashMap<Integer, Integer> map, int[] arr){
    for (int i = 0; i < arr.length; i++){
      map.containsKey(arr[i]);
    }
  }

  /**
   * Populates a ArrayList with the contents of an integer type array
   * @param list  : Integer type ArrayList to be populated
   * @param arr   : Integer type array used to populate the ArrayList
   * @return      : ArrayList populated with the contents of `arr` Array
   */
  public static ArrayList<Integer> populateArrayList(ArrayList<Integer> list, int[] arr){
    for (int i = 0; i < arr.length; i++){
      list.add(arr[i]);
    }
    return list;
  }

  /**
   * Searches a ArrayList for each element of an integer type array
   * @param list  : Integer type ArrayList to be searched
   * @param arr   : Integer type array used to search the ArrayList
   */
  public static void searchArrayList(ArrayList<Integer> list, int[] arr){
    for (int i = 0; i < arr.length; i++){
      list.contains(arr[i]);
    }
  }

  /**
   * Populates a LinkedList with the contents of an integer type array
   * @param list  : Integer type LinkedList to be populated
   * @param arr   : Integer type array used to populate the LinkedList
   * @return      : LinkedList populated with the contents of `arr` Array
   */
  public static LinkedList<Integer> populateLinkedList(LinkedList<Integer> list, int[] arr){
    for (int i = 0; i < arr.length; i++){
      list.add(arr[i]);
    }
    return list;
  }

  /**
   * Searches a LinkedList for each element of an integer type array
   * @param list  : Integer type LinkedList to be searched
   * @param arr   : Integer type array used to search the LinkedList
   */
  public static void searchLinkedList(LinkedList<Integer> list, int[] arr){
    for (int i = 0; i < arr.length; i++){
      list.contains(arr[i]);
    }
  }

  public static void main(String[] args) {
    // Declare local variables to be used to calculate the elapsed times of the various methods
    long startTimeInsertHash, endTimeInsertHash, elapsedTimeInsertHash = 0;
    long startTimeInsertArrayList, endTimeInsertArrayList, elapsedTimeInsertArrayList = 0;
    long startTimeInsertLinkedList, endTimeInsertLinkedList, elapsedTimeInsertLinkedList = 0;
    long startTimeSearchHash, endTimeSearchHash, elapsedTimeSearchHash = 0;
    long startTimeSearchArrayList, endTimeSearchArrayList, elapsedTimeSearchArrayList = 0;
    long startTimeSearchLinkedList, endTimeSearchLinkedList, elapsedTimeSearchLinkedList = 0;
    // Declare Constants
    int ARRAY_SIZE = 100000;

    /**
     * Create the following instances:
     *    myMap         : Hashmap
     *    myArrayList   : ArrayList
     *    myLinkedList  : LinkedList
     */
    HashMap<Integer, Integer> myMap = new HashMap<>();
    ArrayList<Integer> myArrayList = new ArrayList<>();
    LinkedList<Integer> myLinkedList = new LinkedList<>();

    /**
     * Declare two integer type arrays `insertKeys` and `searchKeys` used to hold the randomly
     * generated integers used during the experiments
     */
    int[] insertKeys = new int[ARRAY_SIZE];
    int[] searchKeys = new int[ARRAY_SIZE];

    /**
     * Repeat the following 10 times
     *    -   generate 100,000 random integers in the range [1, 1,000,000]
     *        and store them in the insertKeys array
     *    -   insert all keys in insertKeys [ ] into myMap and measure the total insert time
     *    -   insert all keys in insertKeys [ ] into myArrayList and measure the total insert time
     *    -   insert all keys in insertKeys [ ] into myLinkedList and measure the total insert time
     *    -   generate 100,000 random integers in the range of [1, 2,000,000] and store them
     *        in the `searchKeys` array
     *
     *    - search `myMap` for all the keys in `searchKeys[ ]` and measure the total time
     *    - search `myArrayList` for all the keys in `searchKeys[ ]` and measure the total time
     *    - search `myLinkedList` for all the keys in `searchKeys[ ]` and measure the total time
     *
     */
    for (int i = 0; i < 10; i++){
      // populate insertKeys with random integers
      insertKeys = generateRandomIntegerArray(ARRAY_SIZE, 1000000);
      searchKeys = generateRandomIntegerArray(ARRAY_SIZE, 2000000);
      // clear out each data structure
      myMap.clear();
      myArrayList.clear();
      myLinkedList.clear();

      // insert all keys in insertKeys [ ] into myMap and determine elapsed time
      startTimeInsertHash = System.currentTimeMillis();
      myMap = populateHashMap(myMap, insertKeys);
      endTimeInsertHash = System.currentTimeMillis();
      elapsedTimeInsertHash += endTimeInsertHash - startTimeInsertHash;

      // insert all keys in insertKeys [ ] into myArrayList and determine elapsed time
      startTimeInsertArrayList = System.currentTimeMillis();
      myArrayList = populateArrayList(myArrayList, insertKeys);
      endTimeInsertArrayList = System.currentTimeMillis();
      elapsedTimeInsertArrayList += endTimeInsertArrayList - startTimeInsertArrayList;

      // insert all keys in insertKeys [ ] into myLinkedList and determine elapsed time
      startTimeInsertLinkedList = System.currentTimeMillis();
      myLinkedList = populateLinkedList(myLinkedList, insertKeys);
      endTimeInsertLinkedList = System.currentTimeMillis();
      elapsedTimeInsertLinkedList += endTimeInsertLinkedList - startTimeInsertLinkedList;

      // search all keys in insertKeys [ ] into myMap and determine elapsed time
      startTimeSearchHash = System.currentTimeMillis();
      searchHashMap(myMap, searchKeys);
      endTimeSearchHash = System.currentTimeMillis();
      elapsedTimeSearchHash += endTimeSearchHash - startTimeSearchHash;

      // search all keys in insertKeys [ ] into myArrayList and determine elapsed time
      startTimeSearchArrayList = System.currentTimeMillis();
      searchArrayList(myArrayList, searchKeys);
      endTimeSearchArrayList = System.currentTimeMillis();
      elapsedTimeSearchArrayList += endTimeSearchArrayList - startTimeSearchArrayList;

      // search all keys in insertKeys [ ] into myLinkedList and determine elapsed time
      startTimeSearchLinkedList = System.currentTimeMillis();
      searchLinkedList(myLinkedList, searchKeys);
      endTimeSearchLinkedList = System.currentTimeMillis();
      elapsedTimeSearchLinkedList += endTimeSearchLinkedList - startTimeSearchLinkedList;
    }

    // Out put results
    System.out.printf("%nNumber of keys = %d%n%n", insertKeys.length);
    System.out.printf("HashMap average total insert time = %.3f%n",
        (double)elapsedTimeInsertHash / 10.0);
    System.out.printf("ArrayList average total insert time = %.3f%n",
        (double)elapsedTimeInsertArrayList / 10.0);
    System.out.printf("LinkedList average total insert time = %.3f%n",
        (double)elapsedTimeInsertLinkedList / 10.0);
    System.out.printf("%nNumber of keys = %d%n%n", searchKeys.length);
    System.out.printf("HashMap average total search time = %.3f%n",
        (double)elapsedTimeSearchHash / 10.0);
    System.out.printf("ArrayList average total search time = %.3f%n",
        (double)elapsedTimeSearchArrayList / 10.0);
    System.out.printf("LinkedList average total search time = %.3f%n",
        (double)elapsedTimeSearchLinkedList / 10.0);

  }
}
