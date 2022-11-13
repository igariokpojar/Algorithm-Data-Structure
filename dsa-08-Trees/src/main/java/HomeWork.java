import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class HomeWork {

    public static void main(String[] args) {


    }
    LinkedList<Integer> list = new LinkedList<>();
    public List<Integer> inorderTraversal(TNode root) {
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
}

