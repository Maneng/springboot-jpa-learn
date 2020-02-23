package com.maneng.jpa.demo.assembler;

import com.maneng.jpa.demo.dto.UserDTO;
import com.maneng.jpa.demo.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author maneng
 * @date created at 2020/2/23 3:39 下午
 */
@Component
public class UserAssembler {

    public UserDTO assemblerUserDTO(User user) {
        if (null == user) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public User assemblerUser(UserDTO userDTO) {
        if (null == userDTO) {
            return null;
        }

        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
