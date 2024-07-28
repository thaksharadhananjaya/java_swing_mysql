package student.management.Models;

/**
 *
 * @author thakshara
 */
public class Student {
    private int id;
    private final String name;
    private final int age;
    private final String faculty;
    private final String department;

    // Constructors
    public Student(int id, String name, int age, String faculty, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.faculty = faculty;
        this.department = department;
    }
    public Student(String name, int age, String faculty, String department) {
        this.name = name;
        this.age = age;
        this.faculty = faculty;
        this.department = department;
    }

    // Getters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDepartment() {
        return department;
    }
}

