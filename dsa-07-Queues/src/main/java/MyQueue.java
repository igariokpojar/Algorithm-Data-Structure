import java.util.NoSuchElementException;

public class MyQueue<T> { // Generic type of Q

    QNode<T> front;
    QNode<T> back;
    int size; // size of the Q
    boolean isEmpty(){return front==null;} // to understand if the Q is empty or not
    T peek() {
        return (T) front.value; // return the value of the front
    }
    void enqueue(T item){ // add item to the Q
        QNode<T> node = new QNode<>(item); // create a new Node
        // if the Q is empty
        if(isEmpty()) front=back=node;
        else {
            back.next=node;
            back=node;
        }
        size++; // increase the size
    }
    //
    T dequeue(){
        QNode frontNode;
        if(isEmpty()) throw new NoSuchElementException(); // if the Q is empty then trow an exception
        // for one element in queue
        if(front==back){ // if front is equal to back it means that we have only one element
            frontNode=front;
            front=back=null; // the assign nul to front and back
        } // now I have more than one element
        else{
            frontNode=front; // assign value to the front
            front=front.next; // the new front is equal to front.next
        }
        size--;
        return (T) frontNode.value;
    }
    int size(){return size;}

    void printQueue(){
        if (isEmpty()) return;
        QNode<T> current=front;
        while(current!=null) {
            System.out.print(current.value);
            if(current.next!=null) System.out.print(", ");
            current=current.next;
        }
    }

}
