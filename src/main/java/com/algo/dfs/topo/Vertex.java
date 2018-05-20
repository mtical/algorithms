package com.algo.dfs.topo;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String data;
    private boolean visisted;
    private List<Vertex> neighborList;

    public Vertex(String data) {
        this.data = data;
        this.neighborList = new ArrayList<>();
    }

    public void addNeighbor(Vertex vertex) {
        this.neighborList.add(vertex);
    }

    @Override
    public String toString() {
        return this.data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVisisted() {
        return visisted;
    }

    public void setVisisted(boolean visisted) {
        this.visisted = visisted;
    }

    public List<Vertex> getNeighborList() {
        return neighborList;
    }

    public void setNeighborList(List<Vertex> neighborList) {
        this.neighborList = neighborList;
    }
}
