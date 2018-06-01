package com.algo.scc.kosaraju;

public class Kosaraju {
  private int[] id; // id[v] = id of the strongly connected component containing the vertex.
  private int count;
  private boolean[] marked;

  /**
   * Runs in linear time: O(V+E)
   *
   * 1 - Fun DFS to get a topological order of the graph
   * 2 - Transpose the graph: "new DepthFirstOrder(graph.getTransposedGraph());"
   * 3 - Iterate over topological order with transposed graph and find Strongly Connected Components.
   *
   */
  public Kosaraju(Graph graph) {
    DepthFirstOrder dfs = new DepthFirstOrder(graph.getTransposedGraph());

    this.marked = new boolean[graph.getVertices().size()];
    this.id = new int[graph.getVertices().size()];

    for (Vertex vertex : dfs.getReversePost()) {
      if (!this.marked[vertex.getId()]) {
        dfs(vertex);
        this.count++;
      }
    }
  }

  public void dfs(Vertex vertex) {
    this.marked[vertex.getId()] = true;
    this.id[vertex.getId()] = count;
    vertex.setComponentId(count);

    for (Vertex v : vertex.getAdjacencies()) {
      if (!this.marked[v.getId()]) {
        dfs(v);
      }
    }
  }

  public int getCount() {
    return count;
  }
}
