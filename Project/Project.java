package cs526.Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Project {
  /**
   * File locations
   */
  public static final String GRAPH_FILE_NAME = "src/cs526/Project/graph_input.txt";
  public static final String DIRECT_DISTANCES_FILENAME = "src/cs526/Project/direct_distance.txt";

  // build two dimensional array of the node connection values skipping the letters row and columns from the graph_input file
  public static String[][] getNodeConnectionMatrix(String filePath) {
    String lineFromFile = "";
    String [] distances = null;
    int row = 0;
    int size = 0;
    String[][] connectionMatrix = null;

    try {
      Scanner fileInput = new Scanner (new File(filePath));

      // Get one line at a time and repeat the same process for all expressions in the input file.
      while (fileInput.hasNextLine()) {

        // Get the next line
        lineFromFile = fileInput.nextLine();
        //remove the white space split the string lineFromFile using spaces...produces an Array of Strings
        distances = lineFromFile.split("\\s+");

        // Instantiate the connection n x n matrix array where n is the number of the lines in the file
        if (connectionMatrix == null) {
          size = distances.length;
          connectionMatrix = new String[size][size];
        }

        // loop through the columns in the current row of the distances Array
        for (int col = 0; col < size; col++){
          // set the current element in the matrix to the distance from the distances array
          connectionMatrix[row][col] = distances[col];
        }
        // increment the row counter
        row++;
      }
    }
    // File not found
    catch (FileNotFoundException ex) {
      System.err.println(ex.getMessage() + ": File not found. Exiting.");
      System.exit(0);
    }

    // Something else went wrong. Catch all
    catch (Exception ex) {
      System.err.println(ex.getMessage());
      ex.printStackTrace();
      System.exit(0);
    }
    return connectionMatrix;
  }

  public static Map<String,Integer> getMapOfNodesFromFile(String filePath) {
    String lineFromFile = "";
    String [] tokens = null;
    Map<String,Integer> mapOfTokens = new HashMap<>();
    Map<String,Integer> directDistanceIndexMap = new HashMap<>();
    int index = 0;

    try {
      Scanner fileInput = new Scanner (new File(filePath));

      // Get one line at a time and repeat the same process for all expressions in the input file.
      while (fileInput.hasNextLine()) {

        // Get the next line
        lineFromFile = fileInput.nextLine();

        //Split the string fromFile using spaces...produces an Array of Strings
        tokens = lineFromFile.split("\\s+");

        mapOfTokens.put(tokens[0],Integer.parseInt(tokens[1]));
        directDistanceIndexMap.put(tokens[0], index++);
       }
    }
    // File not found
    catch (FileNotFoundException ex) {
      System.err.println(ex.getMessage() + ": File not found. Exiting.");
      System.exit(0);
    }

    // Something else went wrong. Catch all
    catch (Exception ex) {
      System.err.println(ex.getMessage());
      ex.printStackTrace();
      System.exit(0);
    }
    return mapOfTokens;
  }

  /**
   * Program to find Z
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception{
    /**
     *  Read in the direct distance file and store the node names and direct distances
     *  in their own ArrayLists called nodeNames and directDistances respectively
     */
    // Initialize the ArrayLists to hold the nodeNames and their direct distances from Z
    List<String> nodeNames = new ArrayList<>();
    List<Integer> directDistances = new ArrayList<>();
    Map<String, Integer> mapOfNodes = new HashMap<>();
    String[][] connectionMatrix = null;
    // read in direct_distance.txt
    mapOfNodes = getMapOfNodesFromFile(DIRECT_DISTANCES_FILENAME);
    // Map the keys to node Names List
    nodeNames = new ArrayList<>(mapOfNodes.keySet());
    //map the values to directDistances list
    directDistances = new ArrayList<>(mapOfNodes.values());
    connectionMatrix = getNodeConnectionMatrix(GRAPH_FILE_NAME);






    System.out.println("Type start node represented by a single uppercase letter:");
    Scanner scan = new Scanner(System.in);
    String start_node = scan.next();
    while (!nodeNames.contains(start_node)) {
      System.out.println("Node not found, try again:");
      Scanner scan1 = new Scanner(System.in);
      start_node = scan1.next();
    }
    //test input
    //System.out.println(start_node);
    Graph.get_shortest_path(start_node, nodeNames, directDistances, connectionMatrix);
    System.out.println();
    Graph.get_shortest_path_2(start_node, nodeNames, directDistances, connectionMatrix);
    //System.out.println(Algorithm1.get_adjacent_node_2(start_node, nodeNames, directDistances, connectionMatrix));
  }
}
