package main;

import clases.Expression;

public class Pruebas {

    public static void main(String[] args) {
        Expression exp = Expression.mkSimple(5);
        Expression exp1 = Expression.mkSimple(5);
        Expression expE = Expression.mkBinary('+', exp, exp1);

        System.out.println("-------------------------------------------------------");

        expE.printPreorder();

        System.out.println("-------------------------------------------------------");

        expE.printInorder();

        System.out.println("-------------------------------------------------------");

        expE.printPostorder();

        System.out.println("-------------------------------------------------------");

        int alt = expE.altura();

        System.out.println("Altura: " + alt);

        int hojas = expE.contarHojas();

        System.out.println("Hojas: " + hojas);

    }
}
