package com.algo.minspanningtree.prims.lazy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsLazyAlgorithm {
  private List<Vertex> unvisitedVertices;
  private List<Edge> spanningTree;
  // using the comparator from Edge class.
  private PriorityQueue<Edge> edgeHeap;
  private double fullCost;

  public PrimsLazyAlgorithm(List<Vertex> unvisitedVertices) {
    this.spanningTree = new ArrayList<>();
    this.unvisitedVertices = unvisitedVertices;
    this.edgeHeap = new PriorityQueue<>();
  }

  /**
   * Lazy implementation.
   *
   * Avg running time: O(E*logE)
   * Worst case: O(E*logV)
   * Memory: O(E)
   *
   * Looks like a DFS into the graph.  Does not update the Heap as it goes.
   *
   * @param vertex
   */
  public void primsLazyAlgorithm(Vertex vertex) {
    this.unvisitedVertices.remove(vertex);

    while (!unvisitedVertices.isEmpty()) {
      for (Edge e : vertex.getAdjacencies()) {

        // Make sure we're not adding any edge to the MST that would form a cycle.
        // Forbidden to make cycles in MST.
        //
        // Use the unvisited data struct for a lookup, knowing that if it's present here, then it is not present in the
        // MST.
        if (this.unvisitedVertices.contains(e.getTargetVertex())) {
          this.edgeHeap.add(e);
        }
      }

      // add stats, set up next `while` cycle.
      Edge minEdge = this.edgeHeap.remove();

      this.spanningTree.add(minEdge);
      this.fullCost += minEdge.getWeight();

      vertex = minEdge.getTargetVertex();
      this.unvisitedVertices.remove(vertex);
    }
  }

  public void showMst() {
    System.out.println("mst cost: " + this.fullCost);
    for (Edge e : spanningTree) {
      System.out.println(e.getStartVertex() + " - " + e.getTargetVertex());
    }
  }
}
