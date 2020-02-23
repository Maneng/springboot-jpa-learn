package com.maneng.jpa.demo.service.impl;

import com.maneng.jpa.demo.assembler.UserAssembler;
import com.maneng.jpa.demo.dto.UserDTO;
import com.maneng.jpa.demo.entity.User;
import com.maneng.jpa.demo.foundation.base.result.Result;
import com.maneng.jpa.demo.manager.UserManager;
import com.maneng.jpa.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author maneng
 * @date created at 2020/2/23 3:51 下午
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserManager userManager;
    private final UserAssembler userAssembler;

    public UserServiceImpl(UserManager userManager, UserAssembler userAssembler) {
        this.userManager = userManager;
        this.userAssembler = userAssembler;
    }

    @Override
    public Result<UserDTO> saveOrUpdateUser(UserDTO userDTO) {
        User user = userAssembler.assemblerUser(userDTO);
        return new Result<>(userAssembler.assemblerUserDTO(userManager.saveOrUpdateUser(user)));
    }

    @Override
    public Result<Void> deleteUser(Long id) {
        Result<Void> result = new Result<>();
        User user = userManager.getUser(id);
        if (null == user) {
            log.info("entity not exists, user id: {}", id);
        } else {
            userManager.delete(user);
        }
        return result;
    }

    @Override
    public Result<UserDTO> getUser(Long id) {
        Result<UserDTO> result = new Result<>();
        UserDTO userDTO = userAssembler.assemblerUserDTO(userManager.getUser(id));
        result.setResult(userDTO);
        return result;
    }

}
