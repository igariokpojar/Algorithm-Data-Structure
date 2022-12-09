
import java.util.Stack;

public class RangeSumOfBST {

    /*Given the root node of a binary search tree and two integers low and high, return the sum of values of all
nodes with a value in the inclusive range [low, high].
*/

    public static int rangeSumBTS(TNode root, int low, int high){

        int ans = 0;
        Stack<TNode> stack = new Stack<>();
        // let's push the root to the stack
        stack.push(root);
        while (!stack.isEmpty()) {
            TNode node = stack.pop();
            if (node != null) {
                if (low <= node.value && node.value <= high)
                    ans += node.value;
                // If current value is bigger than LOW -> Push Left_Child to Stack
                if (node.value > low)
                    stack.push(node.leftChild);
                // If current value is smaller than HIGH-> Push Right_Child to Stack
                if (node.value < high)
                    stack.push(node.rightChild);
            }
        }
        return ans;
    }
    // Recursive Solution

    private static int answer; // we need an Integer outside
    public static int recursive(TNode root, int low, int high){
        answer = 0;
        dfs(root, low,high);
        return answer;
    }
    public static void dfs(TNode node, int low, int high){
        if (node !=null){
            if (low <= node.value && node.value<=high)
                answer+=node.value;
            if (node.value>low) // We don’t need to look Left Children
            dfs(node.leftChild,low,high);
            if (node.value < high)// We don’t need to look Right Children
                dfs(node.rightChild,low,high);
            }
        }
    }
