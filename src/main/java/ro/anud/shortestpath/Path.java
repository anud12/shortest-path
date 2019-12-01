package ro.anud.shortestpath;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Path {
    private Long totalCost;
    private Optional<Point> lastPoint;
    private List<Point> pointList;

    public Path(final Long totalCost, final List<Point> pointList) {
        this.totalCost = totalCost;
        if (pointList.isEmpty()) {
            this.lastPoint = Optional.empty();
        } else {
            this.lastPoint = Optional.ofNullable(pointList.get(pointList.size() - 1));
        }
        this.pointList = pointList;
    }

    public Long getTotalCost() {
        return totalCost;
    }

    public Path setTotalCost(final Long totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public Optional<Point> getLastPoint() {
        return lastPoint;
    }

    public Path setLastPoint(final Point lastPoint) {
        this.lastPoint = Optional.ofNullable(lastPoint);
        return this;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public Path setPointList(final List<Point> pointList) {
        this.pointList = pointList;
        return this;
    }

    @Override
    public String toString() {
        return "Path{" +
                "totalCost=" + totalCost +
                ", lastPoint=" + lastPoint +
                ", pointList=" + pointList +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Path)) return false;
        final Path path = (Path) o;
        return Objects.equals(getTotalCost(), path.getTotalCost()) &&
                Objects.equals(getPointList(), path.getPointList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotalCost(), getPointList());
    }
}
