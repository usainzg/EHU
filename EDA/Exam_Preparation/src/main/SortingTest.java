package main;

import sorting.Insertion;
import sorting.Merge;
import sorting.Selection;

public class SortingTest {
    public static void main(String[] args) {
        Comparable a[] = {1, 5, 6, 7, 4, 9};
        Selection.sort(a);
        SortingTest.showArr(a);

        Comparable b[] = {1, 5, 6, 7, 4, 9};
        Insertion.sort(b);
        SortingTest.showArr(b);

        Comparable c[] = {1, 5, 6, 7, 4, 9};
        Merge.sort(c);
        SortingTest.showArr(b);
    }

    private static void showArr(Comparable[] a) {
        System.out.println("--------------------");
        for (Comparable c: a) System.out.println(c);
        System.out.println("--------------------");
    }
}
