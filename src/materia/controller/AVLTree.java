package materia.controller;

import materia.models.Node;

public class AVLTree {
    
    private Node root;
    

    public AVLTree(){
        this.root= null;
    }

    public void insert(int value){
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo Inserado -> " + value + " con balance: " + getBalance(newNode));
            return newNode;
        }

        if (value <= node.getValor()) {
            Node newNode = insertRec(node.getLeft(), value);
            node.setLeft(newNode);
        }else if (value > node.getValor()) {
            node.setRight(insertRec(node.getRight(), value));
        }else{
            return node;
        }
        System.out.println("Nodo actual -> " + node.getValor());
        int altura= 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setHeight(altura);
        System.out.println("\tAltura -> " + altura);

        int balance = getBalance(node);
        System.out.println("\tBalance -> " + balance);

        // Cazo IZQUIERDA IZQUIERDA
        if (balance > 1 && value < node.getLeft().getValor()) {
            System.out.println("Rotacion Simple Derecha");
            return rigthRotation(node);
        }
        // CASO DERECHA DERECHA 
        if (balance <-1 && value > node.getRight().getValor()) {
            System.out.println("Rotacion simple Izquierda");
             return leftRotation(node);
        }
        // CAZO IZQUIERDA DERECHA 
        if (balance > 1 && value  > node.getLeft().getValor()) {
            System.out.println("cAMBIO");
            node.setLeft(leftRotation(node.getLeft()));
            System.out.println("Rotacion izquierda-derecha simple a la  Derecha");
            return rigthRotation(node);
        }
        //Cazo DERECHA IZQUIERDA
        if (balance <-1 && value < node.getRight().getValor()) {
            System.out.println("Cambio");
            node.setRight(rigthRotation(node.getRight()));
            System.out.println("Rotacion derecha-izquierda simple a la  Izquierda");
            return leftRotation(node);
        }

        // Para notacion a derecha restar en el balance 
        return node;
    }

    private int height(Node node){
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(Node node) {
    if (node == null) {
        return 0;
    }
    return height(node.getLeft()) - height(node.getRight());
    }

    private Node leftRotation(Node x){
        Node y = x.getRight();
        Node temp = y.getLeft();

        //Imprimir informacion antes de la rotacion 
        System.out.println("Rotacion IZQ en nodo: " + x.getValor() + ", con balance = " + getBalance(x) );

        // Realizar la rotacion 
        y.setLeft(x);
        x.setRight(temp);

        //Actualizar las alturas
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        //Imprimir informacion despues de la rotacion
        System.out.println("Nueva raiz despues de la rotacion " + y.getValor());

        // Devolver la nueva raiz
        return y;
    }

    private Node rigthRotation(Node y){
        Node x = y.getLeft();
        Node temp = x.getRight();

        //Imprimir informacion antes de la rotacion 
        System.out.println("Rotacion DER en nodo: " + y.getValor() + ", con balance = " + getBalance(y) );

        // Realizar la rotación
        x.setRight(y);
        y.setLeft(temp);

        // Actualizar las alturas
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        // Imprimir información después de la rotación
        System.out.println("Nueva raiz despues de la rotacion " + x.getValor());

        // Devolver la nueva raíz
        return x;
    }



}