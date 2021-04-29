package com.simran.models;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Location
{
    int x;
    int y;

    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getDistance(Location location2)
    {
        double distance=  sqrt( pow(this.getX() - location2.getX(), 2) + pow(this.getY() - location2.getY(), 2) );
        return distance;
    }

}
