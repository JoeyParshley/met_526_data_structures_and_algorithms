package cs526.hw4.problem6;

public class chaining {
  public static void main(String[] args) {
    int[] kValues = {5, 8, 44, 23, 30, 34, 52, 32, 15, 16};
    int N = 11;

    for (int i = 0; i < kValues.length; i++){
      System.out.printf("%d mod %d is: %d%n", kValues[i], N, kValues[i] % N);
    }
  }
}
