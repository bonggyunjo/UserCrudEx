package com.example.exproject.Repository;

import com.example.exproject.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;


public interface UserRepository extends CrudRepository<UserEntity,String> {

    boolean existsById(String id);
    boolean existsByNickname(String nickname);

    @Query("select u.id from user u where u.id = :id")
    String findID(@RequestParam String id);

}
