package ro.anud.shortestpath;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.util.stream.Stream.iterate;

public class Main {
    public static void main(String[] noArgs) {
        System.out.print("\033[H\033[2J");
        System.out.println(LocalDateTime.now());
        System.out.flush();

        var random = new Random(1);
        var grid = new Grid<Long>();
        var size = 20;
        grid.add(new ArrayList<>(Arrays.asList(8L, 5L, 3L, 4L, 2L, 1L, 2L, 1L, 1L, 1L, 5L, 4L, 4L, 6L, 2L, 9L, 8L, 3L, 5L, 2L)));
        grid.add(new ArrayList<>(Arrays.asList(8L, 9L, 1L, 6L, 8L, 2L, 6L, 6L, 7L, 3L, 7L, 3L, 1L, 3L, 3L, 6L, 2L, 3L, 5L, 3L)));
        grid.add(new ArrayList<>(Arrays.asList(5L, 3L, 1L, 1L, 7L, 8L, 2L, 8L, 2L, 3L, 5L, 6L, 4L, 5L, 6L, 2L, 7L, 1L, 6L, 6L)));
        grid.add(new ArrayList<>(Arrays.asList(5L, 4L, 8L, 2L, 3L, 3L, 6L, 7L, 7L, 9L, 8L, 3L, 4L, 9L, 3L, 2L, 9L, 9L, 3L, 7L)));
        grid.add(new ArrayList<>(Arrays.asList(1L, 7L, 3L, 1L, 8L, 8L, 6L, 2L, 3L, 8L, 9L, 2L, 7L, 6L, 2L, 7L, 1L, 7L, 2L, 2L)));
        grid.add(new ArrayList<>(Arrays.asList(8L, 4L, 7L, 9L, 5L, 7L, 4L, 1L, 8L, 5L, 5L, 4L, 8L, 1L, 1L, 6L, 1L, 1L, 2L, 9L)));
        grid.add(new ArrayList<>(Arrays.asList(5L, 2L, 2L, 7L, 7L, 8L, 1L, 3L, 3L, 8L, 4L, 7L, 4L, 1L, 6L, 5L, 6L, 3L, 8L, 8L)));
        grid.add(new ArrayList<>(Arrays.asList(8L, 1L, 7L, 7L, 2L, 9L, 4L, 1L, 7L, 1L, 3L, 9L, 3L, 1L, 5L, 9L, 8L, 2L, 9L, 1L)));
        grid.add(new ArrayList<>(Arrays.asList(100L, 1L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L)));
        grid.add(new ArrayList<>(Arrays.asList(3L, 5L, 2L, 3L, 8L, 7L, 7L, 4L, 1L, 8L, 9L, 3L, 3L, 5L, 9L, 7L, 7L, 4L, 2L, 1L)));
        grid.add(new ArrayList<>(Arrays.asList(4L, 3L, 4L, 5L, 1L, 9L, 5L, 4L, 1L, 8L, 2L, 7L, 3L, 1L, 8L, 4L, 2L, 8L, 4L, 3L)));
        grid.add(new ArrayList<>(Arrays.asList(3L, 7L, 9L, 6L, 4L, 2L, 7L, 8L, 7L, 5L, 1L, 8L, 3L, 5L, 8L, 1L, 8L, 4L, 9L, 3L)));
        grid.add(new ArrayList<>(Arrays.asList(6L, 4L, 6L, 6L, 4L, 8L, 2L, 2L, 2L, 1L, 2L, 2L, 6L, 9L, 2L, 4L, 4L, 1L, 9L, 2L)));
        grid.add(new ArrayList<>(Arrays.asList(9L, 8L, 5L, 2L, 9L, 3L, 1L, 1L, 8L, 7L, 1L, 2L, 2L, 9L, 3L, 9L, 4L, 7L, 8L, 9L)));
        grid.add(new ArrayList<>(Arrays.asList(6L, 2L, 6L, 8L, 2L, 7L, 5L, 1L, 1L, 2L, 2L, 3L, 3L, 7L, 4L, 1L, 6L, 8L, 3L, 4L)));
        grid.add(new ArrayList<>(Arrays.asList(1L, 3L, 9L, 8L, 6L, 9L, 2L, 6L, 2L, 3L, 6L, 6L, 2L, 2L, 1L, 1L, 9L, 4L, 2L, 1L)));
        grid.add(new ArrayList<>(Arrays.asList(5L, 2L, 8L, 6L, 7L, 1L, 5L, 3L, 2L, 6L, 1L, 5L, 6L, 7L, 3L, 3L, 1L, 1L, 1L, 1L)));
        grid.add(new ArrayList<>(Arrays.asList(7L, 4L, 2L, 9L, 5L, 7L, 5L, 7L, 1L, 8L, 7L, 2L, 7L, 7L, 6L, 1L, 1L, 1L, 3L, 3L)));
        grid.add(new ArrayList<>(Arrays.asList(1L, 2L, 8L, 9L, 7L, 5L, 5L, 6L, 8L, 4L, 1L, 8L, 8L, 6L, 2L, 8L, 8L, 1L, 6L, 4L)));
        grid.add(new ArrayList<>(Arrays.asList(8L, 8L, 2L, 6L, 9L, 6L, 8L, 6L, 7L, 8L, 5L, 1L, 4L, 5L, 2L, 4L, 6L, 2L, 8L, 9L)));
//        iterate(0, i -> i < size, i -> i + 1).forEach(
//                i -> {
//                    var array = new ArrayList<Long>();
//                    iterate(0, j -> j < size, j -> j + 1)
//                            .forEach(j -> {
//                                array.add(
//                                        Math.round(random.nextDouble() * 10) % 9 + 1
//                                );
//                            });
//                    grid.add(array);
//                });


        var startPoint = new Point(0, 0);
        var endPoint = new Point(size - 1, size - 1);
        System.out.println(grid.get(startPoint.getX()).get(startPoint.getY()));
        System.out.println(grid.get(endPoint.getX()).get(endPoint.getY()));
        System.out.println();

        var path = ShorthestPath.search(grid, startPoint, endPoint);
        path.getPointList().forEach(System.out::println);

        grid.forEach((aLong, i, j) -> {
            if (j == 0 && i != 0) {
                System.out.println("|" + (i - 1));
            }
            System.out.print(aLong + " ");
        });
        System.out.println("|" + (grid.size() - 1));
        System.out.println();

        grid.forEach((aLong, i, j) -> {
            if (j == 0 && i != 0) {
                System.out.println("|" + (i - 1));
            }
            if (path.getPointList().contains(new Point(i, j))) {
                System.out.print("*" + " ");
            } else {
                System.out.print(aLong + " ");
            }
        });
        System.out.println("|" + (grid.size() - 1));

    }
}
