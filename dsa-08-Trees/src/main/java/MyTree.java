import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.util.*;

public class MyTree {
    TNode root;

    public MyTree() {
    }
    void insert(int value){
        TNode newNode = new TNode(value); // create a new Tree Node from scratch
        if (root==null) {
            root=newNode;
            return;
        }
        TNode current =root; // traversing the tree
        while(true){
            if (value<= current.value){ // comparing the value of the nodes

                if (current.leftChild==null){
                    // if left is null insert there!!!
                    current.leftChild=newNode;
                    break;
                }
                //if leftChild is not null branch into left subtree!!
                current=current.leftChild;
            }
            else {
                if (current.rightChild==null){
                    // if right is null insert there!!!
                    current.rightChild=newNode;
                    break;
                }
                //if rightChild is not null branch into right subtree!!
                current=current.rightChild;
            }
        }
    }
    // PreOrder Traversal of the tree
    // Root-Left-right
    void preOrderTraversal(TNode root){
        if(root==null) return; // if is null means' that we don't have nodes on tree
        System.out.print(root.value +", "); // visit root
        preOrderTraversal(root.leftChild); // visit left subtree
        preOrderTraversal(root.rightChild); // visit right subtree
    }

    void inOrderTraversal(TNode root){
        if (root==null) return; // termination
        inOrderTraversal(root.leftChild); //
        System.out.print(root.value+", ");
        inOrderTraversal(root.rightChild);
    }

    void postOrderTraversal(TNode root){
        if (root==null) return; // termination
        postOrderTraversal(root.leftChild); // branch and finish left subtree
        postOrderTraversal(root.rightChild); // branch and finish right subtree
        System.out.print(root.value+", "); // visit root
    }

    void levelOrderTraversal(){ // Called Breadth First(Level Order)
        if(root==null) return;
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TNode toVisit=queue.poll();
            System.out.print(toVisit.value+", ");
            // if you have n number of children
            if (toVisit.leftChild!=null) queue.add(toVisit.leftChild);
            if (toVisit.rightChild!=null) queue.add(toVisit.rightChild);

        }
    }

    // TAsk 1: implement finding an integer value in a BST(Binary Search Tree)
    public boolean contains(int value) {
        if (root == null) return false;
        TNode current = root;

        while (current != null) {
            if (value < current.value) current = current.leftChild;
            else if (value > current.value) current = current.rightChild;
           else return true;

        }
        return false;
    }


// Task 2: Implement a method that returns true if the node is a leaf in a BST
    public boolean isLeaf(TNode node){

        return node.leftChild==null && node.rightChild==null;
    }


// Task 3: Implement a method that prints leaves on a BTS
    public void printLeaves(TNode root){
        if (root==null)return;
        // perform visit on Root
        if (isLeaf(root)) System.out.print(root.value + ", ");

            // Recursively Branch Left Subtree
        printLeaves(root.leftChild);

        // Recursively Branch Right Subtree
        printLeaves(root.rightChild);
    }

// Task 4: Implement a method that counts Leafs of a BST
    int countLeaves(TNode root){
     if (root==null)return 0;
     if (isLeaf(root)) return 1;
     // recursively left
     // recursively right
     return countLeaves(root.leftChild)+countLeaves(root.rightChild);
    }

    //Task 5: Implement a method that returns sum of leafs value of a BST
    int findSumOfLeaves(TNode root) {
        if (root == null) return 0;
        if (isLeaf(root)) return root.value; // we return the value of the leaves

        return findSumOfLeaves(root.leftChild) + findSumOfLeaves(root.rightChild);

    }
    // TAsk 6: Implement a method that returns height of a Tree in a BST
    int height(TNode root){
        if (root==null)return -1;
        if (isLeaf(root))return 0;
        return 1+Math.max(height(root.leftChild),(height(root.rightChild)));
    }

    // to store the value of roots create a bucket
    LinkedList<Integer> list = new LinkedList<>();

    public  List<Integer> inorderTraversal(TNode root) {
        if (root != null) {
            inorderTraversal(root.leftChild);
            list.add(root.value);
            inorderTraversal(root.rightChild);
        }
        return list;
    }
    public List<Integer> InorderTraversal(TNode root) {
        List<Integer> res = new ArrayList<>();
        // method 2: iteration
        Stack<TNode> stack = new Stack<>();
        TNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current!= null) {
                stack.push(current);
                current =current.leftChild;
            }
            current = stack.pop();
            res.add(current.value);
            current = current.rightChild;
        }
        return res;
    }

    public int calculateNodeDepthSums() { // instantiate the root to 0
        return nodeDepthSums(root, 0);
    }
    // Assignment  Sum of Node Depths
    public int nodeDepthSums(TNode node, int A){
        if(node==null) return 0; // if note is null the return 0
        System.out.println(A);
        return A+nodeDepthSums(node.leftChild, A+1) +nodeDepthSums(node.rightChild, A+1);
    }

    // Assignment  Sum of All Nodes
    public int calculateNodeSums(){
        return nodeSums(root, root.value);
    }
    // Assignment  Sum of Node Depths
    public int nodeSums(TNode node, int sum) {
        if (node == null) return 0;
        return sum + nodeSums(node.leftChild, node.value) + nodeSums(node.rightChild, node.value);
    }


}
    /*
    Sum of Node Depths
The distance between a node in a Binary Tree and the tree's root is called the node's depth. Write a
function that takes in a Binary Tree and returns the sum of its nodes' depths. Each BinaryTree node has an
integer value , a left child node, and a right child node. Children nodes can either be BinaryTree nodes
themselves or None / null .
Sample Input
Tree. =
           1
         /   \
        2     3
       / \   / \
      4   5 6   7
     / \
    8   9
Sample Output
16
// The depth of the node with value 2 is 1.
// The depth of the node with value 3 is 1.
// The depth of the node with value 4 is 2.
// The depth of the node with value 5 is 2.
// Etc..
// Summing all of these depths yields 16
     */




