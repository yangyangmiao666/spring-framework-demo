package com.ustc.myy.springdatajpademo.service.impl;

import com.ustc.myy.springdatajpademo.entity.User;
import com.ustc.myy.springdatajpademo.repository.UserRepository;
import com.ustc.myy.springdatajpademo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void testJpa() {
        User user = userRepository.findByEmail("zhangsan@");
        System.out.println("根据邮箱查询用户：" + user);
        List<User> byNameStartingWith = userRepository.findByUsernameStartsWithCustom("李");
        System.out.println("右模糊查询：" + byNameStartingWith);
        List<User> byNameEndingWith = userRepository.findByUsernameEndsWithCustom("五");
        System.out.println("左模糊查询：" + byNameEndingWith);
        List<User> byNameContaining = userRepository.findByUsernameContainsCustom("miao");
        System.out.println("全模糊查询：" + byNameContaining);

        // 更新用户
        User user2 = userRepository.findById(5L).orElseThrow();
        user2.setUsername("哈哈1");
        userRepository.save(user2);

        // 插入用户
        User user1 = User.builder()
                .username("邓九")
                .email("dengjiu@qq.com")
                .password("qwer123")
                .active(true)
                .build();
        userRepository.save(user1);


        userRepository.findAll().forEach(System.out::println);
        userRepository.findAllById(List.of(1L, 2L)).forEach(System.out::println);
        userRepository.findById(1L).ifPresent(System.out::println);

        // 分页查询
        Page<User> page = userRepository.findAll(PageRequest.of(0, 10));
        System.out.println("分页查询：" + page);


    }
}
