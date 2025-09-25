package edu.ccrm.service;

import edu.ccrm.domain.Instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstructorService {
    private final List<Instructor> instructors = new ArrayList<>();

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return new ArrayList<>(instructors);
    }

    public Optional<Instructor> findInstructorById(String id) {
        return instructors.stream().filter(i -> i.getId().equals(id)).findFirst();
    }
}

