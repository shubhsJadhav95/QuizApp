package com.shubhs.quiz_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ElementCollection
    @CollectionTable(
            name = "quiz_questions",
            joinColumns = @JoinColumn(name = "quiz_id")
    )
    @Column(name = "question_id")
    private List<Integer> questionIds;
}
