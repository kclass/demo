package com.ttxs.controller;

import com.ttxs.service.TestService;
import com.ttxs.utils.ArithmeticUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai.hu
 * @date 2020/3/23 11:35
 */
@RestController
@RequestMapping("test")
@Api(tags = "test")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @ApiOperation("反转字符串")
    @GetMapping("reverseInt")
    public String reverseInt(Integer num) {
        return ArithmeticUtil.reversNumber(num) + "";
    }

    @ApiOperation("aop测试")
    @GetMapping("aopTest")
    public List aopTest() {
        List<String> data = new ArrayList<>();
        data.add("hafsd");
        data.add("hafsd");
        data.add("hafsd");
        data.add("hafsd");
        data.add("hafsd");
        return testService.aopTest(data);
    }

}
