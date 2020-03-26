package com.ttxs.service.impl;

import com.ttxs.annotation.BatchList;
import com.ttxs.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kai.hu
 * @date 2020/3/26 16:12
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    @BatchList
    public List aopTest(List<String> data) {
        return data;
    }
}
