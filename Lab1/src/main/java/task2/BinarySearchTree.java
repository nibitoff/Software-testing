package main.java.task2;

public class BinarySearchTree {

    // node class
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    private Node insertRec(Node root, int key) {
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        else if (key > root.key)
            root.left = insertRec(root.left, key);
        else if (key < root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer, because key matches */
        return root;
    }

    public void insert(int key) {
        root = insertRec(this.root, key);
    }

    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public int minvalue() {
        return minValue(this.root);
    }

    private int maxValue(Node root) {
        int maxv = root.key;
        while (root.right != null) {
            maxv = root.right.key;
            root = root.right;
        }
        return maxv;
    }

    public int maxvalue() {
        return maxValue(this.root);
    }

        /* A recursive function to delete an existing key in BST */
    private Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

            // if key is matches the root's key, then
            // This is the node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    public void deleteKey(int key) {
        root = deleteRec(this.root, key);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    private boolean hasValue(Node root, int key){
        if (root == null)
            return false;

        if (key < root.key)
            return hasValue(root.left, key);
        else if (key > root.key)
            return hasValue(root.right, key);
        else return false;
    }

    public boolean hasvalue(int key){
        return hasValue(root, key);
    }

    public void inorder() {
        inorderRec(this.root);
    }

    private int rec(Node root, int n){
        if (root != null) {
            n = rec(root.left, n);
            n = rec(root.right, n);
        } else n += 1;
        return n;
    }

    public int getSz(){
        return rec(root, 0) - 1;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        /* Let us create following BST
              50
            /	\
           30  70
          / \ / \
        20 40 60 80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println(tree.getSz());

        tree.inorder();
        System.out.println("smallest is " + tree.minvalue());
        System.out.println("biggest is " + tree.maxvalue());

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println(tree.getSz());
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();
        System.out.println("smallest is " + tree.minvalue());
        System.out.println("biggest is " + tree.maxvalue());

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();
        System.out.println("smallest is " + tree.minvalue());
        System.out.println("biggest is " + tree.maxvalue());

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();
        System.out.println("smallest is " + tree.minvalue());
        System.out.println("biggest is " + tree.maxvalue());
        System.out.println(tree.hasvalue( 100));
        System.out.println(tree.hasvalue( 30));
        System.out.println(tree.hasvalue( 400));
        System.out.println(tree.hasvalue( 80));

    }
}

