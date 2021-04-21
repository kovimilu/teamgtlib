package com.teamgtlib.pathfinding;
/**
 * A 2D point on the grid
 */
public class Point_ {

    public int x;
    public int y;

    public Point_() {
        this(0, 0);
    }

    public Point_(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point_(Point_ point) {
        x = point.x;
        y = point.y;
    }

    @Override
    public boolean equals(Object object) {
        // Unlikely to compare incorrect type so removed for performance
        // if (!(obj.GetType() == typeof(PathFind.Point)))
        //     return false;
        Point_ point = (Point_) object;

        if (point.equals(null)) return false;

        // Return true if the fields match:
        return (x == point.x) && (y == point.y);
    }

    public boolean equals(Point_ point) {
        if (point.equals(null)) return false;

        // Return true if the fields match:
        return (x == point.x) && (y == point.y);
    }

    public Point_ set(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Point = {" + x +", " + y +'}';
    }
}
