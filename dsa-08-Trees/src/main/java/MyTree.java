import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

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
        Queue<TNode>  queue=new LinkedList<>();
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
        printLeaves(root.rightChild);
        // Recursively Branch Right Subtree



    }




}
