import LabWork.Company;
import LabWork.Node;
import LabWork.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Person("Alice"));
        nodes.add(new Company("Apple"));
        nodes.add(new Person("Bob"));
        nodes.add(new Company("Microsoft"));
        nodes.sort(Comparator.comparing(Node::getName));
        nodes.forEach(node -> System.out.println(node.getName()));
    }
}