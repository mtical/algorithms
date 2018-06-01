package com.algo.shortestpath.dag;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
  private Stack<Vertex> stack;

  public TopologicalSort() {
    this.stack = new Stack<>();
  }

  /**
   * Runtime: O(V+E)
   */
  public void makeTopologicalOrder(List<Vertex> vertices) {
    for (Vertex vertex : vertices) {
      if (!vertex.isVisited()) {
        dfs(vertex);
      }
    }
  }

  public void dfs(Vertex vertex) {
    for (Edge e : vertex.getAdjacenciesList()) {
      if (!e.getTargetVertex().isVisited()) {
        e.getTargetVertex().setVisited(true);
        dfs(e.getTargetVertex());
      }
    }
    this.stack.push(vertex);
  }

  public Stack<Vertex> getTopologicalOrder() {
    Collections.reverse(stack);
    return this.stack;
  }
}
