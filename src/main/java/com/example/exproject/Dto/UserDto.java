package com.example.exproject.Dto;


import com.example.exproject.Entity.UserEntity;
import lombok.*;

@Data
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {


    private String id;


    private String pw;

    private String nickname;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(id)
                .pw(pw)
                .nickname(nickname)
                .build();
    }

}
