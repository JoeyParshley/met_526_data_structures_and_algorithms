package cs526.Project;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Project {
  /**
   * File locations
   */
  public static final String GRAPH_FILE_NAME = "src/cs526/Project/graph_input.txt";
  public static final String DIRECT_DISTANCES_FILENAME = "src/cs526/Project/direct_distance.txt";

  public static Map<String,Integer> getArrayFromFile(String filePath) {
    String lineFromFile = "";
    String [] tokens = null;
    Map<String,Integer> mapOfTokens = new HashMap<>();
    int count = 0;

    try {
      Scanner fileInput = new Scanner (new File(filePath));

      // Get one line at a time and repeat the same process for all expressions in the input file.
      while (fileInput.hasNextLine()) {

        // Get the next line
        lineFromFile = fileInput.nextLine();

        //Split the string fromFile using spaces...produces an Array of Strings
        tokens = lineFromFile.split("\\s+");
        mapOfTokens.put(tokens[0],Integer.parseInt(tokens[1]));
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
    // read in direct_distance.txt
    mapOfNodes = getArrayFromFile(DIRECT_DISTANCES_FILENAME);
    nodeNames = new ArrayList<>(mapOfNodes.keySet());


/**
 * OLD READ FILE START DIRECT_DISTANCE
 */
    FileInputStream fin1 = new FileInputStream(DIRECT_DISTANCES_FILENAME);
    InputStreamReader reader1 = new InputStreamReader(fin1);
    BufferedReader buffReader1 = new BufferedReader(reader1);
    String strTmp1 = "";
    while ((strTmp1 = buffReader1.readLine()) != null) {
      int d = Integer.parseInt(strTmp1.replaceAll("[A-Z]+\\s", ""));
      directDistances.add(d); // test input
      }
    buffReader1.close();
/**
 * OLD READ FILE END
 */


    /**
     *Input graph_input.txt, store weight into list
     */
    int n = mapOfNodes.size(); //number of nodeNames
    String[][] weight = new String[n + 1][n + 1];
    int index = 0;
    FileInputStream fin2 = new FileInputStream(GRAPH_FILE_NAME);
    InputStreamReader reader2 = new InputStreamReader(fin2);
    BufferedReader buffReader2 = new BufferedReader(reader2);
    String strTmp2 = "";
    while ((strTmp2 = buffReader2.readLine()) != null) {
      weight[index] = strTmp2.split("\\s+");
      index++;
    }


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
    Graph.get_shortest_path(start_node, nodeNames, directDistances, weight);
    System.out.println();
    Graph.get_shortest_path_2(start_node, nodeNames, directDistances, weight);
    //System.out.println(Algorithm1.get_adjacent_node_2(start_node, nodeNames, directDistances, weight));
  }
}
