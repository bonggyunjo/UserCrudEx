package com.example.exproject.Service;

import com.example.exproject.Dto.UserDto;
import com.example.exproject.Entity.UserEntity;
import com.example.exproject.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    회원 계정 생성(중복되는 id 찾기)
    */
    public UserEntity create(UserDto userDto) {
        String id = userDto.getId();
        log.info("DTO의 아이디" + id);

        Optional<UserEntity> target = userRepository.findById(id);
        log.info("Target" + target);

        target.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다!");
        });

        //1. Dto -> Entity
        UserEntity user = userDto.toEntity();

        //2. repository에게 entity를 디비에 저장하게 시킴
        UserEntity saved = userRepository.save(user);

        return saved;

    }
}
