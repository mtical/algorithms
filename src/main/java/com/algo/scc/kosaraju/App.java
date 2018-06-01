package com.algo.scc.kosaraju;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    List<Vertex> vertices = new ArrayList<>();
    vertices.add(new Vertex(0, "a"));
    vertices.add(new Vertex(1, "b"));
    vertices.add(new Vertex(2, "c"));
    vertices.add(new Vertex(3, "d"));
    vertices.add(new Vertex(4, "e"));
    vertices.add(new Vertex(5, "f"));
    vertices.add(new Vertex(6, "g"));
    vertices.add(new Vertex(7, "h"));

    List<Edge> edges = new ArrayList<>();
    edges.add(new Edge(1, vertices.get(0), vertices.get(1)));

    edges.add(new Edge(1, vertices.get(1), vertices.get(2)));
    edges.add(new Edge(1, vertices.get(1), vertices.get(4)));
    edges.add(new Edge(1, vertices.get(1), vertices.get(5)));

    edges.add(new Edge(1, vertices.get(2), vertices.get(3)));
    edges.add(new Edge(1, vertices.get(2), vertices.get(6)));

    edges.add(new Edge(1, vertices.get(3), vertices.get(2)));
    edges.add(new Edge(1, vertices.get(3), vertices.get(7)));

    edges.add(new Edge(1, vertices.get(4), vertices.get(0)));
    edges.add(new Edge(1, vertices.get(4), vertices.get(5)));

    edges.add(new Edge(1, vertices.get(5), vertices.get(6)));

    edges.add(new Edge(1, vertices.get(6), vertices.get(5)));

    edges.add(new Edge(1, vertices.get(7), vertices.get(3)));
    edges.add(new Edge(1, vertices.get(7), vertices.get(6)));

    Graph graph = new Graph(vertices, edges);

    Kosaraju kosaraju = new Kosaraju(graph);

    System.out.println(kosaraju.getCount());

    for(Vertex vertex : vertices) {
      System.out.println(vertex + " - " + vertex.getComponentId());
    }
  }
}
