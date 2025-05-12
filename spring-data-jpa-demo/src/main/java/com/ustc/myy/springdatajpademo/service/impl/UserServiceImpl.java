package com.ustc.myy.springdatajpademo.service.impl;

import com.ustc.myy.springdatajpademo.entity.User;
import com.ustc.myy.springdatajpademo.repository.UserRepository;
import com.ustc.myy.springdatajpademo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author YangyangMiao
 * @version 1.0
 * @email yangyangmiao666@icloud.com
 * @date 2025/5/12 23:48
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void testJpa() {
        User user = userRepository.findByEmail("zhangsan@");
        System.out.println("根据邮箱查询用户：" + user);
        List<User> byNameStartingWith = userRepository.findByUsernameStartsWithCustom("李");
        System.out.println("右模糊查询：" + byNameStartingWith);
        List<User> byNameEndingWith = userRepository.findByUsernameEndsWithCustom("五");
        System.out.println("左模糊查询：" + byNameEndingWith);
        List<User> byNameContaining = userRepository.findByUsernameContainsCustom("miao");
        System.out.println("全模糊查询：" + byNameContaining);
    }
}
