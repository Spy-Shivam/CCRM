package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.config.DataStore;

import java.util.List;
import java.util.Optional;

public class CourseService {

    private final DataStore store;

    public CourseService() {
        this.store = DataStore.getInstance();
    }

    public void addCourse(Course course) {
        store.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return store.getCourses();
    }

    public Optional<Course> findCourseByCode(String code) {
        return store.getCourses().stream()
                .filter(c -> c.getCode().equals(code))
                .findFirst();
    }
}
