package com.algo.minspanningtree.kruskal;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    run1();
    System.out.println();
    run2();
    System.out.println();
    run3();
  }

  private static void run1() {
    List<Vertex> vertices = new ArrayList<>();
    vertices.add(new Vertex("A"));
    vertices.add(new Vertex("B"));
    vertices.add(new Vertex("C"));
    vertices.add(new Vertex("D"));
    vertices.add(new Vertex("E"));
    vertices.add(new Vertex("F"));
    vertices.add(new Vertex("G"));
    vertices.add(new Vertex("H"));

    List<Edge> edges = new ArrayList<>();
    edges.add(new Edge(3, vertices.get(0), vertices.get(1)));
    edges.add(new Edge(2, vertices.get(0), vertices.get(2)));
    edges.add(new Edge(5, vertices.get(0), vertices.get(3)));

    edges.add(new Edge(13, vertices.get(1), vertices.get(5)));
    edges.add(new Edge(2, vertices.get(1), vertices.get(3)));

    edges.add(new Edge(5, vertices.get(2), vertices.get(4)));
    edges.add(new Edge(2, vertices.get(2), vertices.get(3)));

    edges.add(new Edge(4, vertices.get(3), vertices.get(4)));
    edges.add(new Edge(6, vertices.get(3), vertices.get(5)));
    edges.add(new Edge(3, vertices.get(3), vertices.get(6)));

    edges.add(new Edge(6, vertices.get(4), vertices.get(6)));

    edges.add(new Edge(2, vertices.get(5), vertices.get(6)));
    edges.add(new Edge(3, vertices.get(5), vertices.get(7)));

    edges.add(new Edge(6, vertices.get(6), vertices.get(7)));

    KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
    kruskalAlgorithm.spanningTree(vertices, edges);
  }

  private static void run2() {
    List<Vertex> vertices = new ArrayList<>();
    vertices.add(new Vertex("A"));
    vertices.add(new Vertex("B"));
    vertices.add(new Vertex("C"));

    List<Edge> edges = new ArrayList<>();
    edges.add(new Edge(1, vertices.get(0), vertices.get(1)));
    edges.add(new Edge(1, vertices.get(0), vertices.get(2)));
    edges.add(new Edge(3, vertices.get(1), vertices.get(2)));

    KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
    kruskalAlgorithm.spanningTree(vertices, edges);
  }

  private static void run3() {
    List<Vertex> vertices = new ArrayList<>();
    vertices.add(new Vertex("A"));
    vertices.add(new Vertex("B"));
    vertices.add(new Vertex("C"));

    List<Edge> edges = new ArrayList<>();
    edges.add(new Edge(1, vertices.get(0), vertices.get(1)));
    edges.add(new Edge(10, vertices.get(0), vertices.get(2)));
    edges.add(new Edge(1, vertices.get(1), vertices.get(2)));

    KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
    kruskalAlgorithm.spanningTree(vertices, edges);
  }
}
