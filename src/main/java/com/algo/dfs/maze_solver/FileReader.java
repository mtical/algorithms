package com.algo.dfs.maze_solver;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;


public class FileReader {
    private int[][] map;
    private String fileName;
    private int numOfRows;
    private int numOfColumns;
    private int startPositionCol; // the start idx of the 2 'start point' colIndex
    private int startPositionRow; // the start idx of the 2 'start point' rowIndex

    public FileReader(String fileName, int numOfRows, int numOfColumns) {
        this.fileName = fileName;
        this.numOfColumns = numOfColumns;
        this.numOfRows = numOfRows;
        this.map = new int[numOfRows][numOfColumns];
    }

    public void parseFile() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
            Scanner scanner = new Scanner(file);

            for (int i = 0; i < this.numOfRows; i++) {
                for (int j = 0; j < this.numOfColumns; j++) {

                    map[i][j] = scanner.nextInt();

                    if (map[i][j] == 2) {
                        startPositionCol = j;
                        startPositionRow = i;
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[][] getMap() {
        return map;
    }

    public int getStartPositionCol() {
        return startPositionCol;
    }

    public int getStartPositionRow() {
        return startPositionRow;
    }
}
