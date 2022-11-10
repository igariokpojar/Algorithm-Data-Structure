import java.util.Stack;

public class Queue_Stack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void enqueue(int num) {
        stack1.push(num);
    }
    public int dequeue() {
        peek();
        return stack2.pop();
    }
    public int peek() {
        if (stack2.empty())
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        return stack2.peek();
    }
    public boolean isEmpty() {
        return stack1.empty() && stack2.empty();
    }
}
