package edu.ccrm.io;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;
import edu.ccrm.service.StudentService;
import edu.ccrm.service.CourseService;

import java.io.*;
import java.util.List;

public class ImportExportService {

    public static void exportStudents(StudentService studentService) {
        List<Student> students = studentService.getAllStudents();
        try (PrintWriter writer = new PrintWriter(new File("students.csv"))) {
            for (Student s : students) {
                writer.println(s.getRegNo() + "," + s.getFullName() + "," + s.getEmail());
            }
            System.out.println("✅ Students exported to students.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importStudents(StudentService studentService) {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    studentService.addStudent(new Student(parts[0], parts[1], parts[2]));
                }
            }
            System.out.println("✅ Students imported from students.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportCourses(CourseService courseService) {
        List<Course> courses = courseService.getAllCourses();
        try (PrintWriter writer = new PrintWriter(new File("courses.csv"))) {
            for (Course c : courses) {
                writer.println(c.getCode() + "," + c.getTitle() + "," +
                        c.getCredits() + "," + c.getDepartment() + "," +
                        c.getSemester() + "," + c.getInstructor());
            }
            System.out.println("✅ Courses exported to courses.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importCourses(CourseService courseService) {
        try (BufferedReader reader = new BufferedReader(new FileReader("courses.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    Course course = new Course.Builder()
                            .code(parts[0])
                            .title(parts[1])
                            .credits(Integer.parseInt(parts[2]))
                            .department(parts[3])
                            .semester(Enum.valueOf(edu.ccrm.domain.Semester.class, parts[4]))
                            .instructor(parts[5])
                            .build();
                    courseService.addCourse(course);
                }
            }
            System.out.println("✅ Courses imported from courses.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
