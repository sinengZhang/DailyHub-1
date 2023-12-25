package com.markerhub.controller;

import com.markerhub.enity.User;
import com.markerhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    UserRepository userRepository;


    @ResponseBody
    @GetMapping("/test")
    public  Object test(){
        List<User> userListAfterDelete = userRepository.findAll();
        return userListAfterDelete;
    }
}
