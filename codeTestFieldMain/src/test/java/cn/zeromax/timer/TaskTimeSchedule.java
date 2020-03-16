package cn.zeromax.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 记录每个任务的时间
 */
public class TaskTimeSchedule {
    private long totalTime;
    private HashMap<Date, Long> dateTimeMap;

    TaskTimeSchedule() {
        totalTime = 0;
        dateTimeMap = new HashMap<>();
    }

    TaskTimeSchedule(long startTime, long endTime) {
        this(); //调用无参构造方法
        addTaskTime(startTime, endTime);
    }

    public long getTotalTime() {
        return totalTime;
    }

    public HashMap<Date, Long> getDateTimeMap() {
        return dateTimeMap;
    }

    public void addTaskTime(long startTime, long endTime) {
        totalTime += endTime - startTime;
        // TODO: 还没写写入HASHMAP的过程，这里设计也有点问题，之后考虑一下如何优化
    }

    private String transferLongToDate(String dateFormat,Long millSec){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date= new Date(millSec);
        return sdf.format(date);
    }

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        TaskTimeSchedule taskTimeSchedule = new TaskTimeSchedule(now-1000L*60*60*24*365,now);//TODO: 来个大时间段就崩了，兄弟。这里要优化
    }
}
