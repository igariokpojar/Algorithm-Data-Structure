package main.java;

public class SinglyLinkedListApp {
    public static void main(String[] args) {
        MySinglyLinkedList mylist=new MySinglyLinkedList();
        System.out.println(mylist.isEmpty());

        for (int i = 0; i < 10; i++) {
            mylist.add(i);
        }
        mylist.deleteById(9);
        mylist.printNodes();
        mylist.add(1);
        mylist.printNodes();
        mylist.addFirst(0);
        mylist.printNodes();
        System.out.println("index of 3 : "+ mylist.indexOf(3));

    }
}
