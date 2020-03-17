package cn.zeromax.timer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.File;
import java.io.IOException;

public class TaskTimerController {
    private transient String json = "";
    private TaskTimer taskTimer;
    private final String filePath = "codeTestFieldMain\\src\\test\\java\\cn\\zeromax\\timer\\taskTimer.json";

    TaskTimerController() {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println(file.getName() + "文件存在，读取内容：");
            json = FileUtil.readFile(filePath);
            taskTimer = JSON.parseObject(json, new TypeReference<TaskTimer>() {
            });
            if (taskTimer == null) {
                taskTimer = new TaskTimer();
            }
        } else {
            taskTimer = new TaskTimer();
            try {
                file.createNewFile();
                System.out.println("之前未创建" + file.getName() + "文件，现在创建了，绝对路径为：" + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void startTask(String taskName) {
        taskTimer.startTask(taskName);
    }

    public void endTask(String taskName) {
        taskTimer.endTask(taskName);
    }

    public void save() {
        json = JSON.toJSONString(taskTimer);
        System.out.println("正在保存json: " + json + " 至path: " + filePath);
        FileUtil.writeToFile(filePath, json);
    }

    public static void main(String[] args) {
        TaskTimerController taskTimerController = new TaskTimerController();
        taskTimerController.startTask("测试");
        try {
            System.out.println("开始2s休眠");
            Thread.sleep(2000);
            System.out.println("结束休眠");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        taskTimerController.endTask("测试");
        taskTimerController.save();
    }
}
