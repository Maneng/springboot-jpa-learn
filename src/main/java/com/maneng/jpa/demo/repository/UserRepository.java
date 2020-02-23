package com.maneng.jpa.demo.repository;

import com.maneng.jpa.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author maneng
 * @date created at 2020/2/23 3:29 下午
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
