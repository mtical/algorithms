package com.algo.dfs.topo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        TopologicalOrdering topologicalOrdering = new TopologicalOrdering();

        List<Vertex> graph = new ArrayList<>();

        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).addNeighbor(graph.get(3));

        graph.get(3).addNeighbor(graph.get(1));

        graph.get(4).addNeighbor(graph.get(0));
        graph.get(4).addNeighbor(graph.get(1));

        graph.get(5).addNeighbor(graph.get(0));
        graph.get(5).addNeighbor(graph.get(2));

        for(int i = 0; i < graph.size(); ++i) {
            print(graph);
           if (!graph.get(i).isVisisted()) {
               topologicalOrdering.dfs(graph.get(i));
           }
        }

        Stack<Vertex> stack = topologicalOrdering.getStack();

        for(int i = 0; i < graph.size(); ++i) {
            Vertex vertex = stack.pop();
            System.out.println(vertex.toString() + "->");
        }
    }

    private static void print(List<Vertex> graph) {
        List<Vertex> visited = new ArrayList<>();
        List<Vertex> unvisited = new ArrayList<>();
        graph.forEach(v -> {
            if (v.isVisisted()) {
                visited.add(v);
            }
            else {
                unvisited.add(v);
            }
        });

        System.out.println("visited");
        visited.forEach(System.out::print);
        System.out.println();
        System.out.println("unvisited");
        unvisited.forEach(System.out::print);
        System.out.println();
    }
}
