/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import javax.swing.JOptionPane;

/**
 *
 * @author lab_services_student
 */

/** 
 * This is the main class that operates the ChatApp. 
 * It will manage the user registration and login via pop-up dialog boxes. 
 */
public class ChatApp {

    public static void main(String[] args) {
        
        // Prompt the user for their personal details and credentials
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        String username = JOptionPane.showInputDialog("Create a username (must contain underscore and maximum 5 characters):");
        String password = JOptionPane.showInputDialog("Create a password (8+ characters, uppercase, number, special character):");
        String cellNumber = JOptionPane.showInputDialog("Enter your SA number with international code (e.g. +27838968976):");

        
        // Login object with provided details
        Login user = new Login(username, password, cellNumber, firstName, lastName);
        
        // Display of the registration validation result
        String registrationMessage = user.registerUser();
        JOptionPane.showMessageDialog(null, registrationMessage);

        
        // If registration is valid, user will be allowed to log in
        if (user.checkUserName() && user.checkPasswordComplexity() && user.checkCellPhoneNumber()) {
            String loginUsername = JOptionPane.showInputDialog("Login - Enter your username:");
            String loginPassword = JOptionPane.showInputDialog("Login - Enter your password:");

            
            // Verification of login and the display of appropriate login stauts message
            boolean loginResult = user.loginUser(loginUsername, loginPassword);
            String status = user.returnLoginStatus(loginUsername, loginPassword);
            JOptionPane.showMessageDialog(null, status);
        }
    }
       
        
        
    }

/** CODE ATTRIBUTION
 * Adnan, Y. 2025
 * This code has been adapted from classwork taught by Yusra Adnan 
 */

