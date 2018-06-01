package com.algo.scc.kosaraju;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  private List<Vertex> vertices;
  private List<Edge> edges;

  public Graph() {

  }

  public Graph(List<Vertex> vertices, List<Edge> edges) {
    this.vertices = vertices;
    this.edges = edges;
  }

  public List<Vertex> getVertices() {
    return vertices;
  }

  public void setVertices(List<Vertex> vertices) {
    this.vertices = vertices;
  }

  public List<Edge> getEdges() {
    return edges;
  }

  public void setEdges(List<Edge> edges) {
    this.edges = edges;
  }

  public Graph getTransposedGraph() {
    Graph transposed = new Graph();
    List<Vertex> transposedVertices = new ArrayList<>(this.vertices);

    for (Edge e : this.edges) {
      transposedVertices.get(transposedVertices.indexOf(e.getTargetVertex())).addNeighbor(e.getStartVertex());
    }
    transposed.setVertices(transposedVertices);
    return transposed;
  }
}
