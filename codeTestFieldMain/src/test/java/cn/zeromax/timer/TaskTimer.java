package cn.zeromax.timer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * 用来记录自己做各种事情的时间
 */
public class TaskTimer {
    private HashMap<String, TaskTimeSchedule> timeMap = new HashMap<>();
    private String json = "";

    TaskTimer(){
        String filePath = "codeTestFieldMain\\src\\test\\java\\cn\\zeromax\\timertaskTimer.txt";
        File file = new File(filePath);
        if(file.exists()){
            System.out.println("timertaskTimer.txt文件存在，读取内容：");
            try (InputStream is = new FileInputStream(file)){
                StringBuilder sb = new StringBuilder();
                //读取数据
                //一次性取多少字节
                byte[] bytes = new byte[2048];
                //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
                int n = -1;
                //循环取出数据
                while ((n = is.read(bytes,0,bytes.length)) != -1) {
                    //转换成字符串
                    String str = new String(bytes,0,n, StandardCharsets.UTF_8); //这里可以实现字节到字符串的转换，比较实用
                    System.out.println(str);
                    //写入StringBuilder
                    sb.append(str);
                }
                json = sb.toString();
                System.out.println("读取结束");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                file.createNewFile();
                System.out.println("之前未创建timertaskTimer.txt文件，现在创建了，绝对路径为："+file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TaskTimer taskTimer = new TaskTimer();

    }
}