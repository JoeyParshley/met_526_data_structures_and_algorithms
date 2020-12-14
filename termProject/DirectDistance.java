package cs526.termProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class used to track the information off of the direct_distance file
 */
public class DirectDistance {
  private String filename = "";
  private String line = "";
  private String [] words = new String[0];
  private Map<String, Integer> nodeIndexMap = new HashMap<>();
  private Map<String, Integer> distanceIndexMap = new HashMap<>();
  private int index = 0;

  public DirectDistance(String filename){
    this.filename = filename;
    try {
      Scanner file = new Scanner(new File(filename));
      // get every line of the file
      while (file.hasNextLine()){
        line = file.nextLine();
        // remove the whitespace and separate each line into its "words"
        words = line.split("\\s");
        this.nodeIndexMap.put(words[0], index++);
        this.distanceIndexMap.put(words[0], Integer.parseInt(words[1]));
      }
    } catch (FileNotFoundException exception) {
      System.err.println(exception.getMessage() + ": File not found. Exiting.");
      System.exit(0);
    } catch (Exception exception) {
      System.err.println(exception.getMessage());
      exception.printStackTrace();
      System.exit(0);
    }
  }

  public Map<String, Integer> getIndexMapFromFile(){
    return this.nodeIndexMap;
  }

  public Map<String, Integer> getDistanceIndexMapFromFile(){
    return this.distanceIndexMap;
  }
}
