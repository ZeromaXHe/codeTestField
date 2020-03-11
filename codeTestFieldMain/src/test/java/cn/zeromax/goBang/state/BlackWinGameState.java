package cn.zeromax.goBang.state;

public class BlackWinGameState extends GoBangGameState{
    @Override
    public void move(int x, int y) {
        System.out.println("黑棋已经胜利，无法走棋");
    }

    @Override
    public String toString() {
        return "黑棋胜利";
    }
}
