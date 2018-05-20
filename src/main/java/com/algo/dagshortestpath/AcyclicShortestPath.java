package com.algo.dagshortestpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AcyclicShortestPath {
  public void shortestPath(List<Vertex> vertices, Vertex source, Vertex target) {
    source.setDistance(0);
    TopologicalSort topologicalSort = new TopologicalSort();
    topologicalSort.makeTopologicalOrder(vertices);

    Stack<Vertex> stack = topologicalSort.getTopologicalOrder();


    // relax the edges - "move from MAX_VALUES to shorter values".
    for (Vertex actual : stack) {
      for (Edge e : actual.getAdjacenciesList()) {
        Vertex u = e.getStartVertex();
        Vertex v = e.getTargetVertex();

        int newDistance = u.getDistance() + e.getWeight();

        if (newDistance < v.getDistance()) {
          v.setDistance(newDistance);
          v.setPreviousVertex(u);
        }
      }
    }

    // if this is true then the distance was never updated and there likely
    // wasn't a path to the target vertex.
    if(target.getDistance() == Integer.MAX_VALUE) {
      System.out.println("no shortest path there...");
    }
    else {
      System.out.println("target vertex shortest path " + target.getDistance());
    }
  }

  public void showShortestPath(Vertex target) {
    List<Vertex> list = new ArrayList<>();

    Vertex actual = target;
    list.add(actual);

    while(actual.getPreviousVertex() != null) {
      actual = actual.getPreviousVertex();
      list.add(actual);
    }

    Collections.reverse(list);
    System.out.println(list);
  }
}
