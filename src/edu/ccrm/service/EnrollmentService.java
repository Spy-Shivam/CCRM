package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Grade;
import edu.ccrm.exceptions.DuplicateEnrollmentException;
import edu.ccrm.exceptions.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    private final List<Enrollment> enrollments;

    public EnrollmentService() {
        this.enrollments = new ArrayList<>();
    }

    // Add enrollment with exception handling
    public void addEnrollment(Enrollment enrollment)
            throws DuplicateEnrollmentException, StudentNotFoundException {

        if (enrollment.getStudent() == null) {
            throw new StudentNotFoundException("Student does not exist!");
        }

        boolean alreadyEnrolled = enrollments.stream()
                .anyMatch(e -> e.getStudent().equals(enrollment.getStudent()) &&
                        e.getCourse().equals(enrollment.getCourse()));

        if (alreadyEnrolled) {
            throw new DuplicateEnrollmentException(
                    "Student " + enrollment.getStudent().getRegNo() +
                            " is already enrolled in " + enrollment.getCourse().getCode()
            );
        }

        enrollments.add(enrollment);
    }

    // Record grade for an enrollment
    public void recordGrade(Enrollment enrollment, String gradeStr) {
        Grade grade = Grade.valueOf(gradeStr.toUpperCase());
        enrollment.setGrade(grade);
    }

    // Compute GPA of a student
    public double computeGPA(Student student) {
        List<Enrollment> gradedEnrollments = enrollments.stream()
                .filter(e -> e.getStudent().equals(student) && e.getGrade() != null)
                .toList();

        int totalCredits = gradedEnrollments.stream()
                .mapToInt(e -> e.getCourse().getCredits())
                .sum();

        int weightedPoints = gradedEnrollments.stream()
                .mapToInt(e -> e.getCourse().getCredits() * e.getGrade().getPoints())
                .sum();

        return totalCredits == 0 ? 0.0 : (double) weightedPoints / totalCredits;
    }

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return enrollments;
    }
}
