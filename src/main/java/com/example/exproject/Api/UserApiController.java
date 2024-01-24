package com.example.exproject.Api;

import com.example.exproject.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
아아디, 닉네임 중복확인을 위한 로직
*/

@RestController
public class UserApiController {
    private UserService userService;
    public UserApiController(UserService userService){
        this.userService=userService;
    }


    //아이디 중복확인
@PostMapping("checkid")
public ResponseEntity<Boolean> checkid(@RequestParam("id") String id){
    boolean exists = userService.existsById(id);
    // log.info("디비 잘 작동함");
    return new ResponseEntity<>(exists, HttpStatus.OK);
}

    //닉네임 중복확인
    @PostMapping("checknickname")
    public ResponseEntity<Boolean> checknickname(@RequestParam("nickname") String nickname){
        boolean exists = userService.existsByNickName(nickname);
        // log.info("디비 잘 작동함");
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}
