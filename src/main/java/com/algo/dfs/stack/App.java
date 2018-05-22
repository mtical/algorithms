package com.algo.dfs.stack;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    Vertex v1 = new Vertex("1");
    Vertex v2 = new Vertex("2");
    Vertex v3 = new Vertex("3");
    Vertex v4 = new Vertex("4");
    Vertex v5 = new Vertex("5");

    List<Vertex> list = new ArrayList<>();

    v1.addNeighborList(v2);
    v1.addNeighborList(v3);
    v3.addNeighborList(v4);
    v4.addNeighborList(v5);
    v5.addNeighborList(v2);
    v2.addNeighborList(v5);

    list.add(v1);
    list.add(v2);
    list.add(v3);
    list.add(v4);
    list.add(v5);

    DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
    depthFirstSearch.dfs(list);
  }

}
