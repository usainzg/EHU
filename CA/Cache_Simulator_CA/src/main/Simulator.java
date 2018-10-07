package main;

import classes.Cache;
import classes.Util;

import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting...");
        System.out.println("-------- WELCOME TO CACHE SIMULATOR --------");


        int wordSize = -1;
        int blockSize = -1;
        int setSize = -1;
        int repl = -1;

        boolean isDataOk = false;
        while(!isDataOk) {
            System.out.println("First, we need to decide the structure: ");

            System.out.println("Size of the words (4 or 8) bytes: ");
            wordSize = scanner.nextInt();

            System.out.println("Size of the block/line (32 or 64) bytes: ");
            blockSize = scanner.nextInt();

            System.out.println("Size of the sets 1 (direct), 2, 4 or 8 (fully): ");
            setSize = scanner.nextInt();

            isDataOk = Util.validateData(wordSize, blockSize, setSize, repl);
            if(!isDataOk) {
                System.out.println("Ouups, you introduce an incorrect data, try again...");
            }
        }

        Cache c = new Cache(setSize, wordSize, blockSize);

        Util.printSeparator();

        c.printCache();
        Util.printSeparator();

        c.printAddressStructure();

        while(true) {
            System.out.println("-------- MENU --------");
            System.out.println("1. Simulate operation.");
            System.out.println("2. Visualize Cache Memory.");
            System.out.println("3. Exit.");

            int opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Intro address: ");
                    int addr = scanner.nextInt();
                    System.out.println("Is a read (0) or a write (1): ");
                    int op = scanner.nextInt();

                    c.simulateOperation(op, addr);
                    c.visualizeCache();
                    break;
                case 2:
                    System.out.println("-------- Visualizing Cache Memory --------");
                    c.visualizeCache();
                    break;
                case 3:
                    System.out.println("Bye bye...");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }
}
