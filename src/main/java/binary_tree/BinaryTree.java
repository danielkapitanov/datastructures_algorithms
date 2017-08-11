package main.java.binary_tree;

/**
 * Created by tanerali on 31/07/2017.
 */
public class BinaryTree {

    Node root;

    public void addNode(int key, String name){

        //create a new node and initialize it
        Node newNode = new Node(key, name);

        //if there is no root this becomes root
        if (root == null) {
            root = newNode;
        } else {

            //set root as the node we will start
            //with as we traverse the tree
            Node focusNode = root;

            //future parent for our new Node
            Node parent;

            while (true){
                //root is the top parent so we start there
                parent = focusNode;

                //check if the new node should go on the left or right side
                if (key < focusNode.key) {

                    //switch focus to the left child
                    focusNode = focusNode.leftChild;

                    //if the left child has no no children
                    if (focusNode == null) {
                        //then place the new node on the left of it
                        parent.leftChild = newNode;
                        return; //all done
                    }

                } else {

                    focusNode = focusNode.rightChild;

                    //if the right child has no children
                    if (focusNode == null) {
                        //then place the new node on the right of it
                        parent.rightChild = newNode;
                        return; //all done
                    }
                }
            }
        }

    }

    //all nodes are visited in ascending order
    //recursion is used to go to one node and then go to its child nodes and so forth
    public void inOrderTraverse(Node focusNode) {

        if (focusNode != null){

            //traverse the left node
            inOrderTraverse(focusNode.leftChild);

            //visit the currently focused on node
            System.out.println(focusNode);

            //traverse the right node
            inOrderTraverse(focusNode.rightChild);
        }

    }


    public void preorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }


    public Node findNode (int key) {
        //start at the top of the tree
        Node focusNode = root;

        //while we havent found the Node keep looking
        while (focusNode.key != key) {

            //if we should search to the left
            if (key < focusNode.key){
                //shift the focus node to the left child
                focusNode = focusNode.leftChild;
            } else {
                //shift the focus node to the right child
                focusNode = focusNode.rightChild;
            }

            //if we get here the node wasnt found
            if (focusNode == null) {
                return null;
            }

        }
        return focusNode;
    }

    public Node deleteNode (int key) {
        Node nodeToDelete = findNode(key);

        //to be able to return it
        Node nodeRef = nodeToDelete;

        if (nodeToDelete.leftChild == null) {
            nodeToDelete = nodeToDelete.rightChild;
        } else {
            nodeToDelete = nodeToDelete.leftChild;
        }

        return nodeRef;
    }

}
