package edu.ccrm.domain;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person {
    private String department;
    private final List<String> assignedCourses;

    public Instructor(String regNo, String fullName, String email, String department) {
        super(regNo, fullName, email); // regNo comes from Person
        this.department = department;
        this.assignedCourses = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Instructor";
    }

    // Department getter/setter
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    // Assigned courses
    public List<String> getAssignedCourses() { return assignedCourses; }
    public void assignCourse(String courseCode) { assignedCourses.add(courseCode); }
    public void unassignCourse(String courseCode) { assignedCourses.remove(courseCode); }

    // ✅ Add this getter so Main.java and services can call getId()
    public String getId() {
        return getRegNo(); // regNo is inherited from Person
    }
}
