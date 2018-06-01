package com.algo.shortestpath.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
  /**
   * Dijkstra's Algorithm with heaps
   *
   * Runtime O(E + V*logV)
   *
   * It can find the shortest path from A to B but it is able to construct a shortest path tree as well -> defines the
   * shortest path from a source to all the other nodes.
   *
   * Greedy algorithm - On every iteration we want to find the min distance to the next vertex possible.
   */
    public void computePaths(Vertex sourceVertex) {
        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex actualVertex = priorityQueue.poll();

            assert actualVertex != null;
            for (Edge edge : actualVertex.getAdjacenciesList()) {
                Vertex v = edge.getTargetVertex();

                double newDistance = actualVertex.getDistance() + edge.getWeight();

                if (newDistance < v.getDistance()) {
                    priorityQueue.remove(v);
                    v.setDistance(newDistance);
                    v.setPredecessor(actualVertex);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex) {
        List<Vertex> shortestPathToTarget = new ArrayList<>();

        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
            shortestPathToTarget.add(vertex);
        }

        Collections.reverse(shortestPathToTarget);
        return shortestPathToTarget;
    }
}
