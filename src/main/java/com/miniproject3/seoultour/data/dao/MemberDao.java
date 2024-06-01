package com.miniproject3.seoultour.data.dao;

import com.miniproject3.seoultour.data.entity.Member;
import com.miniproject3.seoultour.data.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberDao{
    private final MemberRepository memberRepository;
    public Member createMember(Member memeber){
        return memberRepository.save(memeber);
    }
    public Member findByUserId(String userid){
        Optional<Member> findedMember =  memberRepository.findByUserid(userid);
        if(findedMember.isPresent())
            return findedMember.get();
        else
            return null;
    }
}
