package main;

import clases.Expression;

public class Pruebas {

    public static void main(String[] args) {
        Expression exp = Expression.mkSimple(5);
        Expression exp1 = Expression.mkSimple(5);
        Expression exp3 = Expression.mkSimple(10);
        Expression expE0 = Expression.mkBinary('*', exp, exp3);
        Expression expE = Expression.mkBinary('+', expE0, exp1);


        System.out.println("---PreOrden-------------------------------------------");

        expE.printPreorder();

        System.out.println("---InOrden-------------------------------------------");

        expE.printInorder();

        System.out.println("---PostOrden-------------------------------------------");

        expE.printPostorder();

        System.out.println("-------------------------------------------------------");

        int alt = expE.altura();

        System.out.println("Altura: " + alt);

        int hojas = expE.contarHojas();

        System.out.println("Hojas: " + hojas);

        int internos = expE.contarInternos();

        System.out.println("Internos: " + internos);

        double evaluated = Expression.eval(expE);

        System.out.println("Eval: " + evaluated);

        System.out.println("PrettyPrint: ");
        expE.printPreordenPretty();

        System.out.println("ValueOf: ");
        Expression expRet = Expression.valueOf("35-");
        expRet.printPreordenPretty();
    }
}
