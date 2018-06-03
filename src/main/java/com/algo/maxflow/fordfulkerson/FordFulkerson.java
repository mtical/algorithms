package com.algo.maxflow.fordfulkerson;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
  private boolean[] marked; // marked[v.getId()] == true then there is a path from s -> v in residual graph.
  private Edge[] edgeTo; // edgeTo[v] = edges in the augmenting path.
  private double valueMaxFlow;

  /**
   * Runtime O(EV^2)
   *
   * @param flowNetwork flow network
   * @param s           start
   * @param t           sink
   */
  public FordFulkerson(FlowNetwork flowNetwork, Vertex s, Vertex t) {
    while (hasAugmentingPath(flowNetwork, s, t)) {

      // for finding the min units of flow from s -> t
      double minValue = Double.POSITIVE_INFINITY;

      for (Vertex v = t; v != s; v = edgeTo[v.getId()].getOther(v)) {
        minValue = Math.min(minValue, edgeTo[v.getId()].getResidualCapacity(v));
      }

      for (Vertex v = t; v != s; v = edgeTo[v.getId()].getOther(v)) {
        edgeTo[v.getId()].addResidualFlowTo(v, minValue);
      }

      valueMaxFlow += minValue;
    }
  }

  public boolean isInCut(int index) {
    return marked[index];
  }

  public double getMaxFlow() {
    return this.valueMaxFlow;
  }

  /**
   * Using BFS, check residual graph for augmenting path.
   *
   * @param flowNetwork
   * @param s
   * @param t
   * @return
   */
  private boolean hasAugmentingPath(FlowNetwork flowNetwork, Vertex s, Vertex t) {
    edgeTo = new Edge[flowNetwork.getNumOfVertices()];
    marked = new boolean[flowNetwork.getNumOfVertices()];

    Queue<Vertex> queue = new LinkedList<>();
    queue.add(s);
    marked[s.getId()] = true;

    // make sure we haven't visited t too.
    while (!queue.isEmpty() && !marked[t.getId()]) {
      Vertex v = queue.poll();

      for (Edge e : flowNetwork.getAdjacenciesList(v)) {
        Vertex w = e.getOther(v);

        if (e.getResidualCapacity(w) > 0) {
          if (!marked[w.getId()]) {
            edgeTo[w.getId()] = e;
            marked[w.getId()] = true;
            queue.add(w);
          }
        }
      }
    }

    return marked[t.getId()];
  }
}
