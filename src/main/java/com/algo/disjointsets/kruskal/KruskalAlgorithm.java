package com.algo.disjointsets.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {
  public void spanningTree(List<Vertex> vertices, List<Edge> edges) {
    DisjointSet set = new DisjointSet(vertices);
    List<Edge> mst = new ArrayList<>();

    // Sort by ascending order by edge weight so that we can start iterating through them.
    // 0, 1, 2, 3, etc.
    Collections.sort(edges);

    // check if this will form a cycle or not.
    // if it does, discard it.  if not, include it in MST.
    for (Edge e : edges) {
      Vertex u = e.getStartVertex();
      Vertex v = e.getTargetVertex();

      // check if in same set.
      if (set.find(u.getNode()) != set.find(v.getNode())) {
        mst.add(e);
        set.union(u.getNode(), v.getNode());
      }
    }

    for (Edge e : mst) {
      System.out.print(e.getStartVertex() + " " + e.getTargetVertex() + " -- ");
    }
  }
}
