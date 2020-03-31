package com.ttxs.utils;

/**
 * @author kai.hu
 * @date 2020/3/31 10:57
 */
public class ArraysUtil {

    /**
     * 判断数组是否是null或者空数组
     * @param obj 数组实例
     * @return 结果
     */
    public static boolean isNullOrEmpty(Object[] obj) {
        return obj == null || obj.length == 0;
    }

    /**
     * 判断数组是否不是null或者空数组
     * @param obj 数组实例
     * @return 结果
     */
    public static boolean isNotNullOrEmpty(Object[] obj) {
        return !isNullOrEmpty(obj);
    }
}
