package LabWork;

public class LabWork {
    public static void main(String[] args) {
        Location firstLocation = new Location("Iasi", Location.locationType.CITY, 0, 0);
        Location firstLocation1 = new Location("Iasi", Location.locationType.CITY, 0, 0);

        Location secondLocation = new Location();

        secondLocation.setLocationName("TGNeamt");
        secondLocation.setType(Location.locationType.CITY);
        secondLocation.setX(15);
        secondLocation.setY(7);

        Location thirdLocation = new Location("Tomesti", Location.locationType.COUNTY, 3, 2);

        System.out.println(thirdLocation.getLocationName());

        Location fourthLocation = new Location("Bucuresti", Location.locationType.CAPITAL, 100, 56);

        System.out.println(secondLocation);

        if (!firstLocation.toString().equals(firstLocation1.toString())) {
            System.out.println("Orase diferite!");
        }
        else{
            System.out.println("Orase similare");
        }

        Road firstRoad = new Road();
        firstRoad.setType(Road.RoadType.HIGHWAY);
        firstRoad.setLength(firstLocation.getX(), firstLocation.getY(), fourthLocation.getX(), fourthLocation.getY());
        firstRoad.setSpeedLimit(130);

        Road secondRoad = new Road(Road.RoadType.UNSIGNED,2.3,50);

        System.out.println(secondRoad);

        secondRoad.setLength(56);

        System.out.println("FirstRoad:\n"+firstRoad.getType() + "\n" + firstRoad.getLength() + "km\n" + firstRoad.getSpeedLimit() + "km/h\n");
    }
}
