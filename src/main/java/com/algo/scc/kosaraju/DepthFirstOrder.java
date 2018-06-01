package com.algo.scc.kosaraju;

import java.util.Stack;

public class DepthFirstOrder {
  private Stack<Vertex> stack;

  public DepthFirstOrder(Graph graph) {
    this.stack = new Stack<>();

    for (Vertex vertex : graph.getVertices()) {
      if (!vertex.isVisited()) {
        dfs(vertex);
      }
    }
  }

  public void dfs(Vertex vertex) {
    vertex.setVisited(true);
    for (Vertex v : vertex.getAdjacencies()) {
      if (!v.isVisited()) {
        dfs(v);
      }
    }
    stack.push(vertex);
  }

  public Stack<Vertex> getReversePost() {
    return this.stack;
  }
}
