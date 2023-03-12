package HomeWork.Location;

public class City extends Location {
    private final int population;
    private final double surface;

    /**
     * Creates a new city with the given name, type, coordinates, population and surface.
     *
     * @param name       the name of the city
     * @param type       the type of the city
     * @param x          the x coordinate of the city
     * @param y          the y coordinate of the city
     * @param population the population of the city
     * @param surface the surface of the city
     */
    public City(String name, String type, double x, double y, int population, Double surface) {
        super(name, type, x, y);
        this.population = population;
        this.surface = surface;
    }

    /**
     * Gets the population of the city.
     *
     * @return the population of the city
     */

    public Integer getPopulation() {
        return population;
    }

    /**
     * Gets the surface of the city.
     *
     * @return the surface of the city
     */

    public Double getSurface() {
        return surface;
    }
}
