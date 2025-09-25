# Campus Course & Records Manager (CCRM)

**CCRM provides a comprehensive toolkit for managing students, courses, enrollments, and grades through a simple, interactive interface..**

---

## Features

- **Student Management** (Add, update, list, and search students).  
- **Course Management** (Add, update, list, and assign instructors).  
- **Enrollment Management** (Enroll students in courses with duplicate enrollment validation).  
- **Grade Recording and GPA Calculation** (Record grades and compute cumulative GPA for students).  
- **Data Import/Export** (Import and export student and course data from/to CSV files).  
- **Backup & Restore** (Maintain backups of critical data).  
- **Reports & Statistics** (Generate transcripts and enrollment summaries).

---

## Technical Requirements Demonstrated

- **OOPs :** Encapsulation, Inheritance, Abstraction, Polymorphism  
- **Exception Handling:** Custom exceptions (`StudentNotFoundException`, `DuplicateEnrollmentException`) 
- **File I/O:** Reading/writing data
- **Java Stream API:** Efficient data processing and filtering  
- **Date/Time API:** Handling date/time where necessary  
- **Interfaces & Abstract Classes:** For service and domain layers  
- **Nested Classes:** Builder pattern for `Course` creation  
- **Enums:** Semester and Grade enums. 
- **Design Patterns:** Singleton for `DataStore`, Builder for `Course`  
- **Recursion** 

---

## Installation and Setup

### Windows Installation

1. Download JDK from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html)  
2. Run the installer and follow the prompts  
3. Set `JAVA_HOME` environment variable to the JDK installation path  
4. Add `%JAVA_HOME%\bin` to the `PATH` environment variable  


## How to Run

1. Clone the repository  
2. Open the project in IntelliJ IDEA, Eclipse or any Java IDE  
3. Ensure Java 8 or later is configured  
4. Run the `Main.java` class  

---

## Sample Commands

The application provides a **menu-driven interface**. Follow the prompts to:

- Add students and courses  
- Enroll students in courses  
- Record grades  
- Generate transcripts  
- Import/export data   
