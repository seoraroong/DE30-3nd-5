package com.miniproject3.seoultour.controller;

import com.miniproject3.seoultour.data.dto.SurveyFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RegisterLoginLogoutController {

    @GetMapping("/login1")
    public String login() {
        return "logintest";
    }

    @GetMapping("/survey")
    public String surveyForm(Model model) {
        model.addAttribute("surveyForm", new SurveyFormDto());
        return "survey";
    }

    @GetMapping("/logout-success")
    public String logout() {
        return "logintest";
    }
}
