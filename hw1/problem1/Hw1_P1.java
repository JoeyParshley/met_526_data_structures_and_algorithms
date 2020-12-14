package cs526.hw1.problem1;

public class Hw1_P1 {
	/**
	 * Calculates the maximum, minimum, and average of an array of integers and prints them out.
	 * @param a	array of integer types
	 */
	public static void stats(int[] a) {
		// instance variables
		// initially set max and min to the first element in the array 'a'
		int max = a[0];
		int min = a[0];
		int sum = 0;
		double average;


		for (int i = 0; i < a.length; i++){
			/**
			 * If the current element has a value greater than 'max' assign it to 'max'
 			 */
			if ( a[i] > max){ max = a[i]; }
			/**
			 * If the current element has a value lower than 'min' assign it to 'max'
			 */
			if ( a[i] < min){ min = a[i]; }

			// sum up all of the elements to be used when calculating the average
			sum += a[i];
		}
		/**
		 * cast 'sum' to a float to get a float when dividing by the array length wich is an integer
		 */
		average = (float)sum / a.length;

		/**
		 * Display the average, min and max elements of the array.
		 */
		System.out.printf("%naverage = %.2f, min = %d, max = %d%n", average, min, max);
	}

	/**
	 * Creates a subarray of a given array and prints it out.
	 * @param a				an array of integers
	 * @param from		The index of an element in `a` that will be the first element in the subarray
	 * @param to			The index of an element in `a` that will be the last element in the subarray
	 */
	public static void subarray(int[] a, int from, int to) {
		// error check w/o using Java's exception handling
		if (from < 0 || to >= a.length) {
			System.out.println("Index out of bound");
			return;
		}

		/**
		 * Display the indicies of the subaray along with the elements in the subarray.
		 */
		System.out.printf("%nThe subarray from index %d to index %d, is: ", from, to);
		for (int i = from; i < to; i++){
      System.out.print(a[i] + ", ");
		}
    System.out.print(a[to]);
    System.out.println();
	}

	/**
	 * main method use to drive the stats() and subarray(a) methods
	 * @param args
	 */
	public static void main(String[] args) {
		
		// declare and initialize and array of integers
		int[] a = {15, 25, 10, 65, 30, 55, 65};

		// Display the given array
		System.out.print("\nGiven array is: " );
		for (int i = 0; i < a.length-1; i++){
      System.out.print(a[i] + ", ");
		}
    System.out.print(a[a.length - 1]);
    System.out.println();

		/**
		 * call the 'stats' static method passing in the array 'a' in order to display the array stats
		 */
		stats(a);

		/**
		 * call the 'subarray' static method passing in sample 'from' and 'to' indices to display
		 * the subarray elements
		 */
		subarray(a, 1, 4);

		/**
		 * Test the 'stats' and 'subarray' behavior with a different array and subarray indices
		 */
		int[] b = {8, 30004, -264, 0, 21, 5, 6, 34};
		System.out.print("\nGiven array is: " );
		for (int i = 0; i < b.length-1; i++){
			System.out.print(b[i] + ", ");
		}
		System.out.print(b[b.length - 1]);
		System.out.println();

		stats(b);
		subarray(b, 3, 6);
	}

}
