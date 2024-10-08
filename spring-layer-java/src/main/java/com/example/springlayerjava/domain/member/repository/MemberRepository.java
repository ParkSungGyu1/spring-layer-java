package com.example.springlayerjava.domain.member.repository;

import com.example.springlayerjava.domain.member.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    public Member findById(long id) {
        return new Member(
                id,
                "memberName1",
                "email@email.com",
                "123123",
                "2024-10-08",
                "2024-10-10"
        );

    }
}
