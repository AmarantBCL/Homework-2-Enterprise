package com.example.quiz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    private static final String FILE_PATH = "questions.csv";

    @Bean("languageHandler")
    public LanguageHandler languageHandler() {
        return new LanguageHandler();
    }

    @Bean("userInformationService")
    public UserInformationService userInformationService() {
        return new UserInformationService();
    }

    @Bean("user")
    public User user() {
        return new User();
    }

    @Bean("resourceReader")
    public ResourceReader resourceReader() {
        return new ResourceReader(FILE_PATH);
    }

    @Bean("questionService")
    public QuestionService questionService() {
        return new QuestionService();
    }
}
