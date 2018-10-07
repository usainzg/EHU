package classes;

public class Util {

    public static void printSeparator() {
        System.out.println("------------------------------------------");
    }
    public static boolean validateData(int wordSize, int blockSize, int setSize, int repl) {
        if(wordSize != 4 && wordSize != 8) return false;
        if(blockSize != 32 && blockSize != 64) return false;
        if(setSize != 1 && setSize != 2 && setSize != 4 && setSize != 8) return false;
        if(repl != 0 && repl != 1) return false;
        return true;
    }
    public static int log(double num, int base) {
        return (int) (Math.log10(num) / Math.log10(base));
    }
}
