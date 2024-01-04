package com.markerhub.controller;

import com.markerhub.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 控制器父类
 */
public class BaseController {

    @Resource
    HttpServletRequest request;

    @Autowired
    RedisUtil redisUtil;

}
