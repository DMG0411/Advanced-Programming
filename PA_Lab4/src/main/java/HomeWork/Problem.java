package HomeWork;

import java.util.*;

public class Problem {
    private List<Student> students;
    private List<Project> projects;

    public Problem(List<Student> students, List<Project> projects) {
        this.students = students;
        this.projects = projects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
