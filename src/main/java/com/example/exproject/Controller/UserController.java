package com.example.exproject.Controller;


import com.example.exproject.Dto.UserDto;
import com.example.exproject.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
@Slf4j
public class UserController {
    private UserService userService;
    /* 회원가입 뷰 페이지  */
    @GetMapping("/signup")
    public String showSignUp() {
        return "/SignUp/SignUp";
    }
    /* 로그인 뷰 페이지  */
    @GetMapping("/login")
    public String showLogin(){
        return "/Login/Login";
    }

    // 유효성 검사 로직 Errors
    @PostMapping("/signup")
    public String execSignup(@Valid UserDto userDto, Errors errors, Model model) {
        Map<String, String> response = new HashMap<>();
        if (errors.hasErrors()) {
            // 회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("userDto", userDto);

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet())
            {
                model.addAttribute(key, validatorResult.get(key));
            }
            return "/SignUp/SignUp"; // 회원가입 페이지 유지
        }

        userService.create(userDto);
        return "redirect:/login"; //로그인 페이지 이동
    }
}