package cn.zeromax.goBang.state;

public class WhiteMoveGameState extends GoBangGameState{
    @Override
    public void move(int x, int y) {
        System.out.println("现在是白棋行动状态");
        int color = 2;
        super.goBangTest.setGameState(super.goBangTest.moveOnBoard(x,y,color));
    }

    @Override
    public String toString(){
        return "白棋行动状态";
    }
}
