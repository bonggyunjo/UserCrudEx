package com.example.exproject.Repository;

import com.example.exproject.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;


public interface UserRepository extends CrudRepository<UserEntity,String> {
    //아이디 중복확인
    boolean existsById(String id);
    //닉네임 중복확인
    boolean existsByNickname(String nickname);
}
