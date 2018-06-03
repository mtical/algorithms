package com.algo.maxflow.fordfulkerson;

public class Edge {
  private Vertex fromVertex;
  private Vertex targetVertex;
  private final double capacity;
  private double flow;

  public Edge(Vertex fromVertex, Vertex targetVertex, double capacity) {
    this.fromVertex = fromVertex;
    this.targetVertex = targetVertex;
    this.capacity = capacity;
    // init that for every single edge in the beginning
    this.flow = 0.0;
  }

  public Edge(Edge edge) {
    this.fromVertex = edge.getFromVertex();
    this.targetVertex = edge.getTargetVertex();
    this.capacity = edge.getCapacity();
    this.flow = edge.getFlow();
  }

  public Vertex getFromVertex() {
    return fromVertex;
  }

  public void setFromVertex(Vertex fromVertex) {
    this.fromVertex = fromVertex;
  }

  public Vertex getTargetVertex() {
    return targetVertex;
  }

  public void setTargetVertex(Vertex targetVertex) {
    this.targetVertex = targetVertex;
  }

  public double getCapacity() {
    return capacity;
  }

  public double getFlow() {
    return flow;
  }

  public void setFlow(double flow) {
    this.flow = flow;
  }

  public Vertex getOther(Vertex vertex) {
    if (vertex == targetVertex) {
      return fromVertex;
    }
    else {
      return targetVertex;
    }
  }

  /**
   * construct residual network.
   *
   * @param vertex vertex
   * @return
   */
  public double getResidualCapacity(Vertex vertex) {
    if (vertex == fromVertex) {
      return flow; // backward edge
    }
    else {
      return capacity - flow; // forward edge
    }
  }

  public void addResidualFlowTo(Vertex vertex, double deltaFlow) {
    if (vertex == fromVertex) {
      flow = flow - deltaFlow;  // backward edge
    }
    else {
      flow = flow + deltaFlow;
    }
  }

  @Override public String toString() {
    return fromVertex + "-" + targetVertex + " " + flow + "/" + capacity;
  }
}
