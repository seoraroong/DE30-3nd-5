package com.miniproject3.seoultour.data.dto;

import lombok.Data;

@Data
public class SurveyFormDto {
    private boolean[] surveyOptions = new boolean[5];
}