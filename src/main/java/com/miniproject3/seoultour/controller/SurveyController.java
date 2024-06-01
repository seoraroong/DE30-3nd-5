package com.miniproject3.seoultour.controller;

import com.miniproject3.seoultour.data.dto.SurveyFormDto;
import com.miniproject3.seoultour.data.entity.TourSpot;
import com.miniproject3.seoultour.data.repository.TourSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class SurveyController{

    @Autowired
    private TourSpotRepository tourSpotRepository;


    @PostMapping("/recommand")
    public String submitSurvey(SurveyFormDto surveyForm, Model model) {
        List<String> selectedTourTypes = new ArrayList<>();

        // 체크박스 순서에 따라 투어 유형 매핑
        String[] tourTypeMapping = {"관광지", "문화시설", "레포츠", "축제공연행사", "쇼핑"};

        // surveyForm에서 체크된 항목을 기반으로 selectedTourTypes 리스트 구성
        for (int i = 0; i < surveyForm.getSurveyOptions().length; i++) {
            if (surveyForm.getSurveyOptions()[i]) {
                // 체크박스가 선택되었으면 해당 순서에 맞는 투어 유형을 리스트에 추가
                selectedTourTypes.add(tourTypeMapping[i]);
            }
        }

        // 선택된 투어 유형에 해당하는 관광지 검색
        List<TourSpot> tourSpots = tourSpotRepository.findByTourtypeIn(selectedTourTypes);
        // model.addAttribute("selectedTourSpots", tourSpots);

        // 관광지를 투어 유형별로 그룹화
        Map<String, List<TourSpot>> tourSpotsByType = tourSpots.stream()
                .collect(Collectors.groupingBy(TourSpot::getTourtype));

        model.addAttribute("tourSpotsByType", tourSpotsByType);

        return "recommand";

    }
}

