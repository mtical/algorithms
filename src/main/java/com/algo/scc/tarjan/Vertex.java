package com.algo.scc.tarjan;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
  private String name;
  private List<Vertex> neighborList;
  private Vertex predecessor;
  private boolean visited;
  private int lowLink;

  public Vertex(String name) {
    this.name = name;
    this.neighborList = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Vertex> getNeighborList() {
    return neighborList;
  }

  public void setNeighborList(List<Vertex> neighborList) {
    this.neighborList = neighborList;
  }

  public Vertex getPredecessor() {
    return predecessor;
  }

  public void setPredecessor(Vertex predecessor) {
    this.predecessor = predecessor;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public int getLowLink() {
    return lowLink;
  }

  public void setLowLink(int lowLink) {
    this.lowLink = lowLink;
  }

  public void addNeighbor(Vertex vertex) {
    this.neighborList.add(vertex);
  }

  @Override public String toString() {
    return this.name;
  }
}
