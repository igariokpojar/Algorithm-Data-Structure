package FindCycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        ListNode n1=new ListNode(3);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(0);
        ListNode n4=new ListNode(4);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n2;
        System.out.println(hasCycle(n1));
        System.out.println("--------------------------------------");
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = listNode.next;
        System.out.println(detectCycle(listNode).val);

    }
    public static boolean hasCycle(ListNode head) {
// create a HashSet for nodes
        HashSet<ListNode> visited = new HashSet<>();
        // set current to head
        ListNode current = head;
        while (current!=null){
            if (visited.contains(current))return true;
            visited.add(current);
            current=current.next;
        }
        return false;
    }

        public static ListNode detectCycle(ListNode head) {

            Set<ListNode> current = new HashSet<>();

            while(head != null) {
                if(current.contains(head)) {
                    return head;
                }
                current.add(head);
                head = head.next;
            }
            return null;
        }

    }
