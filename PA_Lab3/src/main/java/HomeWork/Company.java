package HomeWork;

import java.util.HashMap;
import java.util.Map;

public class Company {

    private String name;
    private Map<Person, String> employees; // relationships with employees
    private int numberOfEmployees; //specific property of class

    public Company(String name, int numberOfEmployees) {
        this.name = name;
        this.employees = new HashMap<>();
        this.numberOfEmployees = numberOfEmployees;
    }

    public void addEmployee(Person employee, String type){
        employees.put(employee, type);
        employee.addJobRelationship(this, type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Map<Person, String> getEmployees() {
        return employees;
    }

    public int getImportance(){
        return employees.size();
    }
}
