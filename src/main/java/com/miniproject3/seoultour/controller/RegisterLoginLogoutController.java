package com.miniproject3.seoultour.controller;

import com.miniproject3.seoultour.data.dto.SurveyFormDto;
import com.miniproject3.seoultour.data.AuthType;
import com.miniproject3.seoultour.data.dto.MemberRequestDto;
import com.miniproject3.seoultour.data.entity.Member;
import com.miniproject3.seoultour.data.repository.TourSpotRepository;
import com.miniproject3.seoultour.data.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class RegisterLoginLogoutController {
    private final MemberService memberService;

    @Autowired
    private TourSpotRepository tourSpotRepository;

    @GetMapping("/survey")
    public String surveyForm(Model model) {
        model.addAttribute("surveyForm", new SurveyFormDto());
        return "survey";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String, String>> login(@RequestBody MemberRequestDto memberRequestDto) {
        Member member = new Member();
        member.setName(memberRequestDto.getName());
        member.setUserid(memberRequestDto.getUserid());
        member.setPassword(memberRequestDto.getPassword());
        member.setEmail(memberRequestDto.getEmail());
        member.setAuthType(AuthType.USER);

        Map<String, String> response = new HashMap<>();
        if (memberService.hasUserId(member.getUserid())) {
            response.put("status", "error");
            response.put("message", "아이디가 이미 존재합니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            Member registerdMember = memberService.createMember(member);
            if (registerdMember != null) {
                response.put("status", "success");
                response.put("message", "가입 성공");
                return ResponseEntity.ok(response);
            } else {
                response.put("status", "error");
                response.put("message", "가입 실패");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }


        }
    }
}
