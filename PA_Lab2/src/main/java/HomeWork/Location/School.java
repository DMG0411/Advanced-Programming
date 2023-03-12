package HomeWork.Location;

public class School extends Location{
    private final int numberOfStudents;
    private final int numberOfProfs;
    private final int numberOfClassrooms;

    /**
     * Creates a new school with the given name, type, coordinates, numberOfStudents, numberOfProfs and numberOfClassrooms.
     *
     * @param name       the name of the school
     * @param type       the type of the school
     * @param x          the x coordinate of the school
     * @param y          the y coordinate of the school
     * @param numberOfStudents the numberOfStudents of the school
     * @param numberOfProfs the numberOfProfs of the school
     * @param numberOfClassrooms the numberOfClassrooms of the school
     */

    public School(String name, String type, double x, double y,int numberOfStudents, int numberOfProfs, int numberOfClassrooms) {
        super(name, type, x, y);
        this.numberOfStudents = numberOfStudents;
        this.numberOfProfs = numberOfProfs;
        this.numberOfClassrooms = numberOfClassrooms;
    }

    /**
     * Gets the numberOfStudents of the school.
     *
     * @return the numberOfStudents of the school
     */

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * Gets the numberOfProfs of the school.
     *
     * @return the numberOfProfs of the school
     */

    public Integer getNumberOfProfs() {
        return numberOfProfs;
    }


    /**
     * Gets the numberOfClassrooms of the school.
     *
     * @return the numberOfClassrooms of the school
     */

    public Integer getNumberOfClassrooms() {
        return numberOfClassrooms;
    }

}
