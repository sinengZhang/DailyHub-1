package com.markerhub.controller;

import com.markerhub.enity.User;
import com.markerhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    UserRepository userRepository;

    @ResponseBody
    @GetMapping("/test")
    public Object test() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @GetMapping("/testException")
    public Object testException() {
        User user = userRepository.findById(100L).get();
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @GetMapping("/ftl")
    public String ftl(HttpServletRequest request) {
        request.setAttribute("user", userRepository.findById(1L).get());
        return "test";
    }

}
