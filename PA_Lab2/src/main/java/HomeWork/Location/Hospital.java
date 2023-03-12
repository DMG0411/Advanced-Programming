package HomeWork.Location;

public class Hospital extends Location{
    private final int numberOfEmployees;
    private final int numberOfPatients;
    private final int stockOfPills;

    /**
     * Creates a new hospital with the given name, type, coordinates, numberOfEmployees, numberOfPatients and stockOfPills.
     *
     * @param name       the name of the hospital
     * @param type       the type of the hospital
     * @param x          the x coordinate of the hospital
     * @param y          the y coordinate of the hospital
     * @param numberOfEmployees the numberOfEmployees of the hospital
     * @param numberOfPatients the numberOfProfs of the hospital
     * @param stockOfPills the stockOfPills of the hospital
     */

    public Hospital(String name, String type, double x, double y,int numberOfEmployees, int numberOfPatients, int stockOfPills) {
        super(name, type, x, y);
        this.numberOfEmployees = numberOfEmployees;
        this.numberOfPatients = numberOfPatients;
        this.stockOfPills = stockOfPills;
    }

    /**
     * Gets the numberOfEmployees of the hospital.
     *
     * @return the numberOfEmployees of the hospital
     */

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * Gets the numberOfPatients of the hospital.
     *
     * @return the numberOfPatients of the hospital
     */

    public Integer getNumberOfPatients() {
        return numberOfPatients;
    }

    /**
     * Gets the stockOfPills of the hospital.
     *
     * @return the stockOfPills of the hospital
     */

    public Integer getStockOfPills() {
        return stockOfPills;
    }

}
