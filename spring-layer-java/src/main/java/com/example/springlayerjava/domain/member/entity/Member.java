package com.example.springlayerjava.domain.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

//엔티티입니다.
@Getter
@AllArgsConstructor
public class Member {
    private Long id;
    private String memberName;
    private String email;
    private String password;
    private String createdAt;
    private String updatedAt;
}
