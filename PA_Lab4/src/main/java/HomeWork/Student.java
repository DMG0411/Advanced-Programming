package HomeWork;

import java.util.List;

public class Student {

    private String name;
    private List<Project> prefList;

    public Student(String name, List<Project> prefList) {
        this.name = name;
        this.prefList = prefList;
    }

    public String getName() {
        return name;
    }

    public List<Project> getPrefList() {
        return prefList;
    }

    @Override
    public String toString() {
        return "Student:" +
                "name='" + name+
                " has projects:"+prefList + "\n";
    }
}
