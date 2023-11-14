package com.example.exproject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name="user")
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column
    private String id;

    @Column
    private String pw;

    @Column
    private String nickname;

    @Builder
    public UserEntity(String id,String pw,String nickname) {
        this.id = id;
        this.pw = pw;
        this. nickname=nickname;
    }
}
