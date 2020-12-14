package cs526.module1.dataStructures.arrays;

/**
 * Represents thj
 */
public class GameEntry {
  private  String name;
  private int score;

  /**
   * Constructor
   * @param n
   * @param s
   */
  public GameEntry(String n, int s) {
    this.name = n;
    this.score = s;
  }

  /**
   * returns the name field
   * @return      String - name
   */
  public String getName() {
    return name;
  }

  /**
   * returns the score field
   * @return int - score
   */
  public int getScore() {
    return score;
  }

  /**
   * returns the string representation of the GameEntry object
   * overwrites the toString() method in the Object class
   * @return Formatted string "(Joey, 89)"
   */
  public String toString(){
    return "(" + name + ", " + score + ")";
  }
}

