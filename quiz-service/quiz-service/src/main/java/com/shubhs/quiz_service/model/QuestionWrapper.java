package com.shubhs.quiz_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWrapper {
    private int id;
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
