package HomeWork.Road;

import HomeWork.Location.Location;

public class Highway extends Road{

    /**
     * Creates a new highway with the given source and destination locations, length, and speed limit.
     *
     * @param source the source location of the highway
     * @param destination the destination location of the highway
     * @param length the length of the highway
     * @param speedLimit the speed limit of the highway
     */
    public Highway(Location source, Location destination, double length, double speedLimit) {
        super(source, destination, "highway", length, speedLimit);
    }
}
