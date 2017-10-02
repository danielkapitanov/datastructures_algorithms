package main.java.binary_tree;

/**
 * Created by tanerali on 31/07/2017.
 */
public class BinaryTree {

    //the root node where it all starts; it will have a
    //left child and a right child
    Node root;

    public void addNode(int key, String name){

        //create a new node and initialize it
        Node newNode = new Node(key, name);

        //if there is no root this becomes root
        if (root == null) {
            root = newNode;

        //else the newly created node will have to traverse
        //the tree to find its right place corresponding to its key
        } else {

            //set root as the node we will start at
            //as we start traversing the tree
            Node focusNode = root;

            //future parent for our new Node
            Node parent;

            //infinite loop
            while (true){

                //root is the top parent so we start there
                parent = focusNode;

                //check if the new node should go on the left or right side
                if (key < focusNode.key) {

                    //switch focus to the left child
                    focusNode = focusNode.leftChild;

                    //if the left child has no children
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


    //all nodes are visited in ascending order (will print out all values in binary tree
    //sorted) recursion is used to go to one node and then go to its
    //child nodes and so forth
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


    //first prints out the focusNode, then the left child
    //and then the right child
    public void preorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }
    }


    //first prints out the left child, then the right child
    //and then the focusNode
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

            //if they key of the node we're looking for is smaller than the current
            //focusNode key, shift focusNode to the left child
            if (key < focusNode.key){
                //shift the focus node to the left child
                focusNode = focusNode.leftChild;

            //if they key of the node we're looking for is larger than the current
            //focusNode key, shift focusNode to the right child
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

        //in case the nodeToDelete has neither left or right child,
        //it will simply become null
        if (nodeToDelete.leftChild == null) {
            nodeToDelete = nodeToDelete.rightChild;

        } else {
            nodeToDelete = nodeToDelete.leftChild;
        }

        return nodeRef;
    }

}
