package com.cydeo;

import lombok.Data;

@Data
public class PhoneBookNode {

    public Contact contact;
    public PhoneBookNode next;

    public PhoneBookNode(Contact contact) {
        this.contact = contact;
    }
}
