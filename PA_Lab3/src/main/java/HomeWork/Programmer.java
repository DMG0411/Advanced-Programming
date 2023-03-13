package HomeWork;

import java.util.Date;
import java.util.Map;

public class Programmer extends Person{

    private int yearsOfExperience; //specific property of class

    public Programmer(String name, Date birthDate, boolean married, int yearsOfExperience) {
        super(name, birthDate, married);
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
