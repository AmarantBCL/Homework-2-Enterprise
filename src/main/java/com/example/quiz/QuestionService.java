package com.example.quiz;

import lombok.Getter;

import java.util.List;
import java.util.Scanner;

@Getter
public class QuestionService {
    private final ResourceReader resource;
    private int number;
    private int correctAnswers;

    public QuestionService(ResourceReader resource) {
        this.resource = resource;
    }

    public void ask() {
        Scanner scanner = new Scanner(System.in);
        while (number < resource.getRecords().size()) {
            System.out.println(buildQuestion());
            if (checkAnswer(scanner.nextLine())) {
                correctAnswers++;
            }
            number++;
        }
        System.out.println("Correct answers: " + correctAnswers);
    }

    private String buildQuestion() {
        List<String> record = resource.getRecords().get(number);
        return record.get(0) + " [" + String.join(
                ", ", record.get(1), record.get(2), record.get(3), record.get(4)) + "]";
    }

    private boolean checkAnswer(String answer) {
        return resource.getRecords().get(number).get(5).equals(answer);
    }
}
