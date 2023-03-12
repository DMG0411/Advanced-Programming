package HomeWork.Location;

public class Airport extends Location {
    private final int numberOfHangars;
    private final int numberOfPlanes;
    private final int numberOfLandingStrips;

    /**
     * Creates a new airport with the given name, type, coordinates, numberOfHangars, numberOfPlanes and numberOfLandingStrips.
     *
     * @param name       the name of the airport
     * @param type       the type of the airport
     * @param x          the x coordinate of the airport
     * @param y          the y coordinate of the airport
     * @param numberOfHangars the numbers of the hangars of the airport
     * @param numberOfPlanes the numbers of the planes of the airport
     * @param numberOfLandingStrips the numbers of the landing strips of the airport
     */

    public Airport(String name, String type, double x, double y, int numberOfHangars, int numberOfPlanes, int numberOfLandingStrips) {
        super(name, type, x, y);
        this.numberOfHangars = numberOfHangars;
        this.numberOfPlanes = numberOfPlanes;
        this.numberOfLandingStrips = numberOfLandingStrips;
    }

    /**
     * Gets the numberOfHangars of the airport.
     *
     * @return the numberOfHangars of the airport
     */

    public Integer getNumberOfHangars() {
        return numberOfHangars;
    }

    /**
     * Gets the numberOfPlanes of the airport.
     *
     * @return the numberOfPlanes of the airport
     */

    public Integer getNumberOfPlanes() {
        return numberOfPlanes;
    }

    /**
     * Gets the numberOfLandingStrips of the airport.
     *
     * @return the numberOfLandingStrips of the airport
     */

    public Integer getNumberOfLandingStrips() {
        return numberOfLandingStrips;
    }

}
