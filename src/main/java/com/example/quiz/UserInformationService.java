package com.example.quiz;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class UserInformationService {
    private User user;

    public void requestName() {
        Scanner scanner = new Scanner(System.in);
        boolean isFilled = false;
        while (!isFilled) {
            System.out.print("Enter your first name: ");
            user.setFirstName(scanner.nextLine());
            System.out.print("Enter your last name: ");
            user.setLastName(scanner.nextLine());
            if (isInputNotEmpty()) {
                isFilled = true;
            } else {
                System.out.println("First name and last name cannot be empty!");
            }
        }
    }

    private boolean isInputNotEmpty() {
        return !user.getFirstName().isEmpty() && !user.getLastName().isEmpty();
    }
}
