package cn.zeromax.goBang;

import cn.zeromax.goBang.state.*;

import java.util.LinkedList;

public class GoBangTest {
    private int[][] board; // 0 未下子, 1 黑棋, 2 白棋
    private int roundCount; // 回合数，记录第几回合
    private int empty; // 空余空格数量

    //定义状态 TODO: 这里的状态模式用的感觉很奇怪，尤其是GoBangTest和GoBangGameState需要双向绑定双方的引用，怕不是自己理解的有问题。有空思考一下状态模式到底应该怎么用！这里问题大了，姑且当作先练习一下状态模式的写法吧~
    public final static GoBangGameState whiteMove = new WhiteMoveGameState();
    public final static GoBangGameState blackMove = new BlackMoveGameState();
    public final static GoBangGameState draw = new DrawGameState();
    public final static GoBangGameState whiteWin = new WhiteWinGameState();
    public final static GoBangGameState blackWin = new WhiteWinGameState();
    //当前游戏状态
    private GoBangGameState gameState;

    // 落子记录 格式为[x, y, color]
    private LinkedList<int[]> moveStack;

    GoBangTest() {// ToDo: 试着写个单例?
        board = new int[19][19]; // 19 * 19 棋盘
        roundCount = 0;
        empty = 19 * 19;
        setGameState(blackMove);
        moveStack = new LinkedList<>();
    }

    public void setGameState(GoBangGameState goBangGameState) {
        this.gameState = goBangGameState;
        this.gameState.setGoBangTest(this);
    }

    public GoBangGameState getGameState() {
        return gameState;
    }

    /**
     * 在棋盘上下子的方法
     * @param x 横坐标
     * @param y 纵坐标
     * @param color 颜色
     * @return 接下来的游戏状态
     */
    public GoBangGameState moveOnBoard(int x, int y, int color) {
        this.board[x][y] = color;
        memoMove(x, y, color);
        return isWin(x,y, color);
    }

    private void memoMove(int x, int y, int color) {
        this.moveStack.add(new int[]{x, y, color});
    }

    /**
     * 下子(委托给状态执行)
     *
     * @param x 横坐标
     * @param y 纵坐标
     */
    public void move(int x, int y) {
        this.gameState.move(x, y);
    }

    /**
     * 判断是否胜利 TODO： 算法很粗暴，之后试着优化
     *
     * @param x     横坐标
     * @param y     纵坐标
     * @param color 1 黑棋 2 白棋
     * @return 游戏状态 1 黑方行动, 2 白方行动, -1 黑方胜利, -2 白方胜利, -3 平局
     */
    private GoBangGameState isWin( int x, int y , int color) {
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
                return blackWin;
            } else {
                return empty == 0 ? draw : whiteMove;
            }
        } else { // if (color == 2)
            if (win) {
                return whiteWin;
            } else {
                return empty == 0 ? draw : blackMove;
            }
        }
    }

    /**
     * 输出棋盘目前状态
     */
    public void printBoard() {
        //第一行 写明列号
        System.out.print("  ");
        for (int i = 0; i < 19; i++) {
            System.out.print("  ");
            if (i < 9) {
                System.out.print(" ");
            }
            System.out.print(i + 1);
        }
        System.out.println();

        //第二行之后的 写明行号和棋盘情况
        for (int i = 0; i < 19; i++) {
            if (i < 9) {
                System.out.print(" ");
            }
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 19; j++) {
                System.out.print("| ");
                if (board[i][j] == 0) {
                    System.out.print("  ");
                } else if (board[i][j] == 1) {
                    System.out.print("X "); // X 代表 1 黑棋
                } else if (board[i][j] == 2) {
                    System.out.print("O "); // O 代表 2 白棋
                }
            }
            System.out.println(" |");
        }
    }

    public static void main(String[] args) {
        GoBangTest goBangTest = new GoBangTest();
        goBangTest.move(9, 9);
        goBangTest.move(9, 10);
        goBangTest.move(10, 9);
        goBangTest.move(10, 10);
        goBangTest.move(11, 9);
        goBangTest.move(11, 10);
        goBangTest.move(12, 9);
        goBangTest.move(12, 10);
        goBangTest.move(13, 9);
        goBangTest.move(13,10);
        goBangTest.move(14,9);
        goBangTest.move(14,10);
        goBangTest.printBoard();
    }
}
