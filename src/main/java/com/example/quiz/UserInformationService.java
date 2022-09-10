package com.example.quiz;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

@Getter
@Setter
public class UserInformationService {
    @Autowired
    private User user;
    @Autowired
    private LanguageHandler languageHandler;

    public void requestName() {
        Scanner scanner = new Scanner(System.in);
        while (isInputEmpty()) {
            System.out.print(languageHandler.getBundle().getString("enterFirstName"));
            user.setFirstName(scanner.nextLine());
            System.out.print(languageHandler.getBundle().getString("enterLastName"));
            user.setLastName(scanner.nextLine());
            if (isInputEmpty()) {
                System.out.println(languageHandler.getBundle().getString("wrongName"));
            }
        }
    }

    private boolean isInputEmpty() {
        return user.getFirstName() == null || user.getLastName() == null
                || user.getFirstName().isEmpty() || user.getLastName().isEmpty();
    }
}
