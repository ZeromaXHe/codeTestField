package cn.zeromax.goBang;

import java.util.LinkedList;

public class GoBangTest {
    private int[][] board; // 0 未下子, 1 黑棋, 2 白棋
    private int roundCount; // 回合数，记录第几回合
    private int empty; // 空余空格数量
    private int gameStatus; // 0 未开局, 1 黑方行动, 2 白方行动, -1 黑方胜利, -2 白方胜利, -3 平局 TODO: 改造成Enum? 试试状态模式?
    private LinkedList<int[]> moveStack; // 落子记录 格式为[color, x, y]

    GoBangTest() {// ToDo: 试着写个单例?
        board = new int[19][19]; // 19 * 19 棋盘
        roundCount = 0;
        empty = 19 * 19;
        gameStatus = 0;
        moveStack = new LinkedList<>();
    }

    /**
     * 下子
     * @param x 横坐标
     * @param y 纵坐标
     */
    public void move(int x, int y) {
        int color = 1;
        if (gameStatus == 1 || gameStatus == 2) {
            color = gameStatus;
        }
        board[x][y] = color;
        moveStack.add(new int[]{color, x, y});
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

    /**
     * 输出棋盘目前状态
     */
    public void printBoard(){
        //第一行 写明列号
        System.out.print("  ");
        for (int i = 0; i < 19; i++) {
            System.out.print("  ");
            if(i<9){
                System.out.print(" ");
            }
            System.out.print(i+1);
        }
        System.out.println();

        //第二行之后的 写明行号和棋盘情况
        for (int i = 0; i < 19; i++) {
            if(i<9){
                System.out.print(" ");
            }
            System.out.print((i+1)+" ");
            for (int j = 0; j < 19; j++) {
                System.out.print("| ");
                if(board[i][j]==0){
                    System.out.print("  ");
                }else if(board[i][j]==1){
                    System.out.print("X "); // X 代表 1 黑棋
                }else if(board[i][j]==2){
                    System.out.print("O "); // O 代表 2 白棋
                }
            }
            System.out.println(" |");
        }
    }

    public static void main(String[] args) {
        GoBangTest goBangTest = new GoBangTest();
        goBangTest.move(9,9);
        goBangTest.printBoard();
    }
}
