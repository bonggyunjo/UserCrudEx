package com.example.exproject.Dto;

import com.example.exproject.Entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String id;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String pw;

    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickname;

    //빌더 패턴
    @Builder
    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(id)
                .pw(pw)
                .nickname(nickname)
                .build();
    }
}
