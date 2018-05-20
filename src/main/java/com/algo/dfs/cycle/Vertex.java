package com.algo.dfs.cycle;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private boolean beingVisited;
    private List<Vertex> adjacencies;

    public Vertex(String name) {
        this.name = name;
        this.adjacencies = new ArrayList<>();
    }

    public void addNeighbor(Vertex vertex) {
        this.adjacencies.add(vertex);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public List<Vertex> getAdjacencies() {
        return adjacencies;
    }

    public void setAdjacencies(List<Vertex> adjacencies) {
        this.adjacencies = adjacencies;
    }
}
