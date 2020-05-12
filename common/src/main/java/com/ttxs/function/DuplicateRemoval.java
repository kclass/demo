package com.ttxs.function;

import com.ttxs.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kai.hu
 * @date 2020/4/1 16:54
 *
 * e.g {
 *          String primalFilePath = "D:\\test\\已翻译.txt";
 *         String targetFilePath = "D:\\test\\target";
 *         String writeTo = "D:\\test\\result";
 *         new DuplicateRemoval().execute(primalFilePath, targetFilePath, writeTo);
 *      }
 */
public class DuplicateRemoval {
    /**
     * 已存在的文件
     */
    private List<String> primal;

    /**
     * 返回的结果
     */
    private List<String> result;

    /**
     * 写目标文件夹
     */
    private String writeTo;

    /**
     * 根据一个文件内容去重一个文件夹下的文本内容,并逐个输出到目标文件夹
     * @param primalFilePath 去重对比文件路径
     * @param targetFilePath 去重目标文件夹路径
     */
    public void execute(String primalFilePath, String targetFilePath, String writeTo) throws IOException {
        this.writeTo = writeTo;
        //1.读取去重对比文件
        primal = FileUtil.readText(primalFilePath);

        //2.逐个读取目标文件内容，去重后输出到指定文件路径
        duplicateRemovalAndWrite(targetFilePath);

    }

    /**
     * 读取文件，去重后输出
     * @param targetFilePath 需去重的文件夹路径
     * @throws IOException io异常
     */
    private void duplicateRemovalAndWrite(String targetFilePath) throws IOException {
        File file = new File(targetFilePath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    duplicateRemovalAndWrite(file1.getPath());
                }
            }
        } else {
            readAndRemoval(file.getAbsolutePath());
            FileUtil.writeText(result, writeTo, file.getName());
        }
    }

    private void readAndRemoval(String filePath) throws IOException {
        result = FileUtil.readText(filePath).stream().filter(e -> !primal.contains(e)).collect(Collectors.toList());
    }
}
