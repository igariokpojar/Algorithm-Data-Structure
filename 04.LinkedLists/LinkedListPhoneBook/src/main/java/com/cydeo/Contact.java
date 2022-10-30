package com.cydeo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Data
@NoArgsConstructor

public class Contact {

    String firstName;
    String lastName;
    String email;
    String phoneNumber;

    //parameterized constructor
    public Contact(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public static void main(String[] args) {

        // Created the object of linked list.
        LinkedList<Contact> linkedList = new LinkedList<>();

        // insert data in linked list...
        linkedList.add(new Contact("Alexandru", "Pojar", "d@test.com", "1234567890"));
        linkedList.add(new Contact("Igariok", "Pojar", "m@text.com", "09870000021"));

        // for each loop used to iterate the records.
        System.out.println("*********** Display Information *****************");
        for (Contact phonebook : linkedList) {
            System.out.println(phonebook.getFirstName() + " " + phonebook.getLastName() + " " + phonebook.getEmail() + " " + phonebook.getPhoneNumber());


        }
    }
}
/*
Program Approach:



1- Create the class name as Phonebook.
2- Inside the class name define all the string data members as mentioned in the assignment.
3- Inside the class name define parametrized constructor. The constructor name same as the class name and it does not return any single value.
4- Define the getter and setter method for all the variables.
5- Inside the class name, define the java main method.
6- Inside the main method create the object of LinkedList.
7- add() method used to insert all the records in the linkedList.
8- for each loop used to iterate all the records from the linkedList.
 */
