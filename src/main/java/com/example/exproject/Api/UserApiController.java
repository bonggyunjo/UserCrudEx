package com.example.exproject.Api;

import com.example.exproject.Dto.UserDto;
import com.example.exproject.Entity.UserEntity;
import com.example.exproject.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

public class UserApiController {
/*
    private UserService userService;

    public UserApiController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/SignUp/SignUp/{id}")
    public ResponseEntity<Boolean> checkId(@PathVariable String id) {
        return ResponseEntity.ok(userService.existsById(id));
    }
    @GetMapping("/SignUp/SignUp/{id}")
    public ResponseEntity<Boolean> checkNickname(@PathVariable String nickname) {
        return ResponseEntity.ok(userService.existsById(nickname));
    }
*/
}
