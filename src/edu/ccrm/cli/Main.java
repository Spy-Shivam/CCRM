package edu.ccrm.cli;

import edu.ccrm.domain.*;
import edu.ccrm.exceptions.DuplicateEnrollmentException;
import edu.ccrm.exceptions.StudentNotFoundException;
import edu.ccrm.io.ImportExportService;
import edu.ccrm.service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Service objects
        StudentService studentService = new StudentService();
        InstructorService instructorService = new InstructorService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Campus Course & Records Manager (CCRM) ===");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Instructors");
            System.out.println("3. Manage Courses");
            System.out.println("4. Enroll Student");
            System.out.println("5. Record Grade");
            System.out.println("6. Print Student Transcript");
            System.out.println("7. Export Students");
            System.out.println("8. Export Courses");
            System.out.println("9. Import Students");
            System.out.println("10. Import Courses");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> manageStudents(studentService, sc);
                case 2 -> manageInstructors(instructorService, sc);
                case 3 -> manageCourses(courseService, sc);
                case 4 -> enrollStudent(enrollmentService, studentService, courseService, sc);
                case 5 -> recordGrade(enrollmentService, sc);
                case 6 -> printTranscript(studentService, enrollmentService, sc);
                case 7 -> ImportExportService.exportStudents(studentService);
                case 8 -> ImportExportService.exportCourses(courseService);
                case 9 -> ImportExportService.importStudents(studentService);
                case 10 -> ImportExportService.importCourses(courseService);
                case 11 -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }

    // ----------------- Student Management -----------------
    private static void manageStudents(StudentService studentService, Scanner sc) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Manage Students ---");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent(studentService, sc);
                case 2 -> listStudents(studentService);
                case 3 -> back = true;
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addStudent(StudentService studentService, Scanner sc) {
        System.out.print("Enter Registration No: ");
        String regNo = sc.nextLine();
        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Student student = new Student(regNo, fullName, email);
        studentService.addStudent(student);
        System.out.println("✅ Student added!");
    }

    private static void listStudents(StudentService studentService) {
        System.out.println("\n--- Students List ---");
        studentService.getAllStudents().forEach(System.out::println);
    }

    // ----------------- Instructor Management -----------------
    private static void manageInstructors(InstructorService instructorService, Scanner sc) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Manage Instructors ---");
            System.out.println("1. Add Instructor");
            System.out.println("2. List Instructors");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addInstructor(instructorService, sc);
                case 2 -> listInstructors(instructorService);
                case 3 -> back = true;
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addInstructor(InstructorService instructorService, Scanner sc) {
        System.out.print("Enter Instructor ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        Instructor instructor = new Instructor(id, fullName, email, dept);
        instructorService.addInstructor(instructor);
        System.out.println("✅ Instructor added!");
    }

    private static void listInstructors(InstructorService instructorService) {
        System.out.println("\n--- Instructors List ---");
        instructorService.getAllInstructors().forEach(System.out::println);
    }

    // ----------------- Course Management -----------------
    private static void manageCourses(CourseService courseService, Scanner sc) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Manage Courses ---");
            System.out.println("1. Add Course");
            System.out.println("2. List Courses");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addCourse(courseService, sc);
                case 2 -> listCourses(courseService);
                case 3 -> back = true;
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addCourse(CourseService courseService, Scanner sc) {
        System.out.print("Enter Course Code: ");
        String code = sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Credits: ");
        int credits = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.println("Select Semester: 1. SPRING 2. SUMMER 3. FALL 4. WINTER");
        int semChoice = sc.nextInt();
        sc.nextLine();
        Semester semester = switch (semChoice) {
            case 1 -> Semester.SPRING;
            case 2 -> Semester.SUMMER;
            case 3 -> Semester.FALL;
            case 4 -> Semester.WINTER;
            default -> Semester.FALL;
        };

        System.out.print("Enter Instructor ID: ");
        String instructorId = sc.nextLine();

        Course course = new Course.Builder()
                .code(code)
                .title(title)
                .credits(credits)
                .department(dept)
                .semester(semester)
                .instructor(instructorId)
                .build();

        courseService.addCourse(course);
        System.out.println("✅ Course added!");
    }

    private static void listCourses(CourseService courseService) {
        System.out.println("\n--- Courses List ---");
        courseService.getAllCourses().forEach(System.out::println);
    }

    // ----------------- Enrollment -----------------
    private static void enrollStudent(EnrollmentService enrollmentService,
                                      StudentService studentService,
                                      CourseService courseService,
                                      Scanner sc) {
        System.out.print("Enter Student RegNo: ");
        String regNo = sc.nextLine();
        System.out.print("Enter Course Code: ");
        String code = sc.nextLine();

        Student student = studentService.findStudentById(regNo).orElse(null);
        Course course = courseService.findCourseByCode(code).orElse(null);

        if(student == null || course == null) {
            System.out.println("Student or Course not found!");
            return;
        }

        Enrollment e = new Enrollment(student, course);
        try {
            enrollmentService.addEnrollment(e);
        } catch (DuplicateEnrollmentException ex) {
            throw new RuntimeException(ex);
        } catch (StudentNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("✅ Enrollment successful!");
    }

    private static void recordGrade(EnrollmentService enrollmentService, Scanner sc) {
        System.out.print("Enter Student RegNo: ");
        String regNo = sc.nextLine();
        System.out.print("Enter Course Code: ");
        String code = sc.nextLine();

        Enrollment enrollment = enrollmentService.getAllEnrollments().stream()
                .filter(e -> e.getStudent().getRegNo().equals(regNo) &&
                        e.getCourse().getCode().equals(code))
                .findFirst().orElse(null);

        if(enrollment == null) {
            System.out.println("Enrollment not found!");
            return;
        }

        System.out.print("Enter Grade (S, A, B, C, D, E, F): ");
        String gradeStr = sc.nextLine().toUpperCase();

        try {
            Grade grade = Grade.valueOf(gradeStr);
            enrollmentService.recordGrade(enrollment, gradeStr);
            System.out.println("✅ Grade recorded!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid grade entered!");
        }
    }

    private static void printTranscript(StudentService studentService,
                                        EnrollmentService enrollmentService,
                                        Scanner sc) {
        System.out.print("Enter Student RegNo: ");
        String regNo = sc.nextLine().trim();

        Student student = studentService.findStudentById(regNo).orElse(null);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\n===== Transcript for " + student.getFullName() + " =====");
        enrollmentService.getAllEnrollments().stream()
                .filter(e -> e.getStudent().equals(student))
                .forEach(e -> {
                    String gradeLine = (e.getGrade() == null ? "Not graded" : e.getGrade().name());
                    System.out.println(e.getCourse().getCode() + " - " +
                            e.getCourse().getTitle() +
                            " (" + e.getCourse().getCredits() + " cr) → " +
                            gradeLine);
                });

        double gpa = enrollmentService.computeGPA(student);
        System.out.printf("Cumulative GPA: %.2f\n", gpa);
    }
}
