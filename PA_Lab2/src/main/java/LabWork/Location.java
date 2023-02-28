package LabWork;

import java.util.Objects;

public class Location {

    public enum locationType{
        CAPITAL,
        CITY,
        COUNTY
    }
    private String locationName;

    private locationType type;
    private int x;
    private int y;

    public Location() {
    }

    public Location(String locationName, locationType type, int x, int y) {
        this.locationName = locationName;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public String getLocationName() {
        return locationName;
    }
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public locationType getType() {
        return type;
    }

    public void setType(locationType type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "LabWork.Location{{{{{{" +
                "locationName='" + locationName + '\'' +
                ", type=" + type +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return x == location.x && y == location.y && locationName.equals(location.locationName) && type == location.type;
    }

}
