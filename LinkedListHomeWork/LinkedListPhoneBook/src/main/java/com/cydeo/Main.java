package com.cydeo;
import java.util.*;
public class Main {

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        Directory dr = new Directory();
        while(true){

            // print the menu
            System.out.println("1 ---> Add person details into the telephone book.");
            System.out.println("2 ---> Remove a person from the telephone book.");
            System.out.println("3 ---> Update a telephone number by providing person first name.");
            System.out.println("4 ---> Display the entire telephone book.");
            System.out.println("5 ---> Search a telephone number based on person first name.");
            System.out.println("6 ---> Sort the entire telephone book.");
            System.out.println("7 ---> Exit the program.");

            // take option as input
            System.out.print("Enter your option: ");
            int choice=scan.nextInt();
            switch(choice) {

                case 1:
                    System.out.print("Enter first name: ");
                    String first_name=scan.next();
                    System.out.print("Enter last name: ");
                    String last_name=scan.next();
                    System.out.print("Enter phone number: ");
                    String phone_number=scan.next();
                    System.out.print("Enter email: ");
                    String email=scan.next();
                    Node node=new Node(first_name,last_name,phone_number,email);
                    dr.insert(node);
                    break;
                case 2:
                    System.out.print("Enter phone number: ");
                    String ph_no=scan.next();
                    dr.remove(ph_no);
                    break;
                case 3:
                    System.out.print("Enter first name: ");
                    String f_n=scan.next();
                    System.out.print("Enter updated phone number: ");
                    String ph_number=scan.next();
                    dr.update(f_n,ph_number);
                    break;
                case 4:
                    dr.display();
                    break;
                case 5:
                    System.out.print("Enter first name to search: ");
                    String f_name=scan.next();
                    dr.search(f_name);
                    break;
                case 6:
                    dr.sort();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }
    }
}

