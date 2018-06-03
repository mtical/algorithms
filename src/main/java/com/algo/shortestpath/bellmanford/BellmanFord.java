package com.algo.shortestpath.bellmanford;

import java.util.List;

public class BellmanFord {
  private List<Edge> edgeList;
  private List<Vertex> vertexList;

  public BellmanFord(List<Edge> edges, List<Vertex> vertices) {
    this.edgeList = edges;
    this.vertexList = vertices;
  }

  /**
   * Bellman-Ford
   *
   * Worst case runtime: O(E*V)
   * Best case runtime: O(E)
   * Worst case memory: O(V)
   *
   * Slower than Dijkstras but more robust and can handle negatives.
   * Relaxes all edges at the same time for V-1 iterations.
   *
   * It does V-1 iterations + 1 to detect cycles:
   * If cost decreases in the V-th iteration, than there is a negative cycle, because all the paths are traversed up
   * to the V-1 iteration.
   *
   */
  public void bellmanFord(Vertex sourceVertex) {
    sourceVertex.setDistance(0);

    for (int i = 0; i < vertexList.size()-1; i++) {
      // every iteration, relax all the edges.
      for (Edge edge : edgeList) {
        Vertex u = edge.getStartVertex();
        Vertex v = edge.getTargetVertex();

        if (u.getDistance() == Integer.MAX_VALUE) continue;

        int newDistance = u.getDistance() + edge.getWeight();

        if (newDistance < v.getDistance()) {
          v.setDistance(newDistance);
          v.setPreviousVertex(u);
        }
      }
    }
    for (Edge edge : edgeList) { // v-th iteration.
      if (edge.getStartVertex().getDistance() != Integer.MAX_VALUE) {
        if (hasCycle(edge)) {
          System.out.println("there has been a negative cycle detected.");
          return;
        }
      }
    }
  }

  private boolean hasCycle(Edge edge) {
    return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
  }

  public void shortestPathTo(Vertex targetVertex) {
    if (targetVertex.getDistance() == Integer.MAX_VALUE) {
      System.out.println("there is no path from the source to the target");
    }
    else {
      Vertex actualVertex = targetVertex;
      System.out.print(actualVertex + " - ");

      while (actualVertex.getPreviousVertex() != null) {
        actualVertex = actualVertex.getPreviousVertex();
        System.out.print(actualVertex + " - ");
      }
    }
  }
}
