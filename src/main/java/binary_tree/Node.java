package main.java.binary_tree;

/**
 * Created by tanerali on 31/07/2017.
 */
public class Node {

    int key;
    String name;

    Node leftChild;
    Node rightChild;


    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Node{key=" + key + ", name=" + name + "}";
    }
}
