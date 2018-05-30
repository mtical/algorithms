package com.algo.search.bfs;

public class App {
  public static void main(String[] args) {
    BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    Vertex v1 = new Vertex("1");
    Vertex v2 = new Vertex("2");
    Vertex v3 = new Vertex("3");
    Vertex v4 = new Vertex("4");
    Vertex v5 = new Vertex("5");

    v1.addNeighborList(v2);
    v1.addNeighborList(v4);
    v4.addNeighborList(v5);
    v2.addNeighborList(v3);

    breadthFirstSearch.bfs(v1);
  }
}
