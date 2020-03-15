package cn.zeromax.timer;

import java.util.Date;
import java.util.HashMap;

/**
 * 记录每个任务的时间
 */
public class TaskTimeSchedule {
    private int totalTime;
    private HashMap<Date, Integer> dateTimeMap;

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public HashMap<Date, Integer> getDateTimeMap() {
        return dateTimeMap;
    }

    public void setDateTimeMap(HashMap<Date, Integer> dateTimeMap) {
        this.dateTimeMap = dateTimeMap;
    }
}
