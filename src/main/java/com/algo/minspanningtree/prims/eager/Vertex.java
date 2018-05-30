package com.algo.minspanningtree.prims.eager;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
  private String name;
  // shortest edge to the actual MST from a non MST vertex.
  private Edge minEdge;
  private boolean visited;
  private Vertex previousVertex;
  // to detect whether the heap is in need of refresh of better weighted edge.
  private double distance = Double.POSITIVE_INFINITY;
  private List<Edge> adjacencies;

  public Vertex(String name) {
    this.name = name;
    this.adjacencies = new ArrayList<>();
  }

  public void addEdge(Edge edge) {
    this.adjacencies.add(edge);
  }

  public Edge getMinEdge() {
    return minEdge;
  }

  public void setMinEdge(Edge minEdge) {
    this.minEdge = minEdge;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public Vertex getPreviousVertex() {
    return previousVertex;
  }

  public void setPreviousVertex(Vertex previousVertex) {
    this.previousVertex = previousVertex;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public List<Edge> getAdjacencies() {
    return adjacencies;
  }

  public void setAdjacencies(List<Edge> adjacencies) {
    this.adjacencies = adjacencies;
  }

  @Override public String toString() {
    return this.name;
  }

  @Override public int compareTo(Vertex o) {
    return Double.compare(this.distance, o.getDistance());
  }
}
