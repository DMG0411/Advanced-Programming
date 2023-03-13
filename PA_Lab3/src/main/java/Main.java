import HomeWork.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // create some persons
        Person gigel = new Person("Gigel", new Date(2000, 1, 1), true);
        Person becali = new Person("Becali", new Date(2001, 2, 2), false);
        Programmer chirica = new Programmer("Chirica", new Date(2002, 3, 3),true,5);
        Designer diana = new Designer("Diana", new Date(2003, 4, 4), true, new String[]{"Photoshop", "AfterEffects", "xD"});

        // create some companies
        Company apple = new Company("Apple", 1000);
        Company google = new Company("Google", 250);


        // add relationships
        gigel.addRelationship(becali, "friend");
        becali.addRelationship(gigel, "friend");
        gigel.addJobRelationship(apple, "engineer");
        chirica.addJobRelationship(apple, "programmer");
        diana.addJobRelationship(google, "designer");
        apple.addEmployee(gigel, "engineer");
        apple.addEmployee(chirica, "programmer");
        google.addEmployee(diana, "designer");

        // create a network object
        Network network = new Network();
        network.addNode(gigel);
        network.addNode(becali);
        network.addNode(chirica);
        network.addNode(diana);
        network.addNode(apple);
        network.addNode(google);

        // print the network on the screen
        network.printNetwork();
    }

}