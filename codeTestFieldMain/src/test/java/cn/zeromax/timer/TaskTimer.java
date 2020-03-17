package cn.zeromax.timer;

import java.util.HashMap;

/**
 * 用来记录自己做各种事情的时间
 */
public class TaskTimer {
    private HashMap<String, TaskTimeSchedule> timeMap = new HashMap<>();
    private long startTime = 0;
    private String currentTask = "";

    public HashMap<String, TaskTimeSchedule> getTimeMap() {
        return timeMap;
    }

    public void setTimeMap(HashMap<String, TaskTimeSchedule> timeMap) {
        this.timeMap = timeMap;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(String currentTask) {
        this.currentTask = currentTask;
    }

    TaskTimer() {

    }

    public void startTask(String taskName) {
        if ("".equals(currentTask)) {
            startTime = System.currentTimeMillis();
            currentTask = taskName;
        } else {
            System.out.println("已有任务正在进行，无法开始新的任务");
        }
    }

    public void endTask(String taskName) {
        if (taskName != null && taskName.equals(currentTask)) {
            long endTime = System.currentTimeMillis();
            if (timeMap.containsKey(currentTask)) {
                TaskTimeSchedule taskTimeSchedule = timeMap.get(currentTask);
                taskTimeSchedule.addTaskTime(startTime, endTime);
            } else {
                timeMap.put(currentTask, new TaskTimeSchedule(startTime, endTime));
            }
        } else {
            System.out.println("当前无任务进行，无法停止");
        }

        startTime = 0;
        currentTask = "";
    }
}