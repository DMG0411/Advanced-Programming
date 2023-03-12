package HomeWork.Location;

public class GasStation extends Location{
    enum typeOfGas{
        GASOLINE,
        DIESEL,
        ETHANOL,
        ELECTRIC
    };
    private final typeOfGas typeOfGas;
    private final String pricePerLiter;

    /**
     * Creates a new gasStation with the given name, type, coordinates, typeOfGas and pricePerLiter.
     *
     * @param name       the name of the gasStation
     * @param type       the type of the gasStation
     * @param x          the x coordinate of the gasStation
     * @param y          the y coordinate of the gasStation
     * @param typeOfGas the numberOfStudents of the gasStation
     * @param pricePerLiter the numberOfProfs of the gasStation
     */


    public GasStation(String name, String type, double x, double y,GasStation.typeOfGas typeOfGas, String pricePerLiter) {
        super(name, type, x, y);
        this.typeOfGas = typeOfGas;
        this.pricePerLiter = pricePerLiter;
    }

    /**
     * Gets the typeOfGas of the gasStation.
     *
     * @return the typeOfGas of the gasStation
     */

    public GasStation.typeOfGas getTypeOfGas() {
        return typeOfGas;
    }

    /**
     * Gets the pricePerLiter of the gasStation.
     *
     * @return the pricePerLiter of the gasStation
     */

    public String getPricePerLiter() {
        return pricePerLiter;
    }
}
