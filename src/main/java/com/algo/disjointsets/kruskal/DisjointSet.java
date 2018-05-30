package com.algo.disjointsets.kruskal;

import java.util.ArrayList;
import java.util.List;

/**
 * Main purpose:
 *
 * We're able to decide in constant or close-to constant time complexity as to whether or not there is a cycle in the
 * graph.
 *
 * If you look for a given item, it'll return the representative, not the specific item.
 */
public class DisjointSet {
  private int nodeCount = 0;
  private int setCount = 0;
  private List<Node> rootNodes; // representatives

  public DisjointSet(List<Vertex> vertices) {
    this.rootNodes = new ArrayList<>(vertices.size());
    makeSets(vertices);
  }

  /**
   * iterative form of path compression
   *
   * Get a node and we find it's parents.  if parents are not null, look for it's parents iteratively.
   *
   * looking for the rootnode/rep.
   *
   * O(1) time complexity.
   *
   * @param n
   * @return
   */
  public int find(Node n) {
    Node currentNode = n;

    // Find the parent.
    while(currentNode.getParent() != null) {
      currentNode = currentNode.getParent();
    }

    // now that we have the parent/root
    Node rootNode = currentNode;
    currentNode = n;

    // Path compression algorithm for whole path from `n`.
    // This alters the tree so that future calls will reach the root/rep more quickly.
    //
    // Set the incoming node's edge directed to the root node.
    // In A -> B -> C, n = C.
    // Result: C <- A -> B
    //
    while(currentNode != rootNode) {
      Node temp = currentNode.getParent();
      currentNode.setParent(rootNode);
      currentNode = temp;
    }

    return rootNode.getId();
  }

  /**
   * Merge two disjoint sets together.  Merge the smaller tree to the bigger tree.
   *
   * This will make it so the final tree won't be so unbalanced.
   *
   * @param node1
   * @param node2
   */
  public void union(Node node1, Node node2) {
    int index1 = find(node1);
    int index2 = find(node2);

    // if rep's for 2 nodes are the same, then they're in the same disjoint set.
    if (index1 == index2) {
      return;
    }

    Node root1 = this.rootNodes.get(index1);
    Node root2 = this.rootNodes.get(index2);

    // merge the smaller tree into the larger one.
    if (root1.getRank() < root2.getRank()) {
      root1.setParent(root2);
    }
    else if(root1.getRank() > root2.getRank()) {
      root2.setParent(root1);
    }
    else { // if the same.
      root2.setParent(root1);
      root1.setRank(root1.getId() + 1);
    }

    // this is how we track the # of disjoint sets.
    this.setCount--;
  }

  /**
   * iterate through all the vertices and make the disjoint set.
   *
   * @param vertices array of vertices.
   */
  private void makeSets(List<Vertex> vertices) {
    for(Vertex v : vertices) {
      makeSet(v);
    }
  }

  /**
   *
   * @param vertex
   */
  private void makeSet(Vertex vertex) {
    Node n = new Node(rootNodes.size(), 0, null);
    vertex.setNode(n);

    this.rootNodes.add(n);
    this.setCount++;
    this.nodeCount++;
  }
}
