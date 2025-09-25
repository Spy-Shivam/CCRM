package edu.ccrm.service;

import edu.ccrm.domain.Student;
import edu.ccrm.config.DataStore;

import java.util.List;
import java.util.Optional;

public class StudentService {

    private final DataStore store;

    public StudentService() {
        this.store = DataStore.getInstance(); // singleton
    }

    public void addStudent(Student student) {
        store.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return store.getStudents();
    }

    public Optional<Student> findStudentById(String regNo) {
        return store.getStudents().stream()
                .filter(s -> s.getRegNo().equals(regNo))
                .findFirst();
    }
}
