import MergeTwoSortedLL.ListNode;

public class ReversLinkedList {

    class Solution {

        public ListNode reverseList(ListNode head) {

            ListNode prev = null;

            while (head != null) {
                ListNode next_node = head.next;
                head.next = prev;
                prev = head;
                head = next_node;
            }
            return prev;

        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // create ListNode prev and initialize to null
        ListNode current = head; // create ListNode current and initialize to head(which contains address of first node)


        while(current != null) { // travers from current(head) to node(which contains null)
            ListNode next = current.next;// create ListNode next and assign to next ListNode
            current.next = prev; // current.next to prev(which is initially null)
            prev = current; // update the previous node everytime, while traversing
            current = next; // update current to next, while traversing
        }
        return prev;
    }
}




