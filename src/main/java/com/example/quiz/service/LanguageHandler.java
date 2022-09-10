package com.example.quiz.service;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

@Getter
@Setter
public class LanguageHandler {
    private ResourceBundle bundle;
    private Locale locale;

    @PostConstruct
    public void selectLanguage(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select your language [en, ua]: ");
        locale = new Locale(scanner.nextLine());
        bundle = ResourceBundle.getBundle("language", locale);
    }
}
