package com.example.quiz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class QuizApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        UserInformationService userInformationService =
                context.getBean(UserInformationService.class);
        QuestionService questionService =
                context.getBean(QuestionService.class);

        userInformationService.requestName();
        questionService.ask();
    }

}
