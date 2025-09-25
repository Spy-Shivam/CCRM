package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Person {
    private final UUID id;        // unique identifier
    private String regNo;         // registration number
    private String fullName;
    private String email;
    private LocalDate createdAt;  // Date/Time API

    public Person(String regNo, String fullName, String email) {
        this.id = UUID.randomUUID();
        this.regNo = regNo;
        this.fullName = fullName;
        this.email = email;
        this.createdAt = LocalDate.now();
    }

    // Abstract method
    public abstract String getRole();

    // Getters & Setters
    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s)", getRole(), fullName, regNo);
    }
}

