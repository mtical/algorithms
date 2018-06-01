# Implementations of Algorithms in Java

Derived from the [Advanced Algorithms Course](https://www.udemy.com/advanced-algorithms-in-java/learn/v4/announcements) by [Holczer Balazs](https://www.udemy.com/user/holczerbalazs/).

- **Search**
    - Breadth First Search (LinkedList queue)
        - Runtime: **O(V+E)**
        - Worst case memory: **O(V)**
    - Depth First Search
        - Runtime: **O(V+E)**
        - Worst case memory: **O(V)**
        - Applications
            - Stack implementation
            - Cycle detection (recursive)
            - Maze Solver (recursive)
            - Topological Ordering (recursive)
- **Shortest Path**
    - Dijkstra's
        - Runtime: **O(E + V\*logV)**
    - Bellman-Ford
        - Worst case runtime: **O(E\*V)**
        - Best case runtime: **O(E)**
        - Worst case memory: **O(V)**
    - DAG Shortest Path
        - Runtime: **O(V+E)**  
            - For the topological sort then an **O(V)** for the stack iteration. 
- **Disjoint Sets**
    - Kruskal's
        - Average run time: **O(E\*log V)**
        - Worst case memory: **O(E+V)**
    - Prims-Jarnik
        - Eager implementation
            - Avg running time: **O(E\*logE)**
            - Worst case running time: **O(E\*logV)**
            - Memory: **O(E)**
        - Lazy implementation
            - Avg running time: **O(E\*logE)**
            - Worst case: **O(E\*logV)**
            - Memory: **O(E)**
- **Strongly Connected Components**
    - Kosaraju
        - Runtime: **O(V+E)**
    - Tarjan
        - Runtime: **O(V+E)**

[Cool algorithm visualizations](https://www.cs.usfca.edu/~galles/visualization/Algorithms.html)