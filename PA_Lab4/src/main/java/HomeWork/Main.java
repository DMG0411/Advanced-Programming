package HomeWork;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Generate fake datas
        List<Student> students = generateStudents(15);
        List<Project> projects = generateProjects(7);

        // New problem instance
        Problem problemInstance = new Problem(students,projects);

        List<ImmutablePair<Student,Project>> greedyMatching = GreedyAlg.solveGreedy(problemInstance);
        System.out.println("Greedy Algorithm");
        System.out.println("________________ \n");
        System.out.println(greedyMatching);

        // Average number of prefs
        double averagePrefs = problemInstance.getStudents()
                .stream().mapToInt(student -> student.getPrefList().size())
                .average().orElse(0);

        System.out.println("\n");
        System.out.println("Students with fewer prefs then average");
        System.out.println("______________________________________ \n");
        // Print the students with fewer prefs than average
        problemInstance.getStudents()
                .stream().filter(student -> student.getPrefList().size() < averagePrefs)
                .forEach(student -> System.out.println(student.getName() + " | "+student.getPrefList()));
    }

    private static List<Student> generateStudents(int numberOfStudents){
        List<Student> students = new ArrayList<>();
        Faker faker = new Faker(new Locale("ru"));
        for(int i = 0; i < numberOfStudents; i++){
            List<Project> prefList = new ArrayList<>();
            int numberOfPrefs = faker.number().numberBetween(1,8);
            for(int j = 0; j < numberOfPrefs; j++){
                prefList.add(new Project(faker.book().title()));
            }
            students.add(new Student(faker.name().fullName(),prefList));
        }
        return students;
    }

    private static List<Project> generateProjects(int numberOfProjects){
        List<Project> projects = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i < numberOfProjects; i++){
            projects.add(new Project(faker.book().title()));
        }
        return projects;
    }
}
