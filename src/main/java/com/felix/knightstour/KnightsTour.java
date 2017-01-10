package com.felix.knightstour;

import java.awt.*;

public class KnightsTour {

    private boolean grid[][];
    private int count;
    private int spaces;

    private static final Point[] moves = new Point[] {
            new Point(-2, -1),
            new Point(-2, 1),
            new Point(2, -1),
            new Point(2, 1),
            new Point(-1, -2),
            new Point(-1, 2),
            new Point(1, -2),
            new Point(1, 2)
    };

    public KnightsTour(int rows, int cols) {
        grid = new boolean[rows][cols];
        count = 0;
        spaces = rows * cols;
    }

    public boolean tourFrom(int row, int col) {
        grid[row][col] = true;
        count++;

        if (count == spaces) {
            return true;
        }

        for (Point move : moves) {
            int nextRow = row + move.x;
            int nextCol = col + move.y;

            if (nextRow < 0  ||  nextRow >= grid.length) {
                continue;
            } else if (nextCol < 0  ||  nextCol >= grid.length) {
                continue;
            } else if (grid[nextRow][nextCol]) {
                continue;
            }

            if (tourFrom(nextRow, nextCol)) {
                System.out.println("nextRow: " + nextRow + ", nextCol: " + nextCol);
                return true;
            }

        }

        grid[row][col] = false;
        printGrid();
        count--;

        return false;
    }

    private void printGrid() {
        System.out.println("Count: " + count);
        for(boolean[] rows:grid){
            for(boolean b:rows){
                System.out.print((b) ? "T":"F");
            }
            System.out.println();
        }
        System.out.println("\n");

    }

    public static void main(String[] args) {
        KnightsTour tour = new KnightsTour(5,5);
        tour.tourFrom(0, 0);
        tour.printGrid();
    }

}