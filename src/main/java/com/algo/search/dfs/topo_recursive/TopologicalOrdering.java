package com.algo.search.dfs.topo_recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {
  // Most common technique is DFS to use stacks (BFS uses a queues).
  private Stack<Vertex> stack;

  public TopologicalOrdering() {
    this.stack = new Stack<>();
  }

  public Stack<Vertex> getStack() {
    return this.stack;
  }

  public void dfs(List<Vertex> graph) {
    for (Vertex v : graph) {
//      print(graph);
      if (!v.isVisisted()) {
        dfsWithRecursion(v);
      }
    }
  }

  /**
   * O(V+E)
   * Recursive implementation of DFS.
   */
  private void dfsWithRecursion(Vertex vertex) {
    vertex.setVisisted(true);
    for (Vertex v : vertex.getNeighborList()) {
      if (!v.isVisisted()) {
        dfsWithRecursion(v);
      }
    }

    stack.push(vertex);
  }

  private void print(List<Vertex> graph) {
    List<Vertex> visited = new ArrayList<>();
    List<Vertex> unvisited = new ArrayList<>();
    graph.forEach(v -> {
      if (v.isVisisted()) {
        visited.add(v);
      }
      else {
        unvisited.add(v);
      }
    });

    System.out.println("visited");
    visited.forEach(System.out::print);
    System.out.println();
    System.out.println("unvisited");
    unvisited.forEach(System.out::print);
    System.out.println();
  }
}
