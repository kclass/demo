package com.ttxs.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kai.hu
 * @date 2020/4/1 16:59
 */
public class FileUtil {

    /**
     * 将数据写入目标文件，并按条换行
     * @param data 数据
     * @param filePath 文件路径
     */
    public static void writeText(List<String> data, String filePath, String fileName) throws IOException {
        creatFile(filePath, fileName);
        File file = new File(filePath + "/" + fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        data.forEach(re -> {
            try {
                bw.write(re + "\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.flush();
        bw.close();
    }

    /**
     * 读取文本文件，将每一行数据封装到list集合中
     * @param filePath 目标文件路径
     * @return 结果集
     */
    public static List<String> readText(String filePath) throws IOException {
        List<String> result = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String tempStr;
        while ((tempStr = br.readLine()) != null) {
            result.add(tempStr.trim());
        }
        return result;
    }

    /**
     * 根据文件路径创建文件夹
     * @param filePath 文件路径
     * @return 是否创建成功
     */
    public static boolean creatDir(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return false;
    }

    /**
     * 根据文件路径和文件名称创建文件
     * @param filePath 文件夹路径
     * @param fileName 文件名称
     * @return 是否创建成功
     * @throws IOException 文件创建异常
     */
    public static boolean creatFile(String filePath, String fileName) throws IOException {
        creatDir(filePath);
        File file = new File(filePath+"/"+fileName);
        if (!file.exists() || !file.isDirectory()) {
            return file.createNewFile();
        }
        return false;
    }
}
