package com.ustc.myy.springdatajpademo.controller;

import com.ustc.myy.springdatajpademo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author YangyangMiao
 * @version 1.0
 * @email yangyangmiao666@icloud.com
 * @date 2025/5/12 23:49
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test-jpa")
    public void testJpa() {
        userService.testJpa();
    }
}
