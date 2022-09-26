package com.ll.exam.springbatchtest.app.member.repostiory;

import com.ll.exam.springbatchtest.app.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
