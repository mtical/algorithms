package com.algo.dagshortestpath;

import java.util.Arrays;
import java.util.List;

public class App {
  /**
   * If the graph we're considering is a DAG, then we can use the DAG topo ordering shortest path method then it'll
   * yield linear time complexity.
   */
  public static void main(String[] args) {

    Vertex vertex0 = new Vertex("A");
    Vertex vertex1 = new Vertex("B");
    Vertex vertex2 = new Vertex("C");

    List<Vertex> vertexList = Arrays.asList(vertex0, vertex1, vertex2);

    vertex0.addNeighbor(new Edge(1, vertex0, vertex1));
    vertex0.addNeighbor(new Edge(1, vertex0, vertex2));
    vertex1.addNeighbor(new Edge(1, vertex1, vertex2));

    AcyclicShortestPath acyclicShortestPath = new AcyclicShortestPath();
    acyclicShortestPath.shortestPath(vertexList, vertex0, vertex2);
    acyclicShortestPath.showShortestPath(vertex2);
  }
}
