import java.util.Stack;

public class Queue_Using_Stacks {

    public static void main(String[] args) {

        Queue_Stack q = new Queue_Stack();
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.dequeue()); // prints 1
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.isEmpty()); // prints false
        q.enqueue(5);
        System.out.println(q.dequeue()); // prints 2
        q.enqueue(6);
        System.out.println(q.peek()); // prints 3

    }

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    //Pushes element num to the back of the queue
    public void enqueue(int num) {
        stack1.push(num);
    }


    //Returns true if the queue is empty, false otherwise.
    public boolean isEmpty() {
        return stack1.empty() && stack2.empty();

    }

    //Returns the element at the front of the queue without removing.
    public int peek() {
        if (stack2.empty())
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        return stack2.peek();

    }
    //Removes the element from the front of the queue and returns it.
    public int dequeue() {
        peek();
        return stack2.pop();
    }

}
/*
Implement a first in first out (FIFO) queue using only two
stacks (you can use Java Collections). The implemented
queue should support all the functions of a normal queue :
• void enqueue(int num) Pushes element num to the
back of the queue.
• int dequeue() Removes the element from the front of
the queue and returns it.
• int peek() Returns the element at the front of the
queue without removing.
• boolean empty() Returns true if the queue is empty,
false otherwise.
Note: You can use only standard operations of a stack,
which means only push to top, peek/pop from top, size,
and is empty operations are valid.
 */