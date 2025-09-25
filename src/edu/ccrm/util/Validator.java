package edu.ccrm.util;

public class Validator {

    // Check if a string is not null or empty
    public static boolean isNonEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Check if an email is valid
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }

    // Check if a grade string is valid
    public static boolean isValidGrade(String gradeStr) {
        return gradeStr != null && gradeStr.matches("[SABCDEF]");
    }
}
