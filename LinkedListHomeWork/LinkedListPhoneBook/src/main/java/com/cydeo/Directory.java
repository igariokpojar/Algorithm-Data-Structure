package com.cydeo;

public class Directory {

    Node head,tail;
    Directory(){

        head=null;
        tail=null;
    }
    // method that insert node into list if phone number is new
    public void insert(Node node){

        Node temp=head;
        while(temp!=null && !temp.phone_number.equals(node.phone_number))
            temp=temp.next;
        if(temp!=null){

            System.out.println("Entered phone number already exists");
            return;
        }
        if(head==null){

            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
        System.out.println("Inserted Successfully");
    }


    // method that removes node with given phone number
    public void remove(String ph_no)
    {
        Node prev=null;
        Node node=head;
        while(node!=null && !node.phone_number.equals(ph_no))
        {
            prev=node;
            node=node.next;
        }
        if(node==null)
            System.out.println("Phone number not found");
        else if(prev==null)
        {
            head=head.next;
            if(head==null)
                tail=null;
            System.out.println("Deleted Successfully");
        }else{

            prev.first_name=node.first_name;
            prev.last_name=node.last_name;
            prev.phone_number=node.phone_number;
            prev.email=node.email;
            prev.next=node.next;
            System.out.println("Deleted Successfully");

        }
    }
    // method that updates the phone number of person if exists
    public void update(String first_name,String phone_number)
    {
        boolean found=false;
        Node node=head;
        while(node!=null)
        {
            if(node.first_name.equals(first_name))
            {
                node.phone_number=phone_number;
                found=true;
            }
            node=node.next;
        }
        if(!found)
            System.out.println("No person found with given first name");
        else
            System.out.println("Updated Successfully");
    }

    // method that displays data in directory
    public void display()
    {
        if(head==null)
        {
            System.out.println("Empty directory");
            return;
        }
        System.out.println("People are as follows: ");
        Node node=head;
        while(node!=null)
        {
            System.out.println(node.toString());
            node=node.next;
        }
    }

    // method that searches for person with first name
    public void search(String first_name)
    {
        Node node=head;
        boolean found=false;
        while(node!=null)
        {
            if(node.first_name.equals(first_name))
            {
                System.out.println(node.toString());
                found=true;
            }
            node=node.next;
        }
        if(!found)
            System.out.println("No person found with given first name");
    }

    // sorts data in linked lists according to first name
    public void sort()
    {
        Node node1=head;
        while(node1!=null)
        {
            Node node2=node1.next;
            while(node2!=null)
            {
                if(node1.first_name.compareTo(node2.first_name)>0){

                    swap(node1,node2);
                }
                node2=node2.next;
            }
            node1=node1.next;
        }
        System.out.println("Sorted Successfully");
    }

    public void swap(Node n1,Node n2){

        String temp="";

        temp=n1.first_name;
        n1.first_name=n2.first_name;
        n2.first_name=temp;

        temp=n1.last_name;
        n1.last_name=n2.last_name;
        n2.last_name=temp;

        temp=n1.phone_number;
        n1.phone_number=n2.phone_number;
        n2.phone_number=temp;

        temp=n1.email;
        n1.email=n2.email;
        n2.email=temp;
    }
}




