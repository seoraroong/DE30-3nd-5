package com.miniproject3.seoultour.data.service;

import com.miniproject3.seoultour.data.dao.MemberDao;
import com.miniproject3.seoultour.data.dto.MemberRequestDto;
import com.miniproject3.seoultour.data.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean hasUserId(String userid) {
        return (memberDao.findByUserId(userid) != null) ? true : false ;
    }

    public Member createMember(Member member){
        // 암호화
        member.setPassword( bCryptPasswordEncoder.encode(member.getPassword()) );
        return memberDao.createMember(member);
    }

    public Member findByUserId(MemberRequestDto memberRequestDto){
        // DB에서 가져온 데이터
        Member member =  memberDao.findByUserId(memberRequestDto.getUserid());
        boolean isSuccess = false;
        if(member != null)
            isSuccess =  bCryptPasswordEncoder.matches( memberRequestDto.getPassword(),member.getPassword() );
        if(isSuccess)
            return member;
        else
            return null;
    }

}
