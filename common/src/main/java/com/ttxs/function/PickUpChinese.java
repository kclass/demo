package com.ttxs.function;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kai.hu
 * @date 2020/3/31 10:18
 */
public class PickUpChinese {
    /**
     * 使用正则表达式
     * [\u4E00-\u9FA5]是unicode2的中文区间
     */
    private Pattern pattern = Pattern.compile("[^\u4E00-\u9FA5]");

    /**
     * 结果集
     */
    private Set<String> result = new TreeSet<>();

    /**
     * 需要读取的文件路径
     */
    private String filePath;

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setResultPath(String resultPath) {
        this.resultPath = resultPath;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Set<String> getResult() {
        return result;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getResultPath() {
        return resultPath;
    }

    /**
     * 结果输出文件路径
     */
    private String resultPath;

    public void execute() {
        readDirectory(filePath);
        write();
    }

    /**
     * 输出结果集
     */
    private void write() {
        try {
            File file = new File(resultPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            result.forEach(re -> {
                try {
                    bw.write(re + "\r\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归读取文件夹下的文本文件
     *
     * @param path 路径
     */
    private void readDirectory(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (!"asserts".equals(file1.getName())) {
                    readDirectory(file1.getPath());
                }
            }
        } else {
            String fileName = file.getName();
            //判断读取的文件类型
            if (
                    fileName.endsWith(".vue")
                            || fileName.endsWith(".js")
                            || fileName.endsWith(".html")
                            || fileName.endsWith(".txt")
            ) {
                getChinese(readFile(file));
            }
        }
    }

    /**
     * 读取文件
     *
     * @param file 文件
     * @return 文本内容
     */
    private String readFile(File file) {
        BufferedReader reader = null;
        StringBuilder sbf = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            boolean jump = false;
            while ((tempStr = reader.readLine()) != null) {
                //过滤注释
                if (tempStr.trim().startsWith("//")) {
                    sbf.append(tempStr, 0, tempStr.indexOf('/'));
                    continue;
                }
                //过滤 "<!-- -->" 或者 "/* */" 只能过滤大部分
                if (tempStr.contains("/*")) {
                    sbf.append(tempStr, 0, tempStr.indexOf('/'));
                    jump = true;
                } else if (tempStr.contains("<!--")) {
                    jump = true;
                }

                if (!jump) {
                    sbf.append(tempStr).append("&");
                }

                if (tempStr.trim().endsWith("*/") || tempStr.trim().endsWith("-->")) {
                    jump = false;
                }
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    /**
     * 提取字符串中的中文
     *
     * @param str 需提取的字符串
     */
    private void getChinese(String str) {
        Matcher matcher = pattern.matcher(str);
        String[] strs = matcher.replaceAll(" ").trim().split("\\s+");
        result.addAll(Arrays.asList(strs));
    }
}
