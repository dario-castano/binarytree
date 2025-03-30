package edu.unir.model.binarytree;

import edu.unir.model.binarytree.gateway.PersonTreeGateway;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BinarySearchTree implements PersonTreeGateway {
    private Node root;

    @Override
    public void insert(Node node) {
        root = insertRec(root, node);
    }

    private Node insertRec(Node current, Node node) {
        if (current == null) {
            return node;
        }

        if (node.getPerson().lt(current.getPerson())) {
            current.setLeft(insertRec(current.getLeft(), node));
        } else if (node.getPerson().gt(current.getPerson())) {
            current.setRight(insertRec(current.getRight(), node));
        }
        // Si es igual, no insertamos (evitamos duplicados)

        return current;
    }

    @Override
    public void delete(Integer age) {
        root = deleteRec(root, age);
    }

    private Node deleteRec(Node current, Integer age) {
        if (current == null) {
            return null;
        }

        if (age < current.getPerson().getAge()) {
            current.setLeft(deleteRec(current.getLeft(), age));
        } else if (age > current.getPerson().getAge()) {
            current.setRight(deleteRec(current.getRight(), age));
        } else {
            // Nodo con un solo hijo o sin hijos
            if (current.getLeft() == null) {
                return current.getRight();
            } else if (current.getRight() == null) {
                return current.getLeft();
            }

            // Nodo con dos hijos: obtener el sucesor inorden (mínimo en subárbol derecho)
            current.setPerson(findMin(current.getRight()).getPerson());

            // Eliminar el sucesor inorden
            current.setRight(deleteRec(current.getRight(), current.getPerson().getAge()));
        }

        return current;
    }

    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    @Override
    public Boolean exists(Integer age) {
        return existsRec(root, age);
    }

    private Boolean existsRec(Node current, Integer age) {
        if (current == null) {
            return false;
        }

        if (age.equals(current.getPerson().getAge())) {
            return true;
        }

        return age < current.getPerson().getAge()
                ? existsRec(current.getLeft(), age)
                : existsRec(current.getRight(), age);
    }

    @Override
    public String preOrder() {
        StringBuilder sb = new StringBuilder();
        preOrderRec(root, sb);
        return sb.toString().trim();
    }

    private void preOrderRec(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.getPerson().getAge()).append(" ");
            preOrderRec(node.getLeft(), sb);
            preOrderRec(node.getRight(), sb);
        }
    }

    @Override
    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrderRec(root, sb);
        return sb.toString().trim();
    }

    private void inOrderRec(Node node, StringBuilder sb) {
        if (node != null) {
            inOrderRec(node.getLeft(), sb);
            sb.append(node.getPerson().getAge()).append(" ");
            inOrderRec(node.getRight(), sb);
        }
    }

    @Override
    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        postOrderRec(root, sb);
        return sb.toString().trim();
    }

    private void postOrderRec(Node node, StringBuilder sb) {
        if (node != null) {
            postOrderRec(node.getLeft(), sb);
            postOrderRec(node.getRight(), sb);
            sb.append(node.getPerson().getAge()).append(" ");
        }
    }

    // Métodos adicionales útiles
    public int getHeight() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(heightRec(node.getLeft()), heightRec(node.getRight()));
    }

    public int size() {
        return sizeRec(root);
    }

    private int sizeRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRec(node.getLeft()) + sizeRec(node.getRight());
    }
}
