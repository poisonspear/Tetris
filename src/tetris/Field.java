package tetris;

/**
 * Created by IntelliJ IDEA.
 * Author  Suknatov Aleksey
 * Date    19.09.2016
 */
public class Field {
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setCell(int x, int y, int value) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            matrix[y][x] = value;
    }

    public Integer getCell(int x, int y) {
        if (x >=0 && x < width && y >= 0 && y < height)
            return matrix[y][x];
        return null;
    }

    public void print() {
        int[][] canvas = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = matrix[i][j];
            }
        }

        int top = Tetris.getFigure().getY();
        int left = Tetris.getFigure().getX();

        int figureMatrixSize = Tetris.getFigure().getMatrix().length;
        int[][] figureMatrix = Tetris.getFigure().getMatrix();

        for (int i = 0; i < figureMatrixSize; i++) {
            for (int j = 0; j < figureMatrixSize; j++) {
                if (figureMatrix[i][j] == 1)
                    canvas[top + i][left + j] = figureMatrix[i][j];
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (canvas[i][j] == 1)
                    System.out.print(" X ");
                else
                    System.out.print(" . ");
            }
            System.out.println();

        }
    }

    public void removeFullLines() {

    }
}
