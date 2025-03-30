package edu.unir.model.binarytree;

import edu.unir.model.Person;
import lombok.Data;
import lombok.Getter;

@Data
public class Node {
    private Person person;
    private Node left;
    private Node right;

    public Node(Person person) {
        this.person = person;
        this.left = null;
        this.right = null;
    }
}
