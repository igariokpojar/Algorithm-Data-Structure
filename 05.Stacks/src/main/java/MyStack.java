import org.w3c.dom.Node;

import java.util.NoSuchElementException;

public class MyStack<T> {

    public StackNode<T> bottom;
    public StackNode<T> top;
    int size;
    public boolean isEmpty(){
        return bottom==null;
    }
    public void push(T item){ // insertion operation to the List
        StackNode<T> node = new StackNode<>(item);
        if (isEmpty()) bottom=top=node;
        else {
            top.next=node;
            top=node;
        }
        size++;
    }
    public  T peek(){
        return (T) top.value;

    }
    public T pop(){
        StackNode peekNode;
        if (isEmpty()) throw new NoSuchElementException();
        // stack has one element
        if (top==bottom){
            peekNode=top;
            top=bottom=null;
        }else { // more than one element
            peekNode = top;
            StackNode prev=bottom;
            while (prev.next !=top){
                prev=prev.next;
            }
            prev.next=null;
            top=prev;
        }
        size--;
        return (T) peekNode.value;
    }
}
