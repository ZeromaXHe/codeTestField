package cn.zeromax.goBang.state;

public class BlackMoveGameState extends GoBangGameState{
    @Override
    public void move(int x, int y){
        System.out.println("现在是黑棋行动状态");
        int color = 1;
        super.goBangTest.setGameState(super.goBangTest.moveOnBoard(x,y,color));
    }

    @Override
    public String toString() {
        return "黑棋行动状态";
    }
}
