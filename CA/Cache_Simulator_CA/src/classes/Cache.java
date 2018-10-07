package classes;

public class Cache {
    private Line[] lines;
    private Set[] sets;
    private int linesPerSet;
    private int numberOfWords;
    private int replacement;
    private int wordSize;
    private int blockSize;
    private int nSets;

    public Cache(int linesPerSet, int wordSize, int blockSize, int replacement) {
        this.linesPerSet = linesPerSet;
        numberOfWords = blockSize / wordSize;
        this.replacement = replacement;
        this.wordSize = wordSize;
        this.blockSize = blockSize;
        initLines();


        for(int i = 0; i < nSets; i++) {
            System.out.println("Set: " + i);
            sets[i].visualize();
            Util.printSeparator();
        }
    }

    private void initLines() {
        this.lines = new Line[8];
        this.nSets = (lines.length / linesPerSet);
        initSets();
        int aux = 0;
        int iSet = 0;
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Line();

            if (aux < linesPerSet) {
                sets[iSet].getLines().add(lines[i]);
                aux += 1;
            } else {
                aux = 0;
                iSet += 1;
            }
        }
    }

    private void initSets() {
        this.sets = new Set[nSets];
        for(int i = 0; i < sets.length; i++) sets[i] = new Set();
    }

    public void printCache() {
        System.out.println("Printing Cache Memory details... ");
        System.out.println("- Lines per set: " + linesPerSet);
        System.out.println("- Number of words per line: " + numberOfWords);
        System.out.println("- Word size (bytes): " + wordSize);
        System.out.println("- Block size (bytes): " + blockSize);
        System.out.println("- Number of sets: " + nSets);
        System.out.println("- Replacement policy: " + (replacement == 0 ? "FIFO" : "LRU"));
    }

    public void printAddressStructure() {
        int totalSizeB = 20;
        int byteB = Util.log(wordSize, 2);
        int wordB = Util.log(numberOfWords, 2);
        int mmB = totalSizeB - (byteB + wordB);

        System.out.println("Main Memory Address Structure:");
        System.out.println("-> ___ MM Block: " + mmB + "bit ___ Word: " + wordB + "bit ___ Byte: " + byteB + "bit ___");

        Util.printSeparator();
        System.out.println("Cache Memory Address Structure:");
        switch (linesPerSet) {
            case 1:
                int lineB = Util.log(lines.length, 2);
                int tagB = totalSizeB - (byteB + wordB + lineB);
                System.out.println("-> --- Tag: " + tagB + "bit --- L(CM): " + lineB + "bit --- Word: " + wordB + "bit --- Byte: " + byteB + "bit ---");
                break;
            case 2:
            case 4:
                int setB = Util.log(nSets, 2);
                int tagb = totalSizeB - (byteB + wordB + setB);
                System.out.println("-> --- Tag: " + tagb + "bit --- Set: " + setB + "bit --- Word: " + wordB + "bit --- Byte: " + byteB + "bit ---");
                break;
            case 8:
                System.out.println("-> --- Tag: " + mmB + "bit  --- Word: " + wordB + "bit --- Byte: " + byteB + "bit ---");
            default:
                break;
        }
        Util.printSeparator();
    }

    public void simulateOperation(int op, int addr) {
        int word = addr / wordSize;
        int mmBlock = word / numberOfWords;
        int tag = returnTag(mmBlock);
        int set = returnSet(mmBlock);
        int line = returnLine(mmBlock);

        Util.printSeparator();
        System.out.println(
                "- Word: " + word +
                "\n- MM Block: " + mmBlock +
                "\n- Tag: " + tag +
                "\n- Set: " + set +
                "\n- Line: " + line
        );

        boolean isHit = returnIsHit(mmBlock, set, line);
        Util.printSeparator();
    }

    private int returnTag(int mmBlock) {
        if(linesPerSet == 1) {
            return mmBlock / lines.length;
        }

        return mmBlock / (lines.length / linesPerSet);
    }

    private int returnSet(int mmBlock) {
        if(linesPerSet == 1) {
            return -1;
        }

        return mmBlock % (lines.length / linesPerSet);
    }

    private int returnLine(int mmBlock) {
        if(linesPerSet == 1) {
            return mmBlock / lines.length;
        }
        return mmBlock / (lines.length / linesPerSet);
    }

    private boolean returnIsHit(int mmBlock, int set, int line) {
        if (line != -1) {
            return lines[line].getMmBlock() == mmBlock;
        }

        if (linesPerSet != 8) {

        }

        for (Line line1: lines) {
            if (line1.getMmBlock() == mmBlock) return true;
        }

        return false;
    }

    public void visualizeCache() {
        Util.printSeparator();
        System.out.println("Busy\tDirty\tTag\tRepl.\t ||\t   Data");
        for (Line line: lines) line.visualize();
        Util.printSeparator();
    }
}
