package com.cydeo;

import lombok.Data;

@Data
public class Node {

    String first_name,last_name,phone_number,email;
    Node next=null;

    Node(String first_name,String last_name,String phone_number,String email){

        this.first_name=first_name;
        this.last_name=last_name;
        this.phone_number=phone_number;
        this.email=email;
    }
}



