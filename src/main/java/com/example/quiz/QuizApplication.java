package com.example.quiz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class QuizApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        UserInformationService userInformationService = context.getBean(UserInformationService.class);
        QuestionService questionService = context.getBean(QuestionService.class);
        userInformationService.requestName();
        questionService.execute();
    }
}
