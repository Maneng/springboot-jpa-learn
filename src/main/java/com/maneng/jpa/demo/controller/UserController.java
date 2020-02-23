package com.maneng.jpa.demo.controller;

import com.maneng.jpa.demo.dto.UserDTO;
import com.maneng.jpa.demo.foundation.base.result.Result;
import com.maneng.jpa.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author maneng
 * @date created at 2020/2/23 3:48 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Result<UserDTO> saveOrUpdateUser(UserDTO userDTO) {
        return userService.saveOrUpdateUser(userDTO);
    }

    @GetMapping("/{id}")
    public Result<UserDTO> getUser(@PathVariable(name = "id") Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteUser(@PathVariable(name = "id") Long id) {
        return userService.deleteUser(id);
    }
}
