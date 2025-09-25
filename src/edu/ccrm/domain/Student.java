package edu.ccrm.domain;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private boolean active;
    private final List<String> enrolledCourses; // will link to Course later

    public Student(String regNo, String fullName, String email) {
        super(regNo, fullName, email);
        this.active = true;
        this.enrolledCourses = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public boolean isActive() { return active; }
    public void deactivate() { this.active = false; }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enroll(String courseCode) {
        enrolledCourses.add(courseCode);
    }

    public void unenroll(String courseCode) {
        enrolledCourses.remove(courseCode);
    }
}
