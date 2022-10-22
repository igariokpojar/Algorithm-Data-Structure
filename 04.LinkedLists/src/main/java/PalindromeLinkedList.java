import MergeTwoSortedLL.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public boolean IsPalindrome(ListNode head) {

        ListNode fast = head, slow=head;

        Stack<Integer> stk = new Stack<>();
        stk.push(slow.val);
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            stk.push(slow.val);
        }
        stk.pop();
        if(fast!=null)
            slow=slow.next;
        while(!stk.isEmpty()){
            if(stk.pop()!=slow.val)
                return false;
            slow=slow.next;
        }
        return true;
    }

        public boolean Palindrome(ListNode head) {

            Deque<Integer> stack = new LinkedList<>();
            ListNode current = head;
            while (current != null) {
                stack.push(current.val);
                current = current.next;
            }    current = head;
            while (current != null) {
                if (current.val != stack.pop())
                    return false;
                current = current.next;
            }
            return true;
    }

}

