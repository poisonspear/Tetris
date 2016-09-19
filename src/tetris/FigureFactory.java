package tetris;

/**
 * Created by IntelliJ IDEA.
 * Author  Suknatov Aleksey
 * Date    19.09.2016
 */
public class FigureFactory {
    //some simple figures in static array
    private static int[][][] figures = {
            {
                    {1, 1, 0},
                    {0, 1, 1},
                    {0, 0, 0}
            },
            {
                    {0, 1, 1},
                    {0, 1, 1},
                    {0, 0, 0}
            },
            {
                    {0, 1, 0},
                    {0, 1, 0},
                    {0, 1, 0}
            },
            {
                    {1, 0, 0},
                    {1, 1, 0},
                    {0, 1, 0}
            },
            {
                    {0, 0, 0},
                    {1, 1, 1},
                    {0, 0, 0}
            },
            {
                    {1, 1, 1},
                    {0, 1, 0},
                    {0, 0, 0}
            },
            {
                    {1, 0, 0},
                    {1, 1, 0},
                    {1, 0, 0}
            }
    };

    //return random figure from previous array
    public static Figure getRandomFigure(int x, int y) {
        return new Figure(x, y, figures[(int) (Math.random() * 7)]);
    }
}
