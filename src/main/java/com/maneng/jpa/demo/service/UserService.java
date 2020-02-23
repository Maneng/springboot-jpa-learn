package com.maneng.jpa.demo.service;

import com.maneng.jpa.demo.dto.UserDTO;
import com.maneng.jpa.demo.foundation.base.result.Result;

/**
 * @author maneng
 * @date created at 2020/2/23 3:36 下午
 */
public interface UserService {

    Result<UserDTO> saveOrUpdateUser(UserDTO userDTO);

    Result<Void> deleteUser(Long id);

    Result<UserDTO> getUser(Long id);
}
