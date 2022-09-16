

import java.util.ArrayList;

public class SinglyLinkedListApp {

    public static void main(String[] args) {
        MySinglyLinkedList mylist=new MySinglyLinkedList();

        for (int i = 0; i < 10; i++) {
            mylist.add(i);
        }
        mylist.printNodes();
        System.out.println("kth item from the last : "+ mylist.getKthItemFromLast(3));
        mylist.removeKthItemFromLast(1);
        mylist.printNodes();

    }
}
