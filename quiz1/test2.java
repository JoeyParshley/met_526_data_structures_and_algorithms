package cs526.quiz1;

import java.util.Arrays;

public class test2 {
  public static void main(String[] args) {
    String[] sa = {"data", "structures", "and", "algorithms"};
    String[] sb = sa;

    Arrays.sort(sb);

    String[] sc = {"data", "structures", "and", "algorithms"};
    String[] sd = sc.clone();
    Arrays.sort(sd);

    System.out.println("sa: " + Arrays.toString(sa));
    System.out.println("sc: " + Arrays.toString(sc));
  }
}
