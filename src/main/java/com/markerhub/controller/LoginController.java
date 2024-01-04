package com.markerhub.controller;

import cn.hutool.core.util.RandomUtil;
import lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1. 获取验证码
 */
@Slf4j
@Controller
public class LoginController extends BaseController {


    @GetMapping("/login")
    public String login() {
        String code = "DY" + RandomUtil.randomNumbers(4);

        while (redisUtil.hasKey(code)) {
            code = "DY" + RandomUtil.randomNumbers(4);
        }

        String ticket = RandomUtil.randomNumbers(32);
        redisUtil.set("ticket-" + code, ticket);

        request.setAttribute("code", code);
        request.setAttribute("ticket", ticket);

        return "login";
    }


    @ResponseBody
    @GetMapping("login-check")
    public Result loginCheck() {

        return Result.failure("未登录");
    }
}
