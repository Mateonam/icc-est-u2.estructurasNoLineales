package materia.controller;

import materia.models.Node;

public class BinaryTree {

    private Node root;
    private int peso;

    public BinaryTree() {
        this.root = null;
        this.peso = 0;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            peso++;
            return new Node(value);
        }
        if (value < padre.getNum()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getNum()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void printPreOrder() {
        printPreOrderRec(root);
        System.out.println();
    }

    private void printPreOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.getNum() + ", ");
            printPreOrderRec(node.getLeft());
            printPreOrderRec(node.getRight());
        }
    }

    public void printInOrder() {
        printInOrderRec(root);
        System.out.println();
    }

    private void printInOrderRec(Node node) {
        if (node != null) {
            printInOrderRec(node.getLeft());
            System.out.print(node.getNum() + ", ");
            printInOrderRec(node.getRight());
        }
    }

    public void printPostOrder() {
        printPostOrderRec(root);
        System.out.println();
    }

    private void printPostOrderRec(Node node) {
        if (node != null) {
            printPostOrderRec(node.getLeft());
            printPostOrderRec(node.getRight());
            System.out.print(node.getNum() + ", ");
        }
    }

    public boolean findValue(int value) {
        return findValueRec(root, value);
    }

    private boolean findValueRec(Node node, int value) {
        if (node == null) return false;
        if (node.getNum() == value) return true;
        return findValueRec(node.getLeft(), value) || findValueRec(node.getRight(), value);
    }

    public int getHeightTree() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node node) {
        if (node == null) return 0;
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void printInOrderAlt() {
        printInOrderRecAlt(root);
        System.out.println();
    }

    private void printInOrderRecAlt(Node node) {
        if (node != null) {
            printInOrderRecAlt(node.getLeft());
            System.out.print(node.getNum() + "(h=" + getHeightRec(node) + "), ");
            printInOrderRecAlt(node.getRight());
        }
    }

    private int getBalanceFactor(Node n) {
        if (n == null) return 0;
        return getHeightRec(n.getLeft()) - getHeightRec(n.getRight());
    }

    public void printInOrderBf() {
        printInOrderRecBf(root);
        System.out.println();
    }

    private void printInOrderRecBf(Node n) {
        if (n != null) {
            printInOrderRecBf(n.getLeft());
            System.out.print(n.getNum() + "(bf=" + getBalanceFactor(n) + "), ");
            printInOrderRecBf(n.getRight());
        }
    }

    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node n) {
        if (n == null) return true;
        if (Math.abs(getBalanceFactor(n)) > 1) return false;
        return isBalancedRec(n.getLeft()) && isBalancedRec(n.getRight());
    }

    public void printUnbalancedNodes() {
        printUnbalancedRec(root);
        System.out.println();
    }

    private void printUnbalancedRec(Node n) {
        if (n != null) {
            printUnbalancedRec(n.getLeft());
            if (Math.abs(getBalanceFactor(n)) > 1) System.out.print(n.getNum() + "(fE=" + getBalanceFactor(n) + ") ");
            printUnbalancedRec(n.getRight());
        }
    }

    public int printPeso() {
        System.out.println("Peso del árbol = " + peso);
        return peso;
    }
}





