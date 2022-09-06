package com.example.quiz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    private static final String FILE_PATH = "questions.csv";

    @Bean
    public UserInformationService userInformationService() {
        return new UserInformationService(user());
    }

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public ResourceReader resourceReader() {
        return new ResourceReader(FILE_PATH);
    }

    @Bean
    public QuestionService questionService() {
        return new QuestionService(resourceReader());
    }
}
