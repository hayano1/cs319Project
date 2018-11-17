package com.iqpuzzler.model;

public class Grid2D {
    private int dimensionX;
    private int dimensionY;
    private int[][] cells;

    Grid2D(int x, int y){
        this.cells = new int[x][y];
        for (int outer = 0; outer < x; outer++){
            for (int inner = 0; inner < y; inner++){
                this.cells[outer][inner] = 0;
            }
        }
    }

    public int getCellContent(int x, int y){
        return this.cells[x][y];
    }

    public void setCellFilled(int x, int y, int pieceID){
        cells[x][y] = pieceID;
    }
}
