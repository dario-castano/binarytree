package edu.unir.model.binarytree.gateway;

import edu.unir.model.binarytree.Node;

public interface PersonTreeGateway {
    void insert(Node node);
    void delete(Integer value);
    Boolean exists(Integer age);
    String preOrder();
    String inOrder();
    String postOrder();
}
