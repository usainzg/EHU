package classes;

public class Line {
    private int isBusy;
    private int isDirty;
    private int tag;
    private int recentUsed;
    private int mmBlock;
    private boolean isWrite;

    public Line() { // default line
        this.isBusy = 0;
        this.isDirty = 0;
        this.tag = 0;
        this.recentUsed = 0;
        this.mmBlock = 0;
        this.isWrite = false;
    }

    public Line(int tag, int mmBlock) {
        this.isBusy = 0;
        this.isDirty = 0;
        this.tag = tag;
        this.recentUsed = 0;
        this.mmBlock = mmBlock;
    }

    public void writeLine() {

    }

    public void readLine() {

    }

    public void visualize() {
        System.out.println(isBusy + "\t\t" + isDirty + "\t\t" + tag + "\t" + recentUsed + "\t\t || \t" + buildBlockStr());
    }

    private String buildBlockStr() {
        if (mmBlock == 0) {
            return "---";
        }

        return isWrite ? "B" + mmBlock + "w" : "B" + mmBlock;
    }
}
