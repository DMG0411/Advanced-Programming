package LabWork;

public class Company implements Node, Comparable<Company> {

    private String name;

    public Company(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Company company) {
        return this.name.compareTo(company.name);
    }
}
