package edu.ccrm.domain;

import edu.ccrm.domain.Semester;


public final class Course {
    private final String code;
    private final String title;
    private final int credits;
    private final String department;
    private final Semester semester;
    private String instructorRegNo; // can change

    private Course(Builder builder) {
        this.code = builder.code;
        this.title = builder.title;
        this.credits = builder.credits;
        this.department = builder.department;
        this.semester = builder.semester;
        this.instructorRegNo = builder.instructorRegNo;
    }

    // add these methods inside Course.java (after fields / before constructor or after constructors)
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public String getDepartment() {
        return department;
    }

    public Semester getSemester() {
        return semester;
    }

    public String getInstructor() {
        return instructorRegNo;
    }


    public static class Builder {
        private String code;
        private String title;
        private int credits;
        private String department;
        private Semester semester;
        private String instructorRegNo;

        public Builder code(String code){ this.code=code; return this; }
        public Builder title(String title){ this.title=title; return this; }
        public Builder credits(int credits){ this.credits=credits; return this; }
        public Builder department(String dept){ this.department=dept; return this; }
        public Builder semester(Semester sem){ this.semester=sem; return this; }
        public Builder instructor(String regNo){ this.instructorRegNo=regNo; return this; }

        public Course build() {
            if(code==null || title==null) throw new IllegalStateException("Code and title required");
            return new Course(this);
        }
    }

    @Override
    public String toString() {
        return code + " - " + title + " (" + credits + " cr) ["+ semester + "]";
    }
}
