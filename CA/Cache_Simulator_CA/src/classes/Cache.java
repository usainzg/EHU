package classes;

public class Cache {
    private Line[] lines;
    private Set[] sets;
    private int linesPerSet;
    private int numberOfWords;
    private int wordSize;
    private int blockSize;
    private int nSets;

    public Cache(int linesPerSet, int wordSize, int blockSize) {
        this.linesPerSet = linesPerSet;
        numberOfWords = blockSize / wordSize;
        this.wordSize = wordSize;
        this.blockSize = blockSize;
        initLines();
    }

    private void initLines() {
        this.lines = new Line[8];
        this.nSets = (lines.length / linesPerSet);
        initSets();
        int aux = 0;
        int iSet = 0;
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Line();

            if (aux >= linesPerSet) {
                aux = 0;
                iSet += 1;
            }
            sets[iSet].getLines().add(lines[i]);
            aux += 1;
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
        System.out.println("- Replacement policy: LRU");
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
        boolean isHit = isHit(tag, set, line);
        System.out.println(
                "- Word: " + word +
                "\n- MM Block: " + mmBlock +
                "\n- Tag: " + tag +
                "\n- Set: " + set +
                "\n- Line: " + line +
                "\n- Cache: " + (isHit ? "Hit" : "Miss")
        );

        if (op == 0) {
            readCM(tag, mmBlock, line, set, isHit);
        } else {
            writeCM(tag, mmBlock, line, set, isHit);
        }


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
            return 0;
        }

        return mmBlock % (lines.length / linesPerSet);
    }

    private int returnLine(int mmBlock) {
        if(linesPerSet == 1) {
            return mmBlock % lines.length;
        }
        return mmBlock / (lines.length / linesPerSet);
    }

    private boolean isHit(int tag, int set, int line) {
        if (set == -1) {
            return sets[line].getLines().get(0).getTag() == tag;
        }

        return sets[set].hasTag(tag);
    }

    public void visualizeCache() {
        Util.printSeparator();
        System.out.println("Busy\tDirty\tTag\tRepl.\t ||\t   Data");
        for (Set set: sets) {
            set.visualize();
        }
        Util.printSeparator();
    }

    private void readCM(int tag, int mmBlock, int line, int set, boolean isHit) {
        switch (linesPerSet) {
            case 1:
                if (!isHit && sets[line].getLines().get(0).getIsDirty() == 1) {
                    sets[line].getLines().get(0).changeDirty(0);
                }

                sets[line].getLines().get(0).changeMmBlock(mmBlock);
                sets[line].getLines().get(0).changeBusy(1);
                sets[line].getLines().get(0).changeTag(tag);

                break;
            case 2:
            case 4:
            case 8:
                if (!isHit) {
                    Line line1 = sets[set].getLines().get(0);
                    for (int i = 1; i < sets[set].getLines().size(); i++) {
                        if (line1.getRecentUsed() > sets[set].getLines().get(i).getRecentUsed()) {
                            line1 = sets[set].getLines().get(i);
                        }
                    }

                    line1.changeMmBlock(mmBlock);
                    line1.changeBusy(1);
                    line1.addLRU();
                    line1.changeTag(tag);

                    if (line1.getIsDirty() == 1) {
                        line1.changeDirty(0);
                    }
                }

                break;
            default:
                break;
        }
    }

    private void writeCM(int tag, int mmBlock, int line, int set, boolean isHit) {

        switch (linesPerSet) {
            case 1:
                if (!isHit && sets[line].getLines().get(0).getIsDirty() == 1) {
                    sets[line].getLines().get(0).changeDirty(1);
                }

                sets[line].getLines().get(0).changeMmBlock(mmBlock);
                sets[line].getLines().get(0).changeBusy(1);
                sets[line].getLines().get(0).changeTag(tag);
                sets[line].getLines().get(0).changeWrite(true);
                sets[line].getLines().get(0).changeDirty(1);

                break;
            case 2:
            case 4:
            case 8:
                if (!isHit) {

                    Line lineAux = sets[set].getLines().get(0);
                    for (int i = 1; i < sets[set].getLines().size(); i++) {
                        if (lineAux.getRecentUsed() > sets[set].getLines().get(i).getRecentUsed()) {
                            lineAux = sets[set].getLines().get(i);
                        }
                    }

                    lineAux.changeMmBlock(mmBlock);
                    lineAux.changeBusy(1);
                    lineAux.addLRU();
                    lineAux.changeTag(tag);
                    lineAux.changeMmBlock(mmBlock);
                    lineAux.changeWrite(true);
                    lineAux.changeDirty(1);
                } else {
                    for (Line line2: sets[set].getLines()) {
                        if (line2.getTag() == tag) {
                            line2.changeWrite(true);
                        }
                    }
                }

                break;
            default:
                break;
        }
    }
}
