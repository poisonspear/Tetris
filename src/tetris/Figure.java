package tetris;

/**
 * Created by IntelliJ IDEA.
 * Author  Suknatov Aleksey
 * Date    19.09.2016
 */
public class Figure {
    //coordinates
    private int x;
    private int y;
    //figure matrix
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

    //move left
    public void left() {
        x--;
        if (!isCurrentPositionOK())
            x++;
    }

    //move right
    public void right() {
        x++;
        if (!isCurrentPositionOK())
            x--;
    }

    //move down
    public void down() {
        y++;
    }

    //move up
    public void up() {
        y--;
    }

    //flip figure
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

    //move figure at the bottom
    public void fullDown() {
        while (isCurrentPositionOK()) {
            y++;
        }
        y--;
    }

    //fix figure at the field
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

    //checks that figure don't live borders and don't collide fixed figures
    public boolean isCurrentPositionOK() {
        Field field = Tetris.getField();
        int figureMatrixSize = Tetris.getFigure().getMatrix().length;

        for (int i = 0; i < figureMatrixSize; i++) {
            for (int j = 0; j < figureMatrixSize; j++) {
                if (matrix[i][j] == 1) {
                    if (i + y >= field.getHeight())
                        return false;
                    Integer value = field.getCell(j + x, i + y);
                    if (value == null || value == 1)
                        return false;
                }
            }
        }
        return true;
    }
}
