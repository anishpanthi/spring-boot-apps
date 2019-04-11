package com.app.boot.jpa.util;

import java.util.Random;

/**
 * @author Anish
 */

public class PasswordGenerator {

    public static char[] generatePassword() {
        System.out.println("Generating password using random() : ");
        System.out.print("Your new password is : ");

        String upperCaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String values = upperCaseCharacters + lowerCaseCharacters + numbers + symbols;

        Random random = new Random();

        char[] password = new char[12];

        for (int i = 0; i < 12; i++) {
            password[i] = values.charAt(random.nextInt(values.length()));
        }
        return password;
    }
}
