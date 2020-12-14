package cs526.termProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Project {
  public static final String GRAPH_FILE_NAME = "src/cs526/termProject/graph_input.txt";
  public static final String DIRECT_DISTANCES_FILENAME = "src/cs526/termProject/direct_distance.txt";

  public static void main(String[] args) {
    Map<String, Integer> indexMap = new HashMap<>();
    /** Ask the user to input a node validating their input */

    /**
     * Load the graph input file
     *    0  71   0   0   0   0   0   0   0 151   0   0   0   0   0   0   0   0   0   0   0
     *   71   0  75   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
     *    0  75   0 118   0   0   0   0   0 140   0   0   0   0   0   0   0   0   0   0   0
     *    0   0 118   0 111   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
     *    0   0   0  111  0  70   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
     *    0   0   0   0  70   0  75   0   0   0   0   0   0   0   0   0   0   0   0   0   0
     *    0   0   0   0   0  75   0 120   0   0   0   0   0   0   0   0   0   0   0   0   0
     *    0   0   0   0   0   0 120   0 146   0   0 138   0   0   0   0   0   0   0 115   0
     *    0   0   0   0   0   0   0 146   0  80   0  97   0   0   0   0   0   0   0   0   0
     *  151   0 140   0   0   0   0   0  80   0  99   0   0   0   0   0   0   0   0   0   0
     *    0   0   0   0   0   0   0   0   0  99   0   0   0   0   0   0   0   0   0   0 211
     *    0   0   0   0   0   0   0 138  97   0   0   0   0   0   0   0   0   0   0   0 101
     *    0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0  90
     *    0   0   0   0   0   0   0   0   0   0   0   0   0   0   0  98 142   0   0   0  85
     *    0   0   0   0   0   0   0   0   0   0   0   0   0   0   0  86   0   0   0   0   0
     *    0   0   0   0   0   0   0   0   0   0   0   0   0  98  86   0   0   0   0   0   0
     *    0   0   0   0   0   0   0   0   0   0   0   0   0 142   0   0   0  92   0   0   0
     *    0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0  92   0  87   0   0
     *    0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0  87   0   0   0
     *    0   0   0   0   0   0   0 115   0   0   0   0   0   0   0   0   0   0   0   0   0
     *    0   0   0   0   0   0   0   0   0   0 211 101  90  85   0   0   0   0   0   0   0
     */
    int[][] nodeLocationMatrix = new GraphInput().getMatrixFromFile(GRAPH_FILE_NAME);

    /** Load the Direct Distance file */
    /**
     * {A=380, B=374, C=366, D=329, E=244, F=241, G=242, H=160, I=193, J=253, K=176, L=100, M=77,
     *  N=80, O=161, P=151, Q=199, R=226, S=234, T=92, Z=0}
     */
    DirectDistance directDistance = new DirectDistance(DIRECT_DISTANCES_FILENAME);
    // Map to hold the Node labels and their respective index to be used on the nodeLocationMatrix
    indexMap = directDistance.getIndexMapFromFile();
    // Map to hold the nodes and their respective distance from `Z`
    Map<String, Integer> distanceMap = directDistance.getDistanceIndexMapFromFile();

    /**
     * Get the shortest distance for each connected node
     */
    String node = "J";
    ArrayList<String> sequenceOfAllNodes = new ArrayList<>();
    ArrayList<String> shortest = new ArrayList<>();
    ClosestNode closestNode = new ClosestNode(indexMap, nodeLocationMatrix, directDistance.getDistanceIndexMapFromFile());

    /**
     * Using Algorithm 1 to get to Z.
     */
    closestNode.showSequenceOfAllNodesPath(node);
  }
 }

