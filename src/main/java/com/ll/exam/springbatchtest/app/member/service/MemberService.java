package com.ll.exam.springbatchtest.app.member.service;

import com.ll.exam.springbatchtest.app.cash.entity.CashLog;
import com.ll.exam.springbatchtest.app.cash.service.CashService;
import com.ll.exam.springbatchtest.app.member.entity.Member;
import com.ll.exam.springbatchtest.app.member.repostiory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final CashService cashService;

    @Transactional
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

    @Transactional
    public long addCash(Member member, long price, String eventType) {
        CashLog cashLog = cashService.addCash(member, price, eventType);

        long newRestCash = member.getRestCash() + cashLog.getPrice();
        member.setRestCash(newRestCash);
        memberRepository.save(member);

        return newRestCash;
    }

    public long getRestCash(Member member) {
        return member.getRestCash();
    }
}
