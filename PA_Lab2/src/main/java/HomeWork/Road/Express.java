package HomeWork.Road;

import HomeWork.Location.Location;

public class Express extends Road{

    /**
     * Creates a new express road with the given source and destination locations, length, and speed limit.
     *
     * @param source the source location of the express road
     * @param destination the destination location of the express road
     * @param length the length of the express road
     * @param speedLimit the speed limit of the express road
     */

    public Express(Location source, Location destination, double length, double speedLimit) {
        super(source, destination, "express", length, speedLimit);
    }
}
