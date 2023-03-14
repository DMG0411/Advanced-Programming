package LabWork;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        LinkedList<Student> listOfStudents = new LinkedList<>(Arrays.asList(students));

        var projects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new);
        TreeSet<Project> listOfProjects = new TreeSet<>(Arrays.asList(projects));

        List<Student> sortedStudents = listOfStudents.stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
        List<Project> sortedProjects = listOfProjects.stream()
                .sorted(Comparator.comparing(Project::getName))
                .toList();

        System.out.println("List of students: "+sortedStudents);
        System.out.println("List of projects: "+sortedProjects);
    }

}