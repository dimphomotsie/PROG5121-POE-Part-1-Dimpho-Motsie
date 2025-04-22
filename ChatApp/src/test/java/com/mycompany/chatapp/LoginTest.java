/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the Login class methods.
 * Each test checks whether the feature works correctly with valid and invalid input.
 * 
 * @author lab_services_student
 */

/** This class contains unit tests for the User class methods.
 * Each test checks whether the feature works correctly with valid and invalid input.
 * @author lab_services_student
 */
public class LoginTest {

    private Login user;

    @BeforeEach
    public void setUp() {
        user = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(user.checkUserName(), "Username should be valid");
    }

    // Test invalid username ( too long or missing an underscore)
    @Test
    public void testCheckUserName() {
        assertTrue(user.checkUserName(), "Username should be valid.");
    }

    @Test
    public void testCheckUserName_Invalid() {
        Login u = new Login("Kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(u.checkUserName(), "Username should be invalid due to length or missing underscore.");
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        assertTrue(user.checkPasswordComplexity(), "Password should meet complexity requirements.");
    }

    // Test invalid password (too simple)
    @Test
    public void testCheckPasswordComplexity_Invalid() {
        Login u = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertFalse(u.checkPasswordComplexity(), "Password should be invalid due to lack of complexity.");
    }

    /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellPhoneNumber() {
        assertTrue(user.checkCellPhoneNumber(), "Cell number should be valid.");
    }

    // Test invalid phone number (missing +27, too short)
    @Test
    public void testCheckCellPhoneNumber_Invalid() {
        Login u = new Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertFalse(u.checkCellPhoneNumber(), "Cell number should be invalid due to incorrect format.");
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser_Success() {
        assertEquals("User registered successfully.", user.registerUser());
    }

    // Test registration with invalid username
    @Test
    public void testRegisterUser_InvalidUsername() {
        Login u = new Login("kyle", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", u.registerUser());
    }

     // Test registration with invalid password
    @Test
    public void testRegisterUser_InvalidPassword() {
        Login u = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", u.registerUser());
    }

    // Test registration with invalid phone number
    @Test
    public void testRegisterUser_InvalidPhone() {
        Login u = new Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", u.registerUser());
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    // Test login with incorrect credentials
    @Test
    public void testLoginUser_Failure() {
        assertFalse(user.loginUser("kyle!!!!!!!!", "password"));
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
        assertEquals("Welcome Kyle, Smith it is great to see you again.", user.returnLoginStatus("kyl_1", "Ch&&sec@ke99!"));
    }

    // Test login status message for invalid login
    @Test
    public void testReturnLoginStatus_Failure() {
        assertEquals("Username or password incorrect, please try again.", user.returnLoginStatus("wrong", "123"));
    }
    
}


/** CODE ATTRIBUTION
 * Adnan, Y. 2025
 * This code has been adapted from classwork taught by Yusra Adnan 
 */
