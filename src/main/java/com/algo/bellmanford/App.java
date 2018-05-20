package com.algo.bellmanford;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    List<Vertex> vertexList = new ArrayList<>();

    vertexList.add(new Vertex("A"));
    vertexList.add(new Vertex("B"));
    vertexList.add(new Vertex("C"));

    List<Edge> edges = new ArrayList<>();

    edges.add(new Edge(1, vertexList.get(0), vertexList.get(1)));
    edges.add(new Edge(-1, vertexList.get(1), vertexList.get(2)));
    edges.add(new Edge(1, vertexList.get(2), vertexList.get(1)));

    BellmanFord bellmanFord = new BellmanFord(edges, vertexList);
    bellmanFord.bellmanFord(vertexList.get(0));
    bellmanFord.shortestPathTo(vertexList.get(2));
  }
}
