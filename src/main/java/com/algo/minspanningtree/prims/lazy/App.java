package com.algo.minspanningtree.prims.lazy;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
//    run1();
    run2();
  }

  private static void run1() {
    Vertex v0 = new Vertex("A");
    Vertex v1 = new Vertex("B");
    Vertex v2 = new Vertex("C");

    v0.addEdge(new Edge(1, v0, v1));
    v0.addEdge(new Edge(1, v0, v2));
    v0.addEdge(new Edge(10, v1, v2));

    v1.addEdge(new Edge(1, v1, v0));
    v2.addEdge(new Edge(1, v2, v0));
    v2.addEdge(new Edge(10, v2, v1));

    List<Vertex> vertices = new ArrayList<>();
    vertices.add(v0);
    vertices.add(v1);
    vertices.add(v2);

    PrimsLazyAlgorithm primsLazyAlgorithm = new PrimsLazyAlgorithm(vertices);
    primsLazyAlgorithm.primsLazyAlgorithm(v2);
    primsLazyAlgorithm.showMst();
  }

  private static void run2() {
    Vertex v0 = new Vertex("A");
    Vertex v1 = new Vertex("B");
    Vertex v2 = new Vertex("C");

    v0.addEdge(new Edge(100, v0, v1));
    v0.addEdge(new Edge(10, v0, v2));
    v0.addEdge(new Edge(1, v1, v2));

    v1.addEdge(new Edge(100, v1, v0));
    v2.addEdge(new Edge(10, v2, v0));
    v2.addEdge(new Edge(1, v2, v1));

    List<Vertex> vertices = new ArrayList<>();
    vertices.add(v0);
    vertices.add(v1);
    vertices.add(v2);

    PrimsLazyAlgorithm primsLazyAlgorithm = new PrimsLazyAlgorithm(vertices);
    primsLazyAlgorithm.primsLazyAlgorithm(v2);
    primsLazyAlgorithm.showMst();
  }
}
