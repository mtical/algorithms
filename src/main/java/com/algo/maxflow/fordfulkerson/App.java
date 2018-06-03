package com.algo.maxflow.fordfulkerson;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    FlowNetwork flowNetwork = new FlowNetwork(4);

    Vertex v0 = new Vertex(0, "s");
    Vertex v1 = new Vertex(1, "A");
    Vertex v2 = new Vertex(2, "B");
    Vertex v3 = new Vertex(3, "t");

    List<Vertex> vertices = new ArrayList<>();
    vertices.add(v0);
    vertices.add(v1);
    vertices.add(v2);
    vertices.add(v3);

    flowNetwork.addEdge(new Edge(v0, v1, 4));
    flowNetwork.addEdge(new Edge(v0, v2, 5));

    flowNetwork.addEdge(new Edge(v1, v3, 7));

    flowNetwork.addEdge(new Edge(v2, v1, 4));
    flowNetwork.addEdge(new Edge(v2, v3, 1));

    FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, v0, v3);

    System.out.println("Maximum flow is: " + fordFulkerson.getMaxFlow());

    // print min-cut
    System.out.println();
    System.out.println("Vertices in the cut set: ");
    for (int v = 0; v < vertices.size(); v++) {
      if (fordFulkerson.isInCut(v)) {
        System.out.print(vertices.get(v) + " ");
      }
    }
  }
}
