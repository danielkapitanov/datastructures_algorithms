package main.java.binary_tree;

/**
 * Created by tanerali on 31/07/2017.
 */
public class BinaryTreeController {
    public static void main(String[] args) {

        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50,"Boss");
        theTree.addNode(25,"VP");
        theTree.addNode(15,"Office Manager");
        theTree.addNode(30,"Secretary");
        theTree.addNode(75,"Sales Manager");
        theTree.addNode(85,"Salesman 1");

        //different ways to traverse binary trees
        System.out.println("In order traverse");
        theTree.inOrderTraverse(theTree.root);
        System.out.println("--------");


        System.out.println("Preorder traverse");
        theTree.preorderTraverseTree(theTree.root);
        System.out.println("--------");


        System.out.println("Postorder traverse");
        theTree.postOrderTraverseTree(theTree.root);
        System.out.println("--------");


        // Find the node with key 75
        System.out.println("Node with the key 75");
        System.out.println(theTree.findNode(75));
        System.out.println("--------");


        System.out.println("Node 85 deletion");
        theTree.deleteNode(85);
        System.out.println("--------");


        System.out.println("In order traverse");
        theTree.inOrderTraverse(theTree.root);
        System.out.println("--------");

    }
}
