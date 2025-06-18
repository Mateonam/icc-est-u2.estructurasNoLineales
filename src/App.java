import materia.controller.*;


public class App {
    public static void main(String[] args) throws Exception {
    BinaryTree ab = new BinaryTree();
    ab.insert(50);
    ab.insert(17);
    ab.insert(76);
    ab.insert(9);
    ab.insert(23);
    ab.insert(54);
    ab.insert(14);
    ab.insert(19);
    ab.imprimirArbol();
    System.out.println();
    ab.printInOrder();
    System.out.println();
    ab.printPostOrder();
    System.out.println();
    if (ab.findeValue(23)) {
        System.out.println("x: Encontró el valor 23");
    } else {
        System.out.println("x: No encontró el valor 23");
    }

    if (ab.findeValue(77)) {
        System.out.println("x: Encontró el valor 77");
    } else {
        System.out.println("x: No encontró el valor 77");
    }

    }
    
}
