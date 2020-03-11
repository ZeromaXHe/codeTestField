package cn.zeromax.goBang.state;

public class DrawGameState extends GoBangGameState {
    @Override
    public void move(int x, int y) {
        System.out.println("已经和棋，无法走棋");
    }

    @Override
    public String toString() {
        return "和棋";
    }
}
