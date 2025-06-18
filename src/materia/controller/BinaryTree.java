package materia.controller;
import materia.models.*;

public class BinaryTree {

    
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
        

    }   
    
    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            padre = new Node(value);
            return padre;
        }

        if(value < padre.getNum()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if(value > padre.getNum()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void imprimirArbol() {
        imprimirArbolRec(root);
    }

    private void imprimirArbolRec(Node node) {
        if (node != null) {
            System.out.print(node.getNum() + ", ");
            imprimirArbolRec(node.getLeft());
            imprimirArbolRec(node.getRight());
        }
    }

    public void printInOrder() {
        printInOrderRec(root);
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
    }

    private void printPostOrderRec(Node node) {
        if (node != null) {
            printPostOrderRec(node.getLeft());
            printPostOrderRec(node.getRight());
            System.out.print(node.getNum() + ", ");
        }
    }

    public boolean findeValue(int value) {
    return findeValueRec(root, value);
}

    private boolean findeValueRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getNum() == value) {
            return true;
        }
        return findeValueRec(node.getLeft(), value) || findeValueRec(node.getRight(), value);
    }


}
