package com.maneng.jpa.demo.manager;

import com.maneng.jpa.demo.entity.User;
import com.maneng.jpa.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author maneng
 * @date created at 2020/2/23 3:30 下午
 */
@Component
@Slf4j
public class UserManager {

    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        return userRepository.getOne(id);
    }

    public User saveOrUpdateUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
