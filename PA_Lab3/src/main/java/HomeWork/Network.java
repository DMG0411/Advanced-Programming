package HomeWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Network {
    private List<Object> nodes;

    public Network() {
        nodes = new ArrayList<>();
    }

    public void addNode(Object node){
        nodes.add(node);
    }

    public void printNetwork(){
        Collections.sort(nodes, new Comparator<>() {
            public int compare(Object firstObj, Object secondObj) {
                if (firstObj instanceof Person && secondObj instanceof Person) {
                    return ((Person) secondObj).getImportance() - ((Person) firstObj).getImportance();
                } else if (firstObj instanceof Company && secondObj instanceof Company) {
                    return ((Company) secondObj).getImportance() - ((Company) firstObj).getImportance();
                } else {
                    return -1; // different types of nodes
                }
            }
        });

        for(Object node: nodes){
            if(node instanceof Person){
                Person person = (Person) node;
                System.out.println("Person named: "+person.getName() + " has importance number of:"+person.getImportance());
            }
            else if(node instanceof Company){
                Company company = (Company) node;
                System.out.println("Company named: "+company.getName() + " has importance number of:"+company.getImportance());
            }
        }

    }
}
