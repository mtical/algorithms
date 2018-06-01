package com.algo.scc.tarjan;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    List<Vertex> vertices = new ArrayList<>();

    Vertex v1 = new Vertex("1");
    Vertex v2 = new Vertex("2");
    Vertex v3 = new Vertex("3");
    Vertex v4 = new Vertex("4");
    Vertex v5 = new Vertex("5");
    Vertex v6 = new Vertex("6");
    Vertex v7 = new Vertex("7");

    v1.addNeighbor(v5);

    v2.addNeighbor(v1);

    v3.addNeighbor(v2);
    v3.addNeighbor(v4);

    v4.addNeighbor(v3);

    v5.addNeighbor(v2);

    v6.addNeighbor(v2);
    v6.addNeighbor(v5);
    v6.addNeighbor(v7);

    v7.addNeighbor(v6);
    v7.addNeighbor(v3);

    vertices.add(v1);
    vertices.add(v2);
    vertices.add(v6);
    vertices.add(v4);
    vertices.add(v5);
    vertices.add(v3);
    vertices.add(v7);

    TarjanAlgorithm tarjanAlgorithm = new TarjanAlgorithm(vertices);
    tarjanAlgorithm.runAlgorithm();
    tarjanAlgorithm.printComponents();
  }
}
