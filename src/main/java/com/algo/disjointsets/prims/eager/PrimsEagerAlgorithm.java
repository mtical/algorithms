package com.algo.disjointsets.prims.eager;

import java.util.List;
import java.util.PriorityQueue;

public class PrimsEagerAlgorithm {
  private List<Vertex> vertices;
  private PriorityQueue<Vertex> heap;

  public PrimsEagerAlgorithm(Graph graph) {
    this.vertices = graph.getVertices();
    this.heap = new PriorityQueue<>();
  }

  public void spanningTree() {
    for (Vertex v : vertices) {
      if (!v.isVisited()) {
        makePrimsJarnik(v);
      }
    }
  }

  private void makePrimsJarnik(Vertex vertex) {
    vertex.setDistance(0);
    heap.add(vertex);

    while (!heap.isEmpty()) {
      Vertex v = heap.remove();
      scanVertices(v);
    }
  }

  /**
   * We are going to manipulate the content of the heap (eager).
   *
   * Avg running time: O(E*logE)
   * Worst case: O(E*logV)
   * Memory: O(E)
   *
   * @param vertex
   */
  private void scanVertices(Vertex vertex) {
    vertex.setVisited(true);

    for (Edge edge : vertex.getAdjacencies()) {
      Vertex w = edge.getTargetVertex();

      if (w.isVisited()) continue;

      if (edge.getWeight() < w.getDistance()) {
        w.setDistance(edge.getWeight());
        w.setMinEdge(edge);

        if (this.heap.contains(w)) {
          this.heap.remove(w);
        }

        this.heap.add(w);
      }
    }
  }

  public void show() {
    for (Vertex vertex : vertices) {
      if (vertex.getMinEdge() != null) {
        Edge e = vertex.getMinEdge();
        System.out.println("Edge: " + e.getStartVertex() + " - " + e.getTargetVertex());
      }
    }
  }
}
