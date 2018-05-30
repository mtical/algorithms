package com.algo.search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
  /**
   * O(V+E)
   * Memory complexity is worse than DFS
   */
  public void bfs(Vertex start) {
    Queue<Vertex> queue = new LinkedList<>();

    start.setVisited(true);
    queue.add(start);

    while (!queue.isEmpty()) {
      Vertex vertex = queue.poll();
      System.out.print(vertex + " ");

      for (Vertex v : vertex.getNeighborList()) {
        if (!v.isVisited()) {
          v.setVisited(true);
          queue.add(v);
        }
      }

    }
  }
}
