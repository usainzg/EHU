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

    boolean hasMMBlock(int mmBlock) {
        for (Line line: lines) {
            if (line.getMmBlock() == mmBlock) return true;
        }
        return false;
    }
}
