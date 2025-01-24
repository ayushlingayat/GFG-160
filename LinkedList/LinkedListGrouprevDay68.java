// import org.w3c.dom.Node;

class ListNode { // Defining a custom Node class
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListGrouprevDay68 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        // Code Here
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode nth = findNth(curr, k);
            if (nth == null) {
                ListNode rev = reverseList(curr);
                if (prev != null) prev.next = rev;
                else return rev;
                break;
            }
            ListNode nthNext = nth.next;
            nth.next = null;
            ListNode rhead = reverseList(curr);
            if (curr == head) head = rhead;
            else prev.next = rhead;
            prev = curr;
            curr = nthNext;
        }
        return head;
    }

    public static ListNode findNth(ListNode curr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (curr == null) return null;
            curr = curr.next;
        }
        return curr;
    }

    public static ListNode reverseList(ListNode curr) {
        ListNode prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {
        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("Original Linked List:");
        printList(head);

        int k = 3;
        head = reverseKGroup(head, k);

        System.out.println("Linked List after reversing in groups of " + k + ":");
        printList(head);
    }
}
