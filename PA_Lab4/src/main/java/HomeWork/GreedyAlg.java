package HomeWork;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.*;

public class GreedyAlg {
        public static List<ImmutablePair<Student, Project>> solveGreedy(Problem problem) {
            List<ImmutablePair<Student, Project>> matching = new ArrayList<>();
            List<Student> students = problem.getStudents();

            // Sort students by the number of prefs
            students.sort(Comparator.comparingInt(student -> student.getPrefList().size()));

            for (Student student : students) {
                // Find the first project in the students prefs that hasn't been assigned yet
                Project project = student.getPrefList()
                        .stream()
                        .filter(p -> !matching.stream().anyMatch(pair -> pair.getValue().equals(p)))
                        .findFirst()
                        .orElse(null);

                if (project != null) {
                    // Assign the student to the project
                    matching.add(new ImmutablePair<>(student, project));
                }
            }

            return matching;
        }
    }
