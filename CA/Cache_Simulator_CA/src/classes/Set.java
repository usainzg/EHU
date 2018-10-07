package classes;

import java.util.ArrayList;

public class Set {
    private ArrayList<Line> lines;

    public Set() {
        this.lines = new ArrayList<>();
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void visualize() {
        for (Line line : lines) line.visualize();
    }
}
