package com.ttxs.service;

import java.util.List;

/**
 * @author kai.hu
 * @date 2020/3/26 16:11
 */
public interface TestService {
    /**
     * aop测试
     * @param data 数据
     * @return 返回数据
     */
    List aopTest(List<String> data);
}
