package com.algo.dfs.topo;

import java.util.Stack;

public class TopologicalOrdering {
    // most common technique is DFS
    // BFS uses a queue, DFS uses a stack.
    private Stack<Vertex> stack;

    public TopologicalOrdering() {
        this.stack = new Stack<>();
    }

    public void dfs(Vertex vertex) {
        vertex.setVisisted(true);
        for (Vertex v : vertex.getNeighborList()) {
            if (!v.isVisisted()) {
                dfs(v);
            }
        }

        stack.push(vertex);
    }

    public Stack<Vertex> getStack() {
        return this.stack;
    }
}
