package com.maneng.jpa.demo.controller;

import com.maneng.jpa.demo.dto.UserDTO;
import com.maneng.jpa.demo.foundation.base.result.Result;
import com.maneng.jpa.demo.frank.event.HelloEventService;
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
    private final HelloEventService helloEventService;

    public UserController(UserService userService, HelloEventService helloEventService) {
        this.userService = userService;
        this.helloEventService = helloEventService;
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

    @GetMapping("/say")
    public Result<String> sayHello(@RequestParam String from, @RequestParam String content) {
        helloEventService.sayHello(from, content);
        return new Result<>("success");
    }
}
