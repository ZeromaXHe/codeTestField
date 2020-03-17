package cn.zeromax.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * 记录每个任务的时间
 */
public class TaskTimeSchedule {
    private long totalTime;
    private LinkedList<long[]> startTimeAndEndTimeList;

    TaskTimeSchedule() {
        totalTime = 0;
        startTimeAndEndTimeList = new LinkedList<>();
    }

    TaskTimeSchedule(long startTime, long endTime) {
        this(); //调用无参构造方法
        addTaskTime(startTime, endTime);
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public LinkedList<long[]> getStartTimeAndEndTimeList() {
        return startTimeAndEndTimeList;
    }

    public void setStartTimeAndEndTimeList(LinkedList<long[]> startTimeAndEndTimeList) {
        this.startTimeAndEndTimeList = startTimeAndEndTimeList;
    }

    public void addTaskTime(long startTime, long endTime) {
        totalTime += endTime - startTime;
        // TODO: 这里设计也有点问题，之后考虑一下如何优化
        startTimeAndEndTimeList.add(new long[]{startTime, endTime});
    }

    private String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        TaskTimeSchedule taskTimeSchedule = new TaskTimeSchedule(now - 1000L * 60 * 60 * 24 * 365, now);
    }
}
