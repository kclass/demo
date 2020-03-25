package com.ttxs.utils;

import com.ttxs.exception.UnsatisfactoryException;

/**
 * 算术类工具类
 *
 * @author kai.hu
 * @date 2020/3/25 15:55
 */
public class ArithmeticUtil {

    /**
     * 反转一个32位整数
     * e.g -123 -> -321
     *
     * @param num 需要反转的数字
     * @return 反转后的数字
     */
    public static int reversNumber(int num) {
        try {
            int revers = Integer.parseInt(StringUtil.reversString(Math.abs(num) + ""));
            return num > 0 ? revers : -revers;
        } catch (NumberFormatException e) {
            throw new UnsatisfactoryException("反转后导致内存溢出：" + num);
        }
    }
}
