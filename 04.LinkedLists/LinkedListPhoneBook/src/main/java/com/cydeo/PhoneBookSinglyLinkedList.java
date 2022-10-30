package com.cydeo;
import lombok.Data;
import java.util.*;



@Data
public class PhoneBookSinglyLinkedList {

    public PhoneBookNode head;
    public PhoneBookNode tail;
    public int size;

    Map<String, PhoneBookNode> nodes = new HashMap<>();

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        PhoneBookNode current = head;
        if (isEmpty()) return 0;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }


    public void printPhoneBook() {
        PhoneBookNode current = head;
        while (current != null) {
            System.out.println(current.contact);
            current = current.next;
        }
    }
//    public void printPhoneBook() {
//        PhoneBookNode current = head;
//        int element = 1;
//        while (current!=null){
//            System.out.println(element+ ". "+ current.contact);
//            current = current.next;
//            element++;
//        }
//    }


    public void addToContact(Contact contact) {

        PhoneBookNode phoneBookNode = new PhoneBookNode(contact);
        phoneBookNode.next = head;
        head = phoneBookNode;

        nodes.put(contact.getFirstName() + " " + contact.getLastName(), phoneBookNode);
    }
//    public void addToContact(Contact contact){
//        PhoneBookNode newNode = new PhoneBookNode(contact);
//            if (isEmpty()) {
//                head = tail = newNode;
//            } else{
//                tail.next = newNode;
//            tail = newNode;
//    }
//    size++;
//}


    public PhoneBookNode findByFirstName(String firstName) {
        PhoneBookNode current = head;
        while (current != null) {
            if (current.contact.getFirstName().equalsIgnoreCase(firstName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
//    public PhoneBookNode findByFirstName(String firstName){
//    if (isEmpty()){
//        throw new NoSuchElementException("No record is available in phone book");
// }
//    PhoneBookNode current = head;
//      while (current != null){
//    if (current.contact.firstName.equals(firstName)) {
//        return current;
//    }
//       current = current.next;
//    }
//       throw new NoSuchElementException("This first name " + firstName + " could not match with any records");
//}


    public List<PhoneBookNode> findAllByLastName(String LastName) {
        List<PhoneBookNode> ListOfLastNames = new ArrayList<>();
        PhoneBookNode current = head;
        while (current != null) {
            if (current.contact.getLastName().equalsIgnoreCase(LastName)) {
                ListOfLastNames.add(current);
            }
            current = current.next;
        }
        return ListOfLastNames;
    }
//    public List<PhoneBookNode> findAllByLastName(String lastName) {
//            if (isEmpty()) {
//                    throw new NoSuchElementException("No record is available in phone book");
//                }
//            List<PhoneBookNode> list = new ArrayList<>();
//            PhoneBookNode current = head;
//            while (current != null) {
//                if (current.contact.lastName.equals(lastName)) {
//                    list.add(current);
//                }        current = current.next;
//            }  if (list.isEmpty()) {
//                throw new NoSuchElementException("This last name " + lastName + " could not match with any records");
//            } return list;
//    }


    public void deleteByFirstName(String firstName) {
        PhoneBookNode previous = head;
        PhoneBookNode current = head;

        while (current != null) {
            if (current.contact.getFirstName().equalsIgnoreCase(firstName)) {
                previous.next = current.next;
            }
            previous = current;
            current = current.next;
        }
    }
//    public void deleteByFirstName(String firstName) {
//        if (isEmpty()) {
//            throw new NoSuchElementException("No record is available in phone book");
//        }  PhoneBookNode previous = head;
//        PhoneBookNode current = head;
//   while (current != null) {
//       if (current.contact.firstName.equals(firstName)) {
//           if (current == head) {
//               if (size == 1) {
//                   head = tail = null;
//               } else {
//                   head = current.next;
//               }
//           } else if (current == tail) {
//               tail = previous;
//               tail.next = null;
//           } else {
//               previous.next = current.next;
//           } size--;
//           return;
//       }  previous = current;
//       current = current.next;
//   }   throw new NoSuchElementException("This first name " + firstName + " could not match with any records");
//    }


    public void deleteAllMatchingLastName(String LastName) {
        PhoneBookNode previous = head;
        PhoneBookNode current = head;

        while (current != null) {
            if (current.contact.getLastName().equalsIgnoreCase(LastName)) {

                if (current == head) {
                    head = current.next;
                    current.next = null;
                    current = head;
                    previous = head;
                    continue;
                } else if (current == tail) {
                    tail = previous;
                    previous.next = null;

                }
                // case 3 : middle
                else {
                    previous.next = current.next;
                    current.next = null;
                    current = previous.next;
                    continue;

                }
            }
            // after deletion

            previous = current;
            current = current.next;
        }
    }
//    public void deleteAllMatchingLastName(String lastName) {
//        int startingSize = size();
//        if (isEmpty()) {
//            throw new NoSuchElementException("No record is available in phone book");
//        } PhoneBookNode previous = head;
//        PhoneBookNode current = head;
//        while (current != null) {
//            if (current.contact.lastName.equals(lastName)) {
//                if (current == head) {
//                    if (size == 1) {
//                        head = tail = null;
//                    } else {
//                        head = current.next;
//                    }
//                } else if (current == tail) {
//                    tail = previous;
//                    tail.next = null;
//                } else {
//                    previous.next = current.next;
//                    current = previous;
//                }size--;
//            } previous = current;
//            current = current.next;
//        } if (startingSize == size) {
//            throw new NoSuchElementException("This last name " + lastName + " could not match with any records");
//        }
//    }


    public List<PhoneBookNode> findAll() {
        List<PhoneBookNode> AllNames = new ArrayList<>();
        PhoneBookNode current = head;
        while (current != null) {
            AllNames.add(current);
            current = current.next;
        }
        return AllNames;
    }
}

//    public List<PhoneBookNode> findAll() {
//        if (isEmpty()) {
//            throw new NoSuchElementException("No record is available in phone book");
//        }
//        List<PhoneBookNode> list = new ArrayList<>();
//        PhoneBookNode current = head;
//        while (current != null) {
//            list.add(current);
//            current = current.next;
//        }
//        return list;
//    }
//}



/*
 Implement a phone book using a linked list structure. In this phone book , you are going to store a name,lastname,email,and phone number

Implement the following methods by using this class

public class PhoneBookSinglyLinkedList {

public PhoneBookNode head;

public PhoneBookNode tail; public int size;

public boolean isEmpty() {//todo implement this}

public int size() {//todo implement this}

public void printPhoneBook() {//todo implement this}

public void add(Contact contact) {//todo implement this}

public PhoneBookNode findByFirstName(String firstName) {//todo implement this}

public List findAllByLastName(String lastName) {//todo implement this}

public void deleteByFirstName(String firstName) {//todo implement this}

public void deleteAllMatchingLastName(String lastName) {//todo implement this}

public List findAll() {//todo implement this}
 */




