public class SumOfNodeDepths {

    // Binary tree node
    static class TreeNode
    {
        int data;
        TreeNode left, right;
    }

    // Function that allocates a new
// node with data and NULL to its
// left and right pointers
    static TreeNode newNode(int data)
    {
        TreeNode Node = new TreeNode();
        Node.data = data;
        Node.left = Node.right = null;
        return (Node);
    }

    // Function to find the sum of depths of
// all nodes in subtree of the current node
    static int sumOfDepth(TreeNode root, int d)
    {

        // If NULL node then return 0
        if (root == null)
            return 0;

        // Recursively find the sum of
        // depths of all nodes in the
        // left and right subtree
        return d + sumOfDepth(root.left, d + 1) +
                sumOfDepth(root.right, d + 1);
    }

    // Function to calculate the sum
// of depth of all the subtrees
    static int sumOfAllSubTrees(TreeNode root)
    {

        // If root is NULL return 0
        if (root == null)
            return 0;

        // Find the total depth sum of
        // current node and recursively
        return sumOfDepth(root, 0) +
                sumOfAllSubTrees(root.left) +
                sumOfAllSubTrees(root.right);
    }


    public static void main(String[] args)
    {

        // Given Tree
        TreeNode root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.left.left.left = newNode(8);
        root.left.left.right = newNode(9);

        // Function Call
        System.out.println(sumOfAllSubTrees(root));
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
 / \
 2 3
 / \ / \
 4 5 6 7
 / \
 8 9
Sample Output
16
// The depth of the node with value 2 is 1.
// The depth of the node with value 3 is 1.
// The depth of the node with value 4 is 2.
// The depth of the node with value 5 is 2.
// Etc
 */