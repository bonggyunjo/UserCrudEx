package com.example.exproject.Repository;
import com.example.exproject.Entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<UserEntity,String>{
    //아이디 중복확인
    boolean existsById(String id);

    //닉네임 중복확인
    boolean existsByNickname(String nickname);

    @Query("SELECT u.id from user u where u.id = :id")
    String findID(@Param("id") String id);

    @Query("SELECT u.pw from user u where u.id= :id")
    String findPW(@Param("id") String id);
}
