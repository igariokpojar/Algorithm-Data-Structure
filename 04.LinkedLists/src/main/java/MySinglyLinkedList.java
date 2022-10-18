import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MySinglyLinkedList {
    Node head;
    Node tail;
    int size;

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(int data) {
        // create a new node object from data
        Node node = new Node(data);
        // case 1: list empty
        if (isEmpty()) {
            head = tail = node;
        } else {// case 2 : list is not empty
            node.next = head;
            head = node;
        }
        //increase size
        size++;
    }

    public int getKthItemFromLast(int k) {
        // create two pointers
        Node ptr1 = head;
        Node ptr2 = head;
        // move ptr2 k-1 times

        for (int i = 0; i < k - 1; i++) {
            ptr2 = ptr2.next;
        }
        // move both pointers until ptr2 hits the last element
        while (ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // ptr1 is on the kth element from the last
        return ptr1.id;
    }

    public void removeKthItemFromLast(int k) {
        // create three pointers
        Node ptr1 = head;
        Node ptr2 = head;
        Node prev = null;
        // move ptr2 k-1 times

        for (int i = 0; i < k - 1; i++) {
            ptr2 = ptr2.next;
        }
        // move both pointers until ptr2 hits the last element
        while (ptr2.next != null) {
            prev = ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // ptr1 is on the kth element from the last
        // Do delete operation
        if (ptr1 == head) {
            head = ptr1.next;
            ptr1.next = null;
            size--;
        } else if (ptr1 == tail) {
            tail = prev;
            prev.next = null;
            size--;
        } else {
            prev.next = ptr1.next;
            ptr1.next = null;
            size--;

        }
    }

    void add(int data) {
        // create a new node object from data
        Node node = new Node(data);

        if (isEmpty()) { // if the list is empty
            head = tail = node;
            size++;
        } else { // if there are elements in list
            tail.next = node;
            tail = node;
            size++;
        }

    }

    void deleteById(int id) {
        // check if empty
        if (isEmpty()) System.out.println("List is empty!!!");
        // assign prev and current with the head

        Node prev = head;
        Node current = head;
        while (current != null) {
            if (current.id == id) {// there is a match
                //case 1: head
                if (current == head) {
                    head = current.next;
                    current.next = null;
                }
                // case 2 : tail
                else if (current == tail) {
                    tail = prev;
                    prev.next = null;//Ex -Tail will be eligible for Garbage Collection
                }
                // case 3 : middle
                else {
                    prev.next = current.next;
                    current.next = null;// Current will be eligible for Garbage Collection
                }
                // after deletion
                size--;
            }
            // move forward on the elements of the list
            prev = current;
            current = current.next;

        }

    }

    int indexOf(int id) {
        if (isEmpty()) return -1;
        int pos = 0;
        // iterate through the list
        Node current = head;// set my current with the starting element;
        while (current != null) {
            if (current.id == id) return pos;
            pos++;
            current = current.next;
        }
        return -1;
    }

    void printNodes() {
        Node current = head;
        while (current != null) {
            if (current.next == null) System.out.println(current.id + "=> null");
            else {
                System.out.print(current.id + "=> ");
            }
            current = current.next;
        }
    }


    public void removeKthFromLast2(int k) {
        Node ptr1 = head;
        Node ptr2 = head;

        for (int i = 0; i < k - 1; i++) {

            ptr2 = ptr2.next;

            if (ptr2 == null) System.out.println("Less than k elements");

            else if (ptr2.next == null) {
                head = ptr1.next;
                ptr1.next = null;
                return;
            }
        }

        while (ptr2.next.next != null) {

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;

        }

        ptr1.next = ptr1.next.next;
        ptr1 = ptr1.next;
        ptr1 = null;


    }

    public void removeDuplicates() {
        if (isEmpty()) System.out.println("List is empty!");
        Node current = head;

        if (current == null) {
            return;
        }
        while (current != null && current.next != null) {
            if (current.id == current.next.id) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public boolean validPalindrome(String str) {

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(str.charAt(i)))
                i++;
            while (i < j && !Character.isLetterOrDigit(str.charAt(i)))
                j--;
            if (i < j && Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j)))
                return false;
        }
        return true;
    }

    public static void moveZeros(int[] num) {
        int n = num.length;
        if (n < 2) return;
        // define pointers
        int p1 = 0, p2 = 1;
        // move zeros to the back
        while (p2 < n) {
            if (num[p1] != 0) {
                p1++;
                p2++;

            } else if (num[p2] == 0) {
                p2++;
            } else {
                int temp = num[p2];
                num[p2] = num[p1];
                num[p1] = temp;

            }
        }
    }

    public void moveZero(int[] nums) {
        if (isEmpty()) System.out.println("List is empty");
        int n = nums.length;

        // defined pointers
        int p1 = 0;
        int p2 = 1;
        // move zero to the end
        while (p2 < n) {
            if (nums[p1] != 0) {
                p1++;
                p2++;

            } else if (nums[p2] == 0) {
                p2++;
            } else {
                int temp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = temp;

            }
        }
    }

    public static void moveZero(int arr[], int array_size) {
        int nonzero = 0;
        for (int i = 0; i < array_size; i++) {
            if (arr[i] != 0)
                arr[nonzero++] = arr[i];

        }
        while (nonzero < array_size) {
            arr[nonzero++] = 0;
        }
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return;
        }
        int p1 = 0, p2 = 0;
        int temp;
        while (p2 < n) {
            if (nums[p2] != 0) {
                temp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
            p2++;
        }
    }


//       public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        // if there are not intersection then return null
//        if(headA==null || headB==null) return null;
//
//        ListNode p1 = headA; //  the shorter list
//        ListNode p2 = headB;//  the longest list
//
//        while(p1!=p2){ // when the nods are not equal
//            if(p1==null){ // here we hit the end of the  shortest list
//                p1=headB; // set p1 to headB
//            }else{
//                p1=p1.next; // increment the pointer by 1
//            }
//            if(p2==null){ // here we hit the end of the longest list
//                p2=headA;
//            }else{
//                p2=p2.next;
//            }
//        }
//        return p1; //  or p2  -> on this pointer they will intersect
//    }
//
//}

    public int romanToInt(String s) {

        Map<Character,Integer> mold = new HashMap<>();

        mold.put('I',1);
        mold.put('V',5);
        mold.put('X',10);
        mold.put('L',50);
        mold.put('C',100);
        mold.put('D',500);
        mold.put('M',1000);

        int result = 0;
        for(int i = 0; i< s.length(); i++){
            int a = mold.get(s.charAt(i));
            int b;

            if(i+1 <s.length()){
                b=mold.get(s.charAt(i+1));
                if(a<b){
                    result+=(b-a);
                    i++;
                } else{
                    result+=a;
                }
            }else{
                result+=a;
            }
        }
        return result;
    }



    public int RomanToInt(String s) {

        if (s == null)
            return 0;

        int prev = getValue(s.charAt(0));
        int res = prev;

        for (int i = 1; i < s.length(); i++) {
            int cur = getValue(s.charAt(i));
            res += cur > prev ? cur - 2*prev : cur;
            prev = cur;
        }

        return res;
    }

    public int getValue(char c){
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int titleToNumber(String columnTitle) {

        char[] ch = columnTitle.toCharArray();

        int outcome = 0;

        for(int i = 0; i < ch.length; i++){
            int num = ch[i] - 65 + 1;
            outcome = outcome * 26 + num;
        }
        return outcome;
    }

    public int TitleToNumber(String columnTitle) {


        int result = 0;
        for(char ch : columnTitle.toCharArray()) {

            int n = ch - ('A' - 1);
            result = result * 26 + n;
        }
        return result;
    }
}
