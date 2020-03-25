package com.ttxs.utils;

/**
 * @author kai.hu
 * @date 2020/3/23 11:30
 */
public class StringUtil {

    /**
     * 反转字符串,为null则返回null
     *
     * @param str 需处理的字符串
     * @return 发转后的字符串
     */
    public static String reversString(String str) {
        return str == null ? null : new StringBuilder(str).reverse().toString();
    }
}
