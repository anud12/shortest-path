package ro.anud.shortestpath;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] noArgs) {
        System.out.print("\033[H\033[2J");
        System.out.println(LocalDateTime.now());
        System.out.flush();

        var size = 3;

        var grid = new Grid<Long>();
        grid.add(new ArrayList<>(Arrays.asList(1L, 99L, 0L)));
        grid.add(new ArrayList<>(Arrays.asList(2L, 99L, 1L)));
        grid.add(new ArrayList<>(Arrays.asList(1L, 2L, 5L)));

        grid.forEach((aLong, i, j) -> {
            if (j == 0 && i != 0) {
                System.out.println("|" + (i - 1));
            }
            System.out.print(aLong + " ");
        });
        System.out.println("|" + (grid.size() - 1));

        System.out.println();
        var startPoint = new Point(0, 0);
        var endPoint = new Point(0, 2);
        System.out.println(grid.get(startPoint.getX()).get(startPoint.getY()));
        System.out.println(grid.get(endPoint.getX()).get(endPoint.getY()));
        System.out.println();

        ShorthestPath.search(grid, startPoint, endPoint);

    }
}
