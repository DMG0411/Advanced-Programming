package HomeWork;

import HomeWork.Location.Location;
import HomeWork.Road.Road;

import java.util.*;

/**
 * Represents an instance of the Best Route Problem, consisting of locations and roads.
 */
public class BestRouteProblem {

    private final List<Location> locations;
    private final List<Road> roads;

    /**
     * Creates a new instance of the Best Route Problem, with the given locations and roads.
     *
     * @param locations the list of locations
     * @param roads the list of roads
     */
    public BestRouteProblem(List<Location> locations, List<Road> roads) {
        this.locations = locations;
        this.roads = roads;
    }

    /**
     * Adds a location to the problem's instance, if it doesn't already exist.
     *
     * @param location the location to add
     * @return true if the location was added, false otherwise
     */
    public boolean addLocation(Location location) {
        if (!locations.contains(location)) {
            locations.add(location);
            return true;
        }
        return false;
    }

    /**
     * Adds a road to the problem's instance, if it doesn't already exist.
     *
     * @param road the road to add
     * @return true if the road was added, false otherwise
     */
    public boolean addRoad(Road road) {
        if (!roads.contains(road)) {
            roads.add(road);
            return true;
        }
        return false;
    }

    /**
     * Determines if the problem's instance is valid.
     *
     * @return true if the instance is valid, false otherwise
     */
    /**
     * Checks if this instance of the problem is valid.
     *
     * @return true if the instance is valid, false otherwise
     */
    public boolean isValidInstance() {
        // Check that each road has a non-negative length
        for (Road road : roads) {
            if (road.getLength() < 0) {
                return false;
            }
        }

        // Check that each road connects two existing locations
        for (Road road : roads) {
            if (!locations.contains(road.getSource()) || !locations.contains(road.getDestination())) {
                return false;
            }
        }

        // Check that each location has at least one road connected to it
        for (Location location : locations) {
            if (!location.getRoads().isEmpty()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Determines if it is possible to go from the source location to the destination location,
     * using the given roads.
     *
     * @param source the source location
     * @param destination the destination location
     * @return true if there is a path between the source and destination locations, false otherwise
     */
    public boolean isReachable(Location source, Location destination) {
        Map<Location, Boolean> visited = new HashMap<>();
        for (Location location : locations) {
            visited.put(location, false);
        }

        return isReachableHelper(source, destination, visited);
    }

    /**
     * Helper method for the isReachable method, which does a depth-first search to
     * determine if there is a path between the source and destination.
     *
     * @param current the current location in the search
     * @param destination the destination location
     * @param visited a map indicating if each location has been visited or not
     * @return true if there is a path between the current location and the destination location,
     * false otherwise
     */
    private boolean isReachableHelper(Location current, Location destination, Map<Location, Boolean> visited) {
        visited.put(current, true);

        if (current.equals(destination)) {
            return true;
        }

        for (Road road : current.getRoads().getOrDefault(destination, new ArrayList<>())) {
            Location next = road.getDestination();
            if (!visited.get(next)) {
                if (isReachableHelper(next, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }


}