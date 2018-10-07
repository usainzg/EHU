package classes;

import java.util.ArrayList;

class Set {
    private ArrayList<Line> lines;

    Set() {
        this.lines = new ArrayList<>();
    }

    ArrayList<Line> getLines() {
        return lines;
    }

    void visualize() {
        Util.printSeparator();
        for (Line line: lines) line.visualize();
        Util.printSeparator();
    }

    boolean hasTag(int tag) {
        for (Line line: lines) {
            if (line.getTag() == tag) return true;
        }
        return false;
    }
}
