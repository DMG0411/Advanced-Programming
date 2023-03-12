package HomeWork.Location;

import HomeWork.Road.Road;

import java.util.*;

public class Location {

    private final String name;
    private final String type;
    private final double x;
    private final double y;

    private final Map<Location, List<Road>> connectedRoads;

    /**
     * Creates a new location with the given name, type, and coordinates.
     *
     * @param name the name of the location
     * @param type the type of the location
     * @param x    the x coordinate of the location
     * @param y    the y coordinate of the location
     */
    public Location(String name, String type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
        this.connectedRoads = new HashMap<>();
    }

    /**
     * Gets the name of the location.
     *
     * @return the name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type of the location.
     *
     * @return the type of the location
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the x coordinate of the location.
     *
     * @return the x coordinate of the location
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y coordinate of the location.
     *
     * @return the y coordinate of the location
     */
    public double getY() {
        return y;
    }

    /**
     * Adds a road to the list of roads connected to this location.
     *
     * @param road the road to add
     * @param destination the destination location of the road
     */
    public void addConnectedRoad(Road road, Location destination) {
        List<Road> roads = connectedRoads.getOrDefault(destination, new ArrayList<>());
        roads.add(road);
        connectedRoads.put(destination, roads);
    }

    /**
     * Returns a list of the roads connected to this location.
     *
     * @return a list of the roads connected to this location
     */
    public Map<Location, List<Road>> getRoads() {
        return connectedRoads;
    }


    /**

     Calculates the Euclidean distance between this location and another location.
     @param other the other location to calculate the distance to
     @return the Euclidean distance between this location and the other location
     */
    public double distanceTo(Location other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**

     Checks if this location is equal to another location.
     @param o the other location to check for equality
     @return true if this location is equal to the other location, false otherwise
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.x, x) == 0 &&
                Double.compare(location.y, y) == 0 &&
                Objects.equals(name, location.name) &&
                Objects.equals(type, location.type);
    }

    /**

     Generates a hash code for this location.
     @return a hash code for this location
     */

    @Override
    public int hashCode() {
        return Objects.hash(name, type, x, y);
    }
}