package com.ttxs.utils;

/**
 * @author kai.hu
 * @date 2020/3/23 11:30
 */
public class StringUtil {

    public static String reversString(String str) {
        return str == null ? null : new StringBuilder(str).reverse().toString();
    }
}
