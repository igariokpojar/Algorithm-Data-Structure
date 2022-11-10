import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS {

    TNode root;

    public BFS_DFS() {

    }

    void insertNode(int value) {
        TNode node = new TNode(value);
        if (root == null) {
            root = node;
            return;
        }
        TNode current = root; // traversing the tree
        while (true) {
            if (value <= current.value) { // comparing the value of the nodes

                if (current.leftChild == null) {
                    // if left is null insert there!!!
                    current.leftChild = node;
                    break;
                }
                //if leftChild is not null branch into left subtree!!
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    // if right is null insert there!!!
                    current.rightChild = node;
                    break;
                }
                //if rightChild is not null branch into right subtree!!
                current = current.rightChild;

            }
        }
    }
        void breathFirstTraversal () { // Called Breadth First(Level Order)
            if (root == null) return;
            Queue<TNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TNode toVisit = queue.poll();
                System.out.print(toVisit.value + ", ");
                // if you have n number of children
                if (toVisit.leftChild != null) queue.add(toVisit.leftChild);
                if (toVisit.rightChild != null) queue.add(toVisit.rightChild);

            }
        }
    }




