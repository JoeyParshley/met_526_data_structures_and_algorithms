package cs526.termProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GraphInput {
  private String line = "";
  private String [] distances = new String[0];
  private Map<String, Integer> distancesMap = new HashMap<>();
  private int row = 0;
  private int col = 0;
  private int size = 0;
  private int[][] nodeDistances = null;

  public int[][] getMatrixFromFile(String filename){
    try {
      Scanner file = new Scanner(new File(filename));
      // get every line of the file
      while (file.hasNextLine()){
        line = file.nextLine();
        // skip the first line
        if (row == 0){
          row++;
          continue;
        }
        // remove the whitespace and split each line into words Array of Strings
        distances = line.split("\\s+");

        // Intantiat the nodeDistances Array
        if (nodeDistances == null) {
          size = distances.length;
          nodeDistances = new int[size][size];
        }

        // Loop through columns of the distances Array
        for (int col = 0; col < size; col++){
          if (col == 0){
            continue;
          }
          nodeDistances[row - 1][col - 1] = Integer.parseInt(distances[col]);
        }
        // increment the while loop counter
        row++;
      }
    } catch (FileNotFoundException exception) {
      System.err.println(exception.getMessage() + ": File not found . Exiting." );
      System.exit(0);
    } catch (Exception exception){
      System.err.println(exception.getMessage());
      exception.printStackTrace();
      System.exit(0);
    }
    return nodeDistances;
  }
}
