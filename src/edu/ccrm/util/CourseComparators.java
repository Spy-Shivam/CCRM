package edu.ccrm.util;

import edu.ccrm.domain.Course;
import java.util.Comparator;

public class CourseComparators {

    // Sort courses by title alphabetically
    public static final Comparator<Course> byTitle = Comparator.comparing(Course::getTitle);

    // Sort courses by credits ascending
    public static final Comparator<Course> byCredits = Comparator.comparingInt(Course::getCredits);

    // Sort courses by department
    public static final Comparator<Course> byDepartment = Comparator.comparing(Course::getDepartment);
}
