package ro.anud.shortestpath;

import java.util.ArrayList;

public class Grid<T> extends ArrayList<ArrayList<T>> {
    public interface ForEachConsumer<T> {
        public void exec(T t, Integer i, Integer j);
    }

    public interface ForEach<T, U> {
        public U exec(T t, Integer i, Integer j);
    }

    public void forEach(ForEachConsumer<T> forEach) {
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                forEach.exec(this.get(i).get(j), i, j);
            }
        }
    }

    public <U> Grid<U> map(ForEach<T, U> forEach) {
        var array = new Grid<U>();
        for (int i = 0; i < this.size(); i++) {
            var lineArray = new ArrayList<U>();
            for (int j = 0; j < this.size(); j++) {
                lineArray.add(forEach.exec(this.get(i).get(j), i, j));
            }
            array.add(lineArray);
        }
        return array;
    }
}
