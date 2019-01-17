package main;

import ds.StackOfT;

public class DSTest {
    public static void main(String[] args) {
        StackOfT<Integer> stack = new StackOfT<>();

        System.out.println("Empty: " + stack.isEmpty());

        stack.push(9);

        System.out.println("Empty: " + stack.isEmpty());

        System.out.println("Popped: " + stack.pop());

        System.out.println("Empty: " + stack.isEmpty());

    }
}
