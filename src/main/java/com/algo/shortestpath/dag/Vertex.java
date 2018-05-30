package com.algo.shortestpath.dag;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
  private String name;
  private boolean visited;
  private int distance = Integer.MAX_VALUE;
  private Vertex previousVertex;
  private List<Edge> adjacenciesList;

  public Vertex(String name) {
    this.name = name;
    this.adjacenciesList = new ArrayList<>();
  }

  public void addNeighbor(Edge edge) {
    this.adjacenciesList.add(edge);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public Vertex getPreviousVertex() {
    return previousVertex;
  }

  public void setPreviousVertex(Vertex previousVertex) {
    this.previousVertex = previousVertex;
  }

  public List<Edge> getAdjacenciesList() {
    return adjacenciesList;
  }

  public void setAdjacenciesList(List<Edge> adjacenciesList) {
    this.adjacenciesList = adjacenciesList;
  }

  @Override public String toString() {
    return name;
  }
}
