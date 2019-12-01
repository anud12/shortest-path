package ro.anud.shortestpath;

import java.util.Objects;

public class Point {
    private Integer x;
    private Integer y;

    public Point(final Integer x, final Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Point setX(final Integer x) {
        this.x = x;
        return this;
    }

    public Integer getY() {
        return y;
    }

    public Point setY(final Integer y) {
        this.y = y;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        final Point point = (Point) o;
        return Objects.equals(getX(), point.getX()) &&
                Objects.equals(getY(), point.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public Point clone() {
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}