package cs526.termProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ClosestNode {
  private Map<String, Integer> indexMap;
  private Map<String, Integer> directDistances;
  private int[][] adjacencyMatrix;
  private int shortestDistance = 0;

  ClosestNode(Map<String, Integer> indexMap, int[][] matrix, Map<String,Integer> directDistances){
    this.indexMap = indexMap;
    this.adjacencyMatrix = matrix;
    this.directDistances = directDistances;
  }
  public void showSequenceOfAllNodesPath(String node){
    ArrayList<String> path = new ArrayList<>();
    System.out.printf("Sequence of all nodes path: %s",node);
    while (!"Z".equals(node)){
      node = getClosestDirectNodeToZ(node);
      System.out.printf(" --> %s",node);
    }
    System.out.println();
    path.add(node);
  }
  public void showShortestDirectPath(String node){
    ArrayList<String> path = new ArrayList<>();
    System.out.printf("Shortest path: %s",node);
    while (!"Z".equals(node)){
      node = getClosestDirectNodeToZ(node);
      System.out.printf(" --> %s",node);
    }
    System.out.println();
    path.add(node);
  }

  public ArrayList getAdjacentNodesList(String node){
    int nodeIndex = indexMap.get(node);
    ArrayList<String> adjacentNodes = new ArrayList<>();
    for (int i = 0; i < adjacencyMatrix.length; i++){
      if (adjacencyMatrix[nodeIndex][i] != 0){
        adjacentNodes.add(node);
      }
    }
    return adjacentNodes;
  }

  public String getClosestDirectNodeToZ(String node){
    String closestDirectNodeToZ = "";
    int nodeIndex = indexMap.get(node);
    int closetDirectDistanceToZ = Integer.MAX_VALUE;
    int selectedNodeIndex = Integer.MAX_VALUE;
    /**
     * visitedNodes list will be use to check if the adjacent nodes to the current have already
     * been visited. If it has it will not be used for the next node
     */
    ArrayList<String> visitedNodes = new ArrayList<>();

    /**
     * loop over the adjacency to find nodes that are connected (!= 0)
     * each row of the adjacency matrix is represented by `adjacencyMatrix[nodeIndex]
     * Then loop over this row to see which nodes are connected
     */
    for (int i = 0; i < adjacencyMatrix.length; i++){
      // if the value of the node is zero skip it
      if(adjacencyMatrix[nodeIndex][i] == 0){
        continue; // skip any nodes that are zero
      }
      /**
       * If the value is not zero. Check id the node has been visited already. If it has not find
       * the node with the lowest direct distance to z
       */
      int directDistance = directDistances.get(getNodeLetterByIndex(i));
      if (!visitedNodes.contains(node)){
        if (directDistance < closetDirectDistanceToZ){
          closetDirectDistanceToZ = directDistance;
          selectedNodeIndex = i;
        }
        closestDirectNodeToZ = getNodeLetterByIndex(selectedNodeIndex);
      }

    }

    return closestDirectNodeToZ;
  }

  public String getClosestNode(String node){
    int nodeIndex = indexMap.get(node);
    int lowestNodeDistance = Integer.MAX_VALUE;
    int selectedNodeIndex = Integer.MAX_VALUE;

    /**
     * Loop over the adjacency matrix
     */
    for (int i = 0; i < adjacencyMatrix.length; i++){
      if (adjacencyMatrix[nodeIndex][i] == 0){
        continue; // skip zeros
      }

      // find the lowest distance AND its position
      if (adjacencyMatrix[nodeIndex][i] < lowestNodeDistance){
        lowestNodeDistance = adjacencyMatrix[nodeIndex][i];
        selectedNodeIndex = i;
      }
    }

    // Convert the index to its associated letter
    String nodeLetter = getNodeLetterByIndex(selectedNodeIndex);
    return nodeLetter;
  }

  public String getNodeLetterByIndex(int index){
    // search through each key/value for the indexMap
    for (Map.Entry nodeIndexValue: indexMap.entrySet()){
      // if key == index pos return the which is the node latter
      if (nodeIndexValue.getValue().equals(index)){
        return (String) nodeIndexValue.getKey();
      }
    }
    return null; //No node found
  }

}
