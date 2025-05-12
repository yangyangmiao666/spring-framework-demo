package com.ustc.myy.springdatajpademo.repository;

import com.ustc.myy.springdatajpademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * UserRepository
 *
 * @author YangyangMiao
 * @version 1.0
 * @email yangyangmiao666@icloud.com
 * @date 2025/5/12 23:48
 */
public interface UserRepository extends JpaRepository<User, Long> {

    // 自动生成
    User findByEmail(String email);

    // 右模糊（以 keyword 开头）
    @Query("SELECT u FROM User u WHERE u.username LIKE CONCAT(?1, '%')")
    List<User> findByUsernameStartsWithCustom(String keyword);

    // 左模糊（以 keyword 结尾）
    @Query("SELECT u FROM User u WHERE u.username LIKE CONCAT('%', ?1)")
    List<User> findByUsernameEndsWithCustom(String keyword);

    // 全模糊（包含 keyword）
    @Query("SELECT u FROM User u WHERE u.username LIKE %?1%")
    List<User> findByUsernameContainsCustom(String keyword);
}
