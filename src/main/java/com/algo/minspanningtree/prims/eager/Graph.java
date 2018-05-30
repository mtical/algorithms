package com.algo.minspanningtree.prims.eager;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  private List<Vertex> vertices;
  private List<Edge> edges;

  public Graph() {
    this.vertices = new ArrayList<>();
    this.edges = new ArrayList<>();
  }

  public void addVertex(Vertex vertex) {
    this.vertices.add(vertex);
  }

  public void addEdge(Edge edge) {
    Vertex start = edge.getStartVertex();
    Vertex target = edge.getTargetVertex();

    this.vertices.get(vertices.indexOf(start)).addEdge(new Edge(edge.getWeight(), start, target));
    this.vertices.get(vertices.indexOf(target)).addEdge(new Edge(edge.getWeight(), target, start));
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
}
