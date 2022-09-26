package com.ll.exam.springbatchtest.app.member.service;

import com.ll.exam.springbatchtest.app.member.entity.Member;
import com.ll.exam.springbatchtest.app.member.repostiory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member join(String username, String password, String email) {
        Member member = Member
                .builder()
                .username(username)
                .password(password)
                .email(email)
                .build();

        memberRepository.save(member);

        return member;
    }
}
