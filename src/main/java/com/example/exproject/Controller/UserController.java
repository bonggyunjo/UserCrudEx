package com.example.exproject.Controller;


import com.example.exproject.Dto.UserDto;
import com.example.exproject.Repository.UserRepository;
import com.example.exproject.Service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;
    UserService userService;

    //회원가입 페이지
    @GetMapping("/signup")
    public String showSignUp() {
        return "/SignUp/SignUp";
    }

    //로그인 페이지
    @GetMapping("/login")
    public String LoginmainPage(Model model){
        model.addAttribute("warningMessage", "");
        model.addAttribute("errorMessage", "");
        return "Login/Login";
    }


    //로그인 페이지에서 아이디 및 비밀번호 검사
    @PostMapping("/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {

        String id = userRepository.findID(username);
        model.addAttribute("warningMessage", "");
        model.addAttribute("errorMessage", "");

        if (id == null) {
            //아이디 없을 때 로직 처리
            model.addAttribute("warningMessage", "해당 사용자명으로 등록된 아이디가 없습니다.");
            log.info("아이디에러");
        } else {
            //있을 때 로직 처리
            if (!password.equals(userRepository.findPW(username))) {
                model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
                log.info("비밀번호에러");
            } else
            {
                session.setAttribute("ID",username);
                model.addAttribute("warningMessage", "");
                model.addAttribute("errorMessage", "");
                return null; // 메인페이지 이동
            }
        }
        return "Login/Login";
    }


    // 유효성 검사 로직 Errors
    @PostMapping("/signup")
    public String execSignup(@Valid UserDto userDto, Errors errors, Model model) {
        model.addAttribute("message", "");

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
        else {
            userService.create(userDto);
            model.addAttribute("message", "회원가입에 성공하였습니다!"); // 회원가입 성공 메시지 추가
            return "redirect:/login"; //로그인 페이지 이동
        }
    }
}