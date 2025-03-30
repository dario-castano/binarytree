package edu.unir;

import edu.unir.model.Person;
import edu.unir.model.binarytree.Node;
import edu.unir.model.binarytree.BinarySearchTree;
import edu.unir.model.binarytree.gateway.PersonTreeGateway;

public class Main {
    public static void main(String[] args) {
        // 1. Crear instancia del árbol binario
        PersonTreeGateway tree = new BinarySearchTree();

        // 2. Crear algunas personas
        Person p1 = new Person("Juan", 25);
        Person p2 = new Person("María", 30);
        Person p3 = new Person("Pedro", 20);
        Person p4 = new Person("Ana", 35);
        Person p5 = new Person("Luis", 28);

        // 3. Insertar nodos en el árbol
        tree.insert(new Node(p1));
        tree.insert(new Node(p2));
        tree.insert(new Node(p3));
        tree.insert(new Node(p4));
        tree.insert(new Node(p5));

        // 4. Mostrar recorridos
        System.out.println("Recorrido InOrden (ordenado por edad): " + tree.inOrder());
        System.out.println("Recorrido PreOrden: " + tree.preOrder());
        System.out.println("Recorrido PostOrden: " + tree.postOrder());

        // 5. Operaciones de búsqueda
        int searchAge = 30;
        System.out.println("\n¿Existe alguien con " + searchAge + " años? " + tree.exists(searchAge));

        // 6. Operación de eliminación
        System.out.println("\nEliminando persona de " + searchAge + " años");
        tree.delete(searchAge);
        System.out.println("Recorrido InOrden después de eliminar: " + tree.inOrder());

        // 7. Verificar si existe después de eliminar
        System.out.println("¿Existe alguien con " + searchAge + " años ahora? " + tree.exists(searchAge));
    }
}