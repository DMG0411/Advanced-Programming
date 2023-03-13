package HomeWork;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Person {
    private String name;
    private Date birthDate;

    private Map<Person, String> relationships; // relationships with other persons
    private Map<Company, String> jobRelationships; // relationships with company

    private boolean married; // specific property of class

    public Person() {
    }

    public Person(String name, Date birthDate, boolean married) {
        this.name = name;
        this.birthDate = birthDate;
        this.relationships = new HashMap<>();
        this.jobRelationships = new HashMap<>();
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void addRelationship(Person person, String type) {
        relationships.put(person, type);
    }

    public Map<Person, String> getRelationships() {
        return relationships;
    }

    public void addJobRelationship(Company company, String type) {
        jobRelationships.put(company, type);
    }

    public Map<Company, String> getJobRelationships() {
        return jobRelationships;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getImportance(){
        return relationships.size() + jobRelationships.size();
    }
}
