package ro.anud.shortestpath;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PathTest {
    @Test
    public void size3() {
        var grid = new Grid<Long>();
        grid.add(new ArrayList<>(Arrays.asList(1L, 99L, 0L)));
        grid.add(new ArrayList<>(Arrays.asList(2L, 99L, 1L)));
        grid.add(new ArrayList<>(Arrays.asList(1L, 2L, 5L)));
        var startPoint = new Point(0, 0);
        var endPoint = new Point(0, 2);
        Path result = ShorthestPath.search(grid, startPoint, endPoint);
        System.out.println(result);
        Assert.assertEquals((Long) 5L, result.getTotalCost());
        Assert.assertEquals(Arrays.asList(new Point(0, 0),
                                          new Point(1, 0),
                                          new Point(2, 1),
                                          new Point(1, 2),
                                          new Point(0, 2)),
                            result.getPointList());
    }

    @Test
    public void size20() {
        var grid = new Grid<Long>();
        grid.add(new ArrayList<>(Arrays.asList(8L, 5L, 3L, 4L, 2L, 1L, 2L, 1L, 1L, 1L, 5L, 4L, 4L, 6L, 2L, 9L, 8L, 3L, 5L, 2L)));
        grid.add(new ArrayList<>(Arrays.asList(8L, 9L, 1L, 6L, 8L, 2L, 6L, 6L, 7L, 3L, 7L, 3L, 1L, 3L, 3L, 6L, 2L, 3L, 5L, 3L)));
        grid.add(new ArrayList<>(Arrays.asList(5L, 3L, 1L, 1L, 7L, 8L, 2L, 8L, 2L, 3L, 5L, 6L, 4L, 5L, 6L, 2L, 7L, 1L, 6L, 6L)));
        grid.add(new ArrayList<>(Arrays.asList(5L, 4L, 8L, 2L, 3L, 3L, 6L, 7L, 7L, 9L, 8L, 3L, 4L, 9L, 3L, 2L, 9L, 9L, 3L, 7L)));
        grid.add(new ArrayList<>(Arrays.asList(1L, 7L, 3L, 1L, 8L, 8L, 6L, 2L, 3L, 8L, 9L, 2L, 7L, 6L, 2L, 7L, 1L, 7L, 2L, 2L)));
        grid.add(new ArrayList<>(Arrays.asList(8L, 4L, 7L, 9L, 5L, 7L, 4L, 1L, 8L, 5L, 5L, 4L, 8L, 1L, 1L, 6L, 1L, 1L, 2L, 9L)));
        grid.add(new ArrayList<>(Arrays.asList(5L, 2L, 2L, 7L, 7L, 8L, 1L, 3L, 3L, 8L, 4L, 7L, 4L, 1L, 6L, 5L, 6L, 3L, 8L, 8L)));
        grid.add(new ArrayList<>(Arrays.asList(8L, 1L, 7L, 7L, 2L, 9L, 4L, 1L, 7L, 1L, 3L, 9L, 3L, 1L, 5L, 9L, 8L, 2L, 9L, 1L)));
        grid.add(new ArrayList<>(Arrays.asList(100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 1L)));
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
        var startPoint = new Point(0, 0);
        var endPoint = new Point(19, 19);
        Path result = ShorthestPath.search(grid, startPoint, endPoint);
        System.out.println(result);
        Assert.assertEquals((Long) 60L, result.getTotalCost());
        Assert.assertEquals(Arrays.asList(
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 2),
                new Point(2, 3),
                new Point(3, 4),
                new Point(3, 5),
                new Point(4, 6),
                new Point(5, 7),
                new Point(6, 8),
                new Point(7, 9),
                new Point(8, 10),
                new Point(8, 11),
                new Point(9, 12),
                new Point(10, 13),
                new Point(11, 13),
                new Point(12, 14),
                new Point(13, 14),
                new Point(14, 15),
                new Point(15, 15),
                new Point(16, 16),
                new Point(17, 17),
                new Point(18, 18),
                new Point(19, 19)),
                            result.getPointList());
    }
}
