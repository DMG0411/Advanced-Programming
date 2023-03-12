package HomeWork.Road;

import HomeWork.Location.Location;

import java.util.Objects;

public class Road {

    private final Location source;
    private final Location destination;
    private final String type;
    private final double length;
    private final double speedLimit;

    /**
     * Creates a new road with the given source and destination locations, type, length, and speed limit.
     *
     * @param source the source location of the road
     * @param destination the destination location of the road
     * @param type the type of the road
     * @param length the length of the road
     * @param speedLimit the speed limit of the road
     */
    public Road(Location source, Location destination, String type, double length, double speedLimit) {
        this.source = source;
        this.destination = destination;
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    /**
     * Gets the source location of the road.
     *
     * @return the source location of the road
     */
    public Location getSource() {
        return source;
    }

    /**
     * Gets the destination location of the road.
     *
     * @return the destination location of the road
     */
    public Location getDestination() {
        return destination;
    }

    /**
     * Gets the type of the road.
     *
     * @return the type of the road
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the length of the road.
     *
     * @return the length of the road
     */
    public double getLength() {
        return length;
    }

    /**
     * Gets the speed limit of the road.
     *
     * @return the speed limit of the road
     */
    public double getSpeedLimit() {
        return speedLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Double.compare(road.length, length) == 0 &&
                Double.compare(road.speedLimit, speedLimit) == 0 &&
                Objects.equals(source, road.source) &&
                Objects.equals(destination, road.destination) &&
                Objects.equals(type, road.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, type, length, speedLimit);
    }
}