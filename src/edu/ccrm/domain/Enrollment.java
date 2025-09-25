package edu.ccrm.domain;

import java.time.LocalDate;

public class Enrollment {
    private final Student student;
    private final Course course;
    private LocalDate enrollmentDate;
    private Grade grade; // can be null initially

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDate.now();
        this.grade = null; // not graded yet
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public Grade getGrade() { return grade; }

    public void setGrade(Grade grade) { this.grade = grade; }
    public boolean isGraded() { return grade != null; }


    @Override
    public String toString() {
        return student.getFullName() + " -> " + course.getCode() +
                " [" + enrollmentDate + "] Grade: " + (grade != null ? grade : "Not graded");
    }
}

