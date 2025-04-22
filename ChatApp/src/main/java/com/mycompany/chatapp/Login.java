package com.mycompany.chatapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */


/**
 * This class outlines the Login object and includes methods to verify user information
 as well as handle login and registration.
 */
public class Login {
    
    // Login attributes
    String username;
    String password;
    String cellNumber;
    String firstName;
    String lastName;

    
    
    public Login(String username, String password, String cellNumber, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // This method ensures that any username contains an underscore (_) and is no more than 5 characters long.
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    // This method ensures that passwords is complex enough (minimum 8 characters, contains a uppercase, a digit and a special character.
    public boolean checkPasswordComplexity() {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

    // This method ensures that cell phone is correct length and contains the international country code.
    // Regex was adatped from ChatGPT assistance
    public boolean checkCellPhoneNumber() {
        return cellNumber.matches("^\\+27\\d{9}$");
    }

    // This method will register the user and returns a message depending on whether their input is valid or not 
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        } else if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        } else if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        } else {
            return "User registered successfully.";
        }
    }

    // This method verifies that the login details entered match the login details stored when the user registers.
    public boolean loginUser(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    // Returns a message depending on whether the login was successful or not. 
    public String returnLoginStatus(String inputUsername, String inputPassword) {
        if (loginUser(inputUsername, inputPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
        
    }
}

/** CODE ATTRIBUTION
 * Adnan, Y. 2025
 * This code has been adapted from classwork taught by Yusra Adnan 
 */

/** OpenAI. (2024). ChatGPT (May 13 version) [Large language model].
 * https://chatgpt.com/c/6807aba2-4ec8-8004-8548-d57eded91c1c
 */
