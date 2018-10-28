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

        int l = ((node.left == null) ? 0 : 1 + calcAltura(node.left));
        int r = ((node.right == null) ? 0 : 1 + calcAltura(node.right));

        return ((l > r) ? l : r);
    }

    public int contarHojas() {
        return calcHojas(this.root);
    }

    private int calcHojas(BinaryNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return calcHojas(node.left) + calcHojas(node.right);
    }

    public int contarInternos() {
        return calcInternos(this.root);
    }

    private int calcInternos(BinaryNode node) {
        if(node == null) return 0;
        if(node.left != null && node.right != null) return 1;
        return calcInternos(node.left) + calcInternos(node.right);
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
