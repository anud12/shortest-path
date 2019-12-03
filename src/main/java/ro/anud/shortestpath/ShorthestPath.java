package ro.anud.shortestpath;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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

    private static List<Path> generatePaths(Path path, Grid<Long> grid, Collection<Point> ignoreList) {
        return path.getLastPoint()
                .map(point -> adjacentPoints(point)
                        .filter(newPoint -> newPoint.getX() >= 0
                                && newPoint.getY() >= 0
                                && newPoint.getX() < grid.size()
                                && newPoint.getY() < grid.size())
                        .filter(Predicate.not(ignoreList::contains))
                        .map(newPoint -> {
                            var array = new ArrayList<>(path.getPointList());
                            array.add(newPoint);
                            ignoreList.add(point);
                            return new Path(getCost(grid, newPoint) + path.getTotalCost(), array);
                        })
                        .collect(Collectors.toList())
                )
                .orElse(new ArrayList<>());
    }

    public static Path search(Grid<Long> grid, Point start, Point end) {
        var path = new Path(0L, Arrays.asList(start));
        var usedPoints = new HashSet<Point>();
        usedPoints.add(start);

        var calculatedPaths = new HashSet<Path>();
        var paths = generatePaths(path, grid, usedPoints);
        var foundPath = new AtomicReference<Optional<Path>>(empty());
        var pathSize = new AtomicInteger();
        new Thread(() -> {
            while (foundPath.get().isEmpty()){
                System.out.println(pathSize);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        while (foundPath.get().isEmpty()) {
            paths = paths.stream()
                    .sorted(Comparator.comparingLong(Path::getTotalCost))
//                    .filter(Predicate.not(calculatedPaths::contains))
                    .filter(path1 -> path1.getPointList().size() < (grid.size() * grid.size()))
                    .collect(Collectors.toList());

            pathSize.set(paths.size());
            var currentPath = paths.remove(0);
            calculatedPaths.add(currentPath);
            paths.addAll(new ArrayList<>(generatePaths(currentPath, grid, usedPoints)));
            paths.stream()
                    .filter(path1 -> path1.getLastPoint().map(point -> point.equals(end)).orElse(false))
                    .findAny()
                    .map(Optional::of)
                    .ifPresent(foundPath::set);

        }
        System.out.println(paths.size());
        return foundPath.get().get();
    }

}
