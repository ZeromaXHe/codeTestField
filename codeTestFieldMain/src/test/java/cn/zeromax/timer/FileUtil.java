package cn.zeromax.timer;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtil {
    public static String readFile(String path) {
        StringBuilder sb = new StringBuilder();

        try (InputStream is = new FileInputStream(path);
             InputStreamReader inputStreamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String tempString;
            //读取数据
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
                System.out.println(tempString);
            }
            System.out.println("读取结束");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    @Deprecated
    public static String readFileWithLessEfficiency(String path) {
        StringBuilder sb = new StringBuilder();
        try (InputStream is = new FileInputStream(path)) { //new FileInputStream(path) = new FileInputStream(new File(path))
            //读取数据
            //一次性取多少字节
            byte[] bytes = new byte[2048];
            //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
            int n;
            //循环取出数据
            while ((n = is.read(bytes, 0, bytes.length)) != -1) {
                //转换成字符串
                String str = new String(bytes, 0, n, StandardCharsets.UTF_8); //这里可以实现字节到字符串的转换，比较实用
                System.out.println(str);
                //写入StringBuilder
                sb.append(str);
            }
            System.out.println("读取结束");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void writeToFile(String path, String content) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
             BufferedWriter bw = new BufferedWriter(fileWriter)) {
            bw.write(content);
            System.out.println("写入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
