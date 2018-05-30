package com.algo.search.dfs.cycle;

import java.util.List;

public class CycleDetection {
    public void detectCycles(List<Vertex> vertices) {
        for (Vertex v : vertices) {
            if (!v.isVisited()) {
                dfs(v);
            }
        }
    }

  /**
   * O(V+E)
   */
  private void dfs(Vertex vertex) {
        vertex.setBeingVisited(true);

        System.out.println("dfs on vertex" + vertex);
        for (Vertex v : vertex.getAdjacencies()) {
            System.out.println("visiting the neighbors of vertex" + vertex);

            // not topo sort cause we have to check on every iteration.
            if (v.isBeingVisited()) {
                System.out.println("there is a backward edge, there is a cycle!");
                return;
            }

            if (!v.isVisited()) {
                System.out.println("visiting vertex " + v + " recursively...");
                v.setVisited(true);
                dfs(v);
            }
        }

        System.out.println("Set vertex " + vertex + " setBeingVisited(false) and visited(true)...");
        // we're done with the given vertex at this point
        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}
