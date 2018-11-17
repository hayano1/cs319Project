package com.iqpuzzler.model;

public class PuzzlePattern {
    private int dimensionX;
    private int dimensionY;
    private int[][] cells;

    PuzzlePattern(int cells[][], int x, int y){
        this.cells = new int[x][y];
        for (int outer = 0; outer < x; outer++){
            for (int inner = 0; inner < y; inner++){
                this.cells[outer][inner] = cells[outer][inner];
            }
        }
    }

    public int checkCellContents(int x, int y){
        return this.cells[x][y];
    }
}
