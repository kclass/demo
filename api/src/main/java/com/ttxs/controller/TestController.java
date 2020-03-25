package com.ttxs.controller;

import com.ttxs.utils.ArithmeticUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kai.hu
 * @date 2020/3/23 11:35
 */
@RestController
@RequestMapping("test")
@Api(tags = "test")
public class TestController {

    @ApiOperation("反转字符串")
    @RequestMapping("reverseInt")
    public String reverseInt(Integer num) {
        return ArithmeticUtil.reversNumber(num) + "";
    }

}
