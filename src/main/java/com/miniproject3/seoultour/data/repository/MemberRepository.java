package com.miniproject3.seoultour.data.repository;

import com.miniproject3.seoultour.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByUserid(String userId);
}
