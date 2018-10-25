package clases;

public class Expression {
    private BinaryNode root;

    private Expression(BinaryNode root) {
        this.root = root;
    }

    public static Expression mkBinary(char operador, Expression a, Expression b) {
        return new Expression(
                new BinaryNode(a.root, operador, b.root)
        );
    }

    public static Expression mkSimple(int v) {
        return new Expression(new BinaryNode(v));
    }

    public void printPreorder() {
        recorrerPreorder(this.root);
    }

    private void recorrerPreorder(BinaryNode node) {
        if (node == null) return;
        System.out.println(node.elem);
        recorrerPreorder(node.left);
        recorrerPreorder(node.right);
    }

    public void printInorder() {
        recorrerInorder(this.root);
    }

    private void recorrerInorder(BinaryNode node) {
        if (node == null) return;

        recorrerInorder(node.left);
        System.out.println(node.elem);
        recorrerInorder(node.right);
    }

    public void printPostorder() {
        recorrerPostorder(this.root);
    }

    private void recorrerPostorder(BinaryNode node) {
        if (node == null) return;

        recorrerPostorder(node.left);
        recorrerPostorder(node.right);
        System.out.println(node.elem);
    }

    /* TIPO 0 */
    public int altura() {
         return calcAltura(this.root);
    }

    private int calcAltura(BinaryNode node) {
        if (node == null) return 0;

        int l = calcAltura(node.left);
        int r = calcAltura(node.right);

        if (l > r) return 1 + calcAltura(node.left);
        return 1 + calcAltura(node.right);
    }

    public int contarHojas() {
        return calcHojas(this.root);
    }

    private int calcHojas(BinaryNode node) {
        if (node == null) return 0;
        int l = 1 + calcHojas(node.left);
        int r = 1 + calcHojas(node.right);
        return l + r;
    }

    public int contarInternos() {
        return 0;
    }

    /* TIPO 1 */


    private static class BinaryNode {
        Object elem;
        BinaryNode left;
        BinaryNode right;

        BinaryNode(BinaryNode left, Object elem, BinaryNode right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }

        BinaryNode(Object elem) {
            this.elem = elem;
        }
    }
}
