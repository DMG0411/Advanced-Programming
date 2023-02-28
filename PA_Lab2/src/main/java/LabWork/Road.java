package LabWork;

import static java.lang.Math.sqrt;

public class Road {

    public enum RoadType{
        UNSIGNED,
        NATIONAL,
        EXPRESS,
        HIGHWAY
    }
    private RoadType type;
    private double length;
    private int speedLimit;

    public Road(RoadType type, double length, int speedLimit) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    public Road() {
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int x1, int y1, int x2,int y2) {
        // getting euclidean distance between first and second location
        // if distance is > 0 then it means that it's a valid distance
        // and we assign it to the road length
        double distance = sqrt((x2 - x1)^2 + (y2 - y1)^2);
        if(distance > 0){
            this.length = distance;
        }
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    @Override
    public String toString() {
        return "LabWork.Road{" +
                "type='" + type + '\'' +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
