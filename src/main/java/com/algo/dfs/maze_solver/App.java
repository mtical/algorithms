package com.algo.dfs.maze_solver;

public class App {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("map.txt", 7, 7);
        fileReader.parseFile();
        MazeSolver mazeSolver = new MazeSolver(
                fileReader.getMap(),
                fileReader.getStartPositionCol(),
                fileReader.getStartPositionRow());
        mazeSolver.findWayOut();
    }
}
