package HomeWork.Road;

import HomeWork.Location.Location;

public class Country extends Road {

    /**
     * Creates a new country road with the given source and destination locations, length, and speed limit.
     *
     * @param source the source location of the express road
     * @param destination the destination location of the express road
     * @param length the length of the express road
     * @param speedLimit the speed limit of the express road
     */


    public Country(Location source, Location destination, double length, double speedLimit) {
        super(source, destination, "country", length, speedLimit);
    }

}
