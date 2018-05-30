package com.algo.search.dfs.maze_solver;

public class MazeSolver {
    private int[][] mazeMap;
    private boolean[][] visited;
    private int startPositionCol;
    private int startPositionRow;

    public MazeSolver(int[][] mazeMap, int startPositionCol, int startPositionRow) {
        this.mazeMap = mazeMap;
        this.visited = new boolean[mazeMap.length][mazeMap.length];
        this.startPositionCol = startPositionCol;
        this.startPositionRow = startPositionRow;
    }

    public void findWayOut() {
        try {
            dfs(startPositionRow, startPositionCol);
            System.out.println("No solution found...");
        }
        catch (RuntimeException e) {
            System.out.println("Route found to exit!");
        }
    }

    private void dfs(int rowIdx, int colIdx) {
        System.out.println("visiting i=" + rowIdx + ", j=" + colIdx);

        if (this.mazeMap[rowIdx][colIdx] == 3) {
            throw new RuntimeException(); // we found the exit.
        }

        int endOfMap = this.mazeMap.length-1;

        if (visited[rowIdx][colIdx]) { // if it has already been visited, we just skip it.
            return;
        }
        else if (rowIdx < 0 || rowIdx >= endOfMap) {
            return;
        }
        else if (colIdx < 0 || colIdx >= endOfMap) {
            return;
        }
        else if (this.mazeMap[rowIdx][colIdx] == 1) {
            return;
        }
        else {
            this.visited[rowIdx][colIdx] = true;

            dfs(rowIdx + 1, colIdx); // going down
            dfs(rowIdx, colIdx + 1); // going right
            dfs(rowIdx, colIdx - 1); // going left
            dfs(rowIdx - 1, colIdx); // going up
        }
    }
}
