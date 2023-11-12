package com.example.exproject.Api;

import com.example.exproject.Dto.UserDto;
import com.example.exproject.Entity.UserEntity;
import com.example.exproject.Service.UserService;
import org.h2.engine.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserApiController {
    private UserService userService;

    public UserApiController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/SignUp/SignUp")
    public ResponseEntity<UserEntity> saveUserInfo(@RequestBody UserDto userDto) {
        UserEntity saved = userService.create(userDto);
        return (saved != null) ?
                ResponseEntity.status(HttpStatus.OK).body(saved) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
