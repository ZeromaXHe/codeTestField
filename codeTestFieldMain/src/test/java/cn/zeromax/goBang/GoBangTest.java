package cn.zeromax.goBang;

import javafx.util.Pair;

import java.util.LinkedList;

public class GoBangTest {
    private int[][] board; // 0 未下子, 1 黑棋, 2 白棋
    private int roundCount; // 回合数，记录第几回合
    private int empty; // 空余空格数量
    private int gameStatus; // 0 未开局, 1 黑方行动, 2 白方行动, -1 黑方胜利, -2 白方胜利, -3 平局 TODO: 改造成Enum? 试试状态模式?
    private LinkedList<Pair<Integer, Integer>> moveStack; // 落子记录

    GoBangTest() {// ToDo: 试着写个单例?
        board = new int[19][19]; // 19 * 19 棋盘
        roundCount = 0;
        empty = 19 * 19;
        gameStatus = 0;
    }

    /**
     * 判断是否胜利 TODO： 算法很粗暴，之后试着优化
     *
     * @param color 1 黑棋 2 白棋
     * @param x     横坐标
     * @param y     纵坐标
     * @return 游戏状态 1 黑方行动, 2 白方行动, -1 黑方胜利, -2 白方胜利, -3 平局
     */
    private int isWin(int color, int x, int y) {
        int countHori = 1;
        int countVert = 1;
        int countLUtoRD = 1; //左上到右下
        int countLDtoRU = 1; //左下到右上

        int xIndex = x;
        int yIndex = y;
        //向左查询
        while (--xIndex >= 0 && board[xIndex][yIndex] == color) { //“--”先减一再和0比， && 断路性质 前面小于0就不会作为数组索引了
            countHori++;
        }
        xIndex = x;
        //向右查询
        while (++xIndex < 19 && board[xIndex][yIndex] == color) {
            countHori++;
        }
        xIndex = x;
        //向上查询
        while (--yIndex >= 0 && board[xIndex][yIndex] == color) {
            countVert++;
        }
        yIndex = y;
        //向下查询
        while (++xIndex < 19 && board[xIndex][yIndex] == color) {
            countVert++;
        }
        yIndex = y;
        //向左上角查询
        while (--xIndex >= 0 && --yIndex >= 0 && board[xIndex][yIndex] == color) {
            countLUtoRD++;
        }
        xIndex = x;
        yIndex = y;
        //向右下角查询
        while (++xIndex < 19 && ++yIndex < 19 && board[xIndex][yIndex] == color) {
            countLUtoRD++;
        }
        xIndex = x;
        yIndex = y;
        //向左下角查询
        while (--xIndex >= 0 && ++yIndex < 19 && board[xIndex][yIndex] == color) {
            countLDtoRU++;
        }
        xIndex = x;
        yIndex = y;
        //向右上角查询
        while (++xIndex < 19 && --yIndex >= 0 && board[xIndex][yIndex] == color) {
            countLDtoRU++;
        }

        boolean win = (countHori >= 5) || (countVert >= 5) || (countLUtoRD >= 5) || (countLDtoRU >= 5);
        if (color == 1) {
            if (win) {
                return -1;
            } else {
                return empty == 0 ? -3 : 2;
            }
        } else if (color == 2) {
            if (win) {
                return -2;
            } else {
                return empty == 0 ? -3 : 1;
            }
        }

        return Integer.MIN_VALUE; // TODO: 改成异常
    }

    public static void main(String[] args) {

    }
}
