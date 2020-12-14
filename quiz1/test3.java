package cs526.quiz1;

public class test3 {
  public static void main(String[] args) {
    int x = 10;
    int y = 20;

    for (int i = 0; i < 6; i++){
      x = y + 5;
      y = x - 1;
      x = 2 * y;
      y = y / 2;
      System.out.println("x: " + x);
      System.out.println("y: " + y);
      System.out.println();
    }
  }
}
