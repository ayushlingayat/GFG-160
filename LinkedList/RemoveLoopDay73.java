import java.util.HashSet;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveLoopDay73 {
    public static void removeLoop(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            if (set.contains(curr)) {
                prev.next = null; // Break the loop
                return;
            } else {
                set.add(curr);
            }

            prev = curr;
            curr = curr.next;
        }
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Creating a linked list with a loop
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a loop (5 -> 3)
        head.next.next.next.next.next = head.next.next;

        System.out.println("Loop detected, removing loop...");
        removeLoop(head);
        
        System.out.println("Linked List after loop removal:");
        printList(head);
    }
}
