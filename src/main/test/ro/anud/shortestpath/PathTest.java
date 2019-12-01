package ro.anud.shortestpath;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PathTest {
    @Test
    public void test() {
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
}
