package cs526.module1.dataStructures.arrays;
import java.util.Arrays;

public class Scoreboard {
  private int numEntries = 0;         // Number of actual entries currently stored in the array
  private  GameEntry[] board;         // Array of GameEntry objects (names and scores)

  public Scoreboard(int capacity){
    board = new GameEntry[capacity];  // creates an empty array with the given capacity
  }

  /**
   * Inserts a new element into the array. If the array is not full, the new element is inserted
   * into the appropriate position in the array (the array elements are sorted). If the array is
   * full AND the new element score is higher than the lowest score in the array, the element with
   * the lowest score is removed from the array and the new element is inserted in the appropriate
   * position
   *
   * @param e
   */
  public void add(GameEntry e) {
    int newScore = e.getScore();
    /*
     if the board array is not full just add the element, otherwise make sure the score is higher
     than the current lowest score in the board
    */
    if (numEntries < board.length || newScore > board[numEntries - 1].getScore()){
      // if the board is not full don't drop any scores
      if (numEntries < board.length){
        // increment the number of entries
        numEntries++;
        // shift any lower scores rightward to make room for the new entry
        int j = numEntries - 1;
        // start at the last item in the array (which should be the lowest score)
        while (j > 0 && board[j-1].getScore() < newScore) {
          // if the element before the current one is lower shift entry from j-1 to j
          // by setting the current element `board[j]` to the one to the left
          // board[j-1]
          board[j] = board[j-1];
          // decrement j
          j--;
        }
        // add the new entry
        board[j] = e;
      }

    }

  }

  /**
   * Removes the element located and the index passed in and shifts all the elements with
   * lower scores upward.
   * @param i   :  index of the elment in the array
   * @return    :  returns the element to be removed
   * @throws IndexOutOfBoundsException
   */
  public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= numEntries)
      throw new IndexOutOfBoundsException("Invalid index: " + i);

    // save the GameEntry object to be removed in `temp`
    GameEntry temp = board[i];

/*
    loop up through the Game Entries form index i move each cell to the left and null out the
    last score.
*/
    for (int j = i; j < numEntries - 1; j++){
      // shift the current element to the right by assigning the next element to it
      board[j] = board[j+1];
    }

    // null out the last element in the array
    board[numEntries - 1] = null;

    // decrease the number of entries
    numEntries--;

    // return the removed object
    return temp;
  }

  /** Returns a string representation of the high scores list. */
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (int j = 0; j < numEntries; j++) {
      if (j > 0)
        sb.append(", ");                   // separate entries by commas
      sb.append(board[j]);
    }
    sb.append("]");
    return sb.toString();
  }

  /**
   * The main method used to drive the insertaion and removal of elements
   * @param args
   */
  public static void main(String[] args) {
    Scoreboard highscores = new Scoreboard(4);
    String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul"};
    int[] scores = {750, 1105, 590, 740, 510, 860, 740};

    for (int i = 0; i < names.length; i++){
      GameEntry gE = new GameEntry(names[i], scores[i]);

      System.out.println("Adding " + gE);
      highscores.add(gE);
      System.out.println("Scoreboard: " + highscores);
    }
    System.out.println("Removing score at index " + 2);
    highscores.remove(2);
    System.out.println(highscores);
    System.out.println(highscores);
    System.out.println("Removing score at index " + 0);
    highscores.remove(0);
    System.out.println(highscores);
    System.out.println("Removing score at index " + 1);
    highscores.remove(1);
    System.out.println(highscores);
    System.out.println("Removing score at index " + 0);
    highscores.remove(0);
    System.out.println(highscores);
  }
}
