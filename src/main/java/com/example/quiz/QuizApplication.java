package com.example.quiz;

import com.example.quiz.service.QuestionService;
import com.example.quiz.service.UserInformationService;
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
