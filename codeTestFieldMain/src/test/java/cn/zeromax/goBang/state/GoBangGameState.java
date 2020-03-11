package cn.zeromax.goBang.state;

import cn.zeromax.goBang.GoBangTest;

/**
 * 五子棋游戏状态
 */
public abstract class GoBangGameState {
    //定义一个环境角色，供子类访问
    protected GoBangTest goBangTest;

    //设置环境角色
    public void setGoBangTest(GoBangTest goBangTest){
        this.goBangTest = goBangTest;
    }

    public abstract void move(int x, int y);
}
