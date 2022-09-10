package com.example.quiz.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

@Getter
public class QuestionService {
    @Autowired
    private ResourceReader resource;
    @Autowired
    private LanguageHandler languageHandler;
    private Integer questionNumber = 0;
    private Integer correctAnswers = 0;

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        resource.getRecords().forEach(q -> {
            System.out.println(buildQuestion());
            if (checkAnswer(scanner.nextLine())) {
                correctAnswers++;
            }
            questionNumber++;
        });
        System.out.println(languageHandler.getBundle().getString("correctAnswers") + correctAnswers);
    }

    private String buildQuestion() {
        List<String> record = resource.getRecords().get(questionNumber);
        return record.get(1) + " [" + String.join(
                ", ", record.get(2), record.get(3), record.get(4), record.get(5)) + "]";
    }

    private boolean checkAnswer(String answer) {
        return resource.getRecords().get(questionNumber).get(6).equals(answer);
    }
}
