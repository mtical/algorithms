package com.algo.disjointsets.prims.eager;

public class App {
  public static void main(String[] args) {
    run1();
  }

  /**
   * we have 7 vertices so we must have 6 edges in MST.
   */
  private static void run1() {
    Graph graph = new Graph();

    Vertex va = new Vertex("A");
    Vertex vb = new Vertex("B");
    Vertex vc = new Vertex("C");
    Vertex vd = new Vertex("D");
    Vertex ve = new Vertex("E");
    Vertex vf = new Vertex("F");
    Vertex vg = new Vertex("G");

    graph.addVertex(va);
    graph.addVertex(vb);
    graph.addVertex(vc);
    graph.addVertex(vd);
    graph.addVertex(ve);
    graph.addVertex(vf);
    graph.addVertex(vg);

    graph.addEdge(new Edge(7, va, vb));
    graph.addEdge(new Edge(5, va, vd));
    graph.addEdge(new Edge(9, vd, vb));
    graph.addEdge(new Edge(15, vd, ve));
    graph.addEdge(new Edge(6, vd, vf));
    graph.addEdge(new Edge(7, vb, ve));
    graph.addEdge(new Edge(8, vb, vc));
    graph.addEdge(new Edge(5, vc, ve));
    graph.addEdge(new Edge(8, vf, ve));
    graph.addEdge(new Edge(11, vf, vg));
    graph.addEdge(new Edge(9, ve, vg));

    PrimsEagerAlgorithm primsEagerAlgorithm = new PrimsEagerAlgorithm(graph);
    primsEagerAlgorithm.spanningTree();
    primsEagerAlgorithm.show();
  }
}
