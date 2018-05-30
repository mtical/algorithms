package com.algo.search.dfs.stack;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

  private Stack<Vertex> stack;

  public DepthFirstSearch() {
    this.stack = new Stack<>();
  }

  public void dfs(List<Vertex> vertexList) {
    for (Vertex v : vertexList) {
      if (!v.isVisited()) {
        v.setVisited(true);

        dfsWithStack(v);
      }
    }
  }

  /**
   * O(V+E)
   * Memory complexity is better than BFS, only as much as the height of the graph.
   */
  private void dfsWithStack(Vertex start) {
    this.stack.push(start);
    start.setVisited(true);

    while (!stack.empty()) {
      Vertex vertex = stack.pop();
      System.out.print(vertex + " ");

      for (Vertex v : vertex.getNeighborList()) {

        if (!v.isVisited()) {
          v.setVisited(true);
          stack.push(v);
        }

      }
    }
  }

}
