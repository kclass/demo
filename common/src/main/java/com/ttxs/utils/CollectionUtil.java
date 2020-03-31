package com.ttxs.utils;

import java.util.Collection;

/**
 * @author kai.hu
 * @date 2020/3/31 10:48
 */
public class CollectionUtil {

    /**
     * 判断集合是否是null或空集合
     * @param t 集合实例
     * @param <T> 限定集合
     * @return 判断结果
     */
    public static <T extends Collection> boolean isNullOrEmpty(T t) {
        return t == null || t.size() != 0;
    }

    /**
     * 判断集合是否不是null或空集合
     * @param t 集合实例
     * @param <T> 限定集合
     * @return 判断结果
     */
    public static <T extends Collection> boolean isNotNullOrEmpty(T t) {
        return !isNullOrEmpty(t);
    }
}
