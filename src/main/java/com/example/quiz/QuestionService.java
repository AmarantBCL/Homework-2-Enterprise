package com.example.quiz;

import lombok.Getter;

import java.util.List;
import java.util.Scanner;

@Getter
public class QuestionService {
    private final ResourceReader resource;
    private Integer questionNumber = 0;
    private Integer correctAnswers = 0;

    public QuestionService(ResourceReader resource) {
        this.resource = resource;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        resource.getRecords().forEach(q -> {
            System.out.println(buildQuestion());
            if (checkAnswer(scanner.nextLine())) {
                correctAnswers++;
            }
            questionNumber++;
        });
        System.out.println("Correct answers: " + correctAnswers);
    }

    private String buildQuestion() {
        List<String> record = resource.getRecords().get(questionNumber);
        return record.get(0) + " [" + String.join(
                ", ", record.get(1), record.get(2), record.get(3), record.get(4)) + "]";
    }

    private boolean checkAnswer(String answer) {
        return resource.getRecords().get(questionNumber).get(5).equals(answer);
    }
}
