package com.algo.dfs.cycle;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");
        Vertex vertex6 = new Vertex("6");

        vertex1.addNeighbor(vertex2);
        vertex1.addNeighbor(vertex3);

        vertex2.addNeighbor(vertex3);

        vertex4.addNeighbor(vertex1);
        vertex4.addNeighbor(vertex5);

        vertex5.addNeighbor(vertex6);

        vertex6.addNeighbor(vertex4);

        List<Vertex> vertices = Arrays.asList(vertex1, vertex2, vertex3, vertex4, vertex5, vertex6);

        CycleDetection cycleDetection = new CycleDetection();
        cycleDetection.detectCycles(vertices);
    }
}
