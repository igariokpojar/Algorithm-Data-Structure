

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

       MySinglyLinkedList list = new MySinglyLinkedList();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(6);

        list.printNodes();
        list.removeDuplicates();
        list.printNodes();



    }
}
