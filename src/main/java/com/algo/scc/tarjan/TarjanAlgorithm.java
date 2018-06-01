package com.algo.scc.tarjan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TarjanAlgorithm {
  private Stack<Vertex> stack;
  private List<Vertex> vertices;
  private List<List<Vertex>> connectedComponentList;
  private int time = 0;
  private int count;

  public TarjanAlgorithm(List<Vertex> vertices) {
    this.vertices = vertices;
    this.stack = new Stack<>();
    this.connectedComponentList = new ArrayList<>();
  }

  public void runAlgorithm() {
    for(Vertex vertex : vertices) {
      if (!vertex.isVisited()) {
        dfs(vertex);
      }
    }
  }

  /**
   * Runtime: O(V+E)
   *
   * @param vertex start vertex
   */
  private void dfs(Vertex vertex) {
    vertex.setLowLink(time++);

    System.out.println("Visiting vertex " + vertex + " with low link " + vertex.getLowLink());

    vertex.setVisited(true);
    stack.push(vertex);
    boolean isComponentRoot = true;
    for (Vertex v : vertex.getNeighborList()) {
      if (!v.isVisited()) {
        System.out.println("Recursively visit vertex " + v);
        dfs(v);
      }

      if (vertex.getLowLink() > v.getLowLink()) {
        System.out.println("Because vertex " + vertex + " lowLink (value: " + vertex.getLowLink() + ") > neighbor " + v + " lowLink (value: " + v.getLowLink() + ").");
        vertex.setLowLink(v.getLowLink());

        System.out.println("So vertex " + vertex + " is not the root of a SCC");
        isComponentRoot = false;
      }
    }

    // if its a root - find all the vertices belonging to that component.
    if (isComponentRoot) {
      count++;

      System.out.println("Vertex " + vertex + " is the root of an SCC");
      List<Vertex> component = new ArrayList<>();

      while (true) {
        Vertex actualVertex = stack.pop();
        System.out.println("So vertex " + actualVertex + " is in SCC " + count);
        component.add(actualVertex);
        actualVertex.setLowLink(Integer.MAX_VALUE);

        if (actualVertex.getName().equals(vertex.getName())) break;
      }

      connectedComponentList.add(component);
    }
  }

  public void printComponents() {
    System.out.println(connectedComponentList);
  }
}
