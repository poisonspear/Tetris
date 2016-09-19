package tetris;

/**
 * Created by IntelliJ IDEA.
 * Author  Suknatov Aleksey
 * Date    19.09.2016
 */
public class Figure {
    private int x;
    private int y;
    private int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void left() {

    }

    public void right() {

    }

    public void down() {
        y++;
    }

    public void up() {
        y--;
    }

    public void flip() {
        int figureMatrixSize = Tetris.getFigure().getMatrix().length;
        int[][] flippedFigureMatrix = new int[figureMatrixSize][figureMatrixSize];
        for (int i = 0; i < figureMatrixSize; i++) {
            for (int j = 0; j < figureMatrixSize; j++) {
                flippedFigureMatrix[i][j] = matrix[j][i];
            }
        }
        matrix = flippedFigureMatrix;
    }

    public void fullDown() {

    }

    public void fix() {
        int figureMatrixSize = Tetris.getFigure().getMatrix().length;

        for (int i = 0; i < figureMatrixSize; i++) {
            for (int j = 0; j < figureMatrixSize; j++) {
                if (matrix[i][j] == 1) {
                    Tetris.getField().setCell(x + j, y + i, 1);
                }
            }
        }
    }

    public boolean isCurrentPositionOK() {
        Field field = Tetris.getField();
        int figureMatrixSize = Tetris.getFigure().getMatrix().length;

        for (int i = 0; i < figureMatrixSize; i++) {
            for (int j = 0; j < figureMatrixSize; j++) {
                if (matrix[i][j] == 1) {
                    if (i + y >= field.getHeight())
                        return false;
                }
            }
        }
        return true;
    }
}
