// Raj Keswani
// April 8 2024
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        return search (root, val);
    }

    // Recursive search method
    public boolean search(BSTNode node, int val) {
        // Base case which is there is no node
        if (node == null) {
            return false;
        }
        // True if value matches
        if (val == node.getVal()) {
            return true;
        }

        // If the value is less than a node's value, it will go left
        if (val < node.getVal()) {
            return search(node.getLeft(), val);
        }

        // Otherwise it just goes right
        return search(node.getRight(), val);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> list = new ArrayList<>();
        getInOrder(list, root);
        return list;
    }

    // Recursive method for getting inorder
    public void getInOrder(ArrayList<BSTNode> list, BSTNode node) {
        // If no node, then the case is done
        if (node == null) {
            return;
        }
        // Gets farthest left for lowest value, then node, then rigth for greater values
        // Just lowest to biggest
        getInOrder(list, node.getLeft());
        list.add(node);
        getInOrder(list, node.getRight());
    }



    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> list = new ArrayList<>();
        getPreOrder(list, root);
        return list;
    }

    // Recursive method that gets preorder
    public void getPreOrder(ArrayList<BSTNode> list, BSTNode node) {
        if (node == null)
        {
            return;
        }

        // Starts with the node, then all to the left, and all to the right
        // Goes from top to bottom, left to right
        list.add(node);
        getPreOrder(list, node.getLeft());
        getPreOrder(list, node.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> list = new ArrayList<>();
        getPostOrder(list, root);
        return list;
    }

    // Recursive method for getting Postorder
    public void getPostOrder(ArrayList<BSTNode> list, BSTNode node) {
        if (node == null) {
            return;
        }

        // Goes from bottom to top, left to right
        // Gets values left of node, right of node, then node
        getPostOrder(list, node.getLeft());
        getPostOrder(list, node.getRight());
        list.add(node);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        insert(root, val);
    }

    // Recursive method for adding new nodes
    public BSTNode insert(BSTNode node, int val)
    {
        // Adds node when node is empty (base case)
        if (node == null)
        {
            return new BSTNode(val);
        }
        // Goes to left of node if value is less than node
        if (val < node.getVal())
        {
            node.setLeft(insert(node.getLeft(), val));
        }
        // Goes to right of node is value is higher than node
        if (val > node.getVal())
        {
            node.setRight(insert(node.getRight(), val));
        }

        return node;
    }



    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
