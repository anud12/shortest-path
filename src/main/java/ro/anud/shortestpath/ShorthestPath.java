package ro.anud.shortestpath;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.empty;

public class ShorthestPath {

    public static Long getCost(Grid<Long> grid, Point point) {
        return grid.get(point.getX()).get(point.getY());
    }

    public static Stream<Point> adjacentPoints(Point start) {
        return Stream.of(
                new Point(start.getX() + 1, start.getY() + 1),
                new Point(start.getX() + 1, start.getY() - 1),
                new Point(start.getX() + 1, start.getY()),
                new Point(start.getX(), start.getY() + 1),
                new Point(start.getX(), start.getY() - 1),
                new Point(start.getX() - 1, start.getY() + 1),
                new Point(start.getX() - 1, start.getY() - 1),
                new Point(start.getX() - 1, start.getY()));
    }

    private static List<Path> generatePaths(Path path, Grid<Long> grid) {
        return path.getLastPoint()
                .map(point -> adjacentPoints(point)
                        .filter(newPoint -> newPoint.getX() >= 0
                                && newPoint.getY() >= 0
                                && newPoint.getX() < grid.size()
                                && newPoint.getY() < grid.size())
                        .map(newPoint -> {
                            var array = new ArrayList<>(path.getPointList());
                            array.add(newPoint);
                            return new Path(getCost(grid, newPoint) + path.getTotalCost(), array);
                        })
                        .collect(Collectors.toList())
                )
                .orElse(new ArrayList<>());
    }

    public static Path search(Grid<Long> grid, Point start, Point end) {
        var path = new Path(0L, Arrays.asList(start));

        var calculatedPaths = new ArrayList<Path>();
        var paths = generatePaths(path, grid);
        var foundPath = new AtomicReference<Optional<Path>>(empty());
        while (foundPath.get().isEmpty()) {
            paths = paths.stream()
                    .sorted(Comparator.comparingLong(Path::getTotalCost))
                    .filter(Predicate.not(calculatedPaths::contains))
                    .filter(path1 -> path1.getPointList().size() < (grid.size() * grid.size()))
                    .collect(Collectors.toList());

            var currentPath = paths.get(0);
            calculatedPaths.add(currentPath);

            paths.addAll(new ArrayList<>(generatePaths(currentPath, grid)));
            paths.stream()
                    .filter(path1 -> path1.getLastPoint().map(point -> point.equals(end)).orElse(false))
                    .findAny()
                    .map(Optional::of)
                    .ifPresent(foundPath::set);
        }
        return foundPath.get().get();
    }

}
