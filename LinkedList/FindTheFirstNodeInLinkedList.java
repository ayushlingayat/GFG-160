class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindTheFirstNodeInLinkedList {
    public static Node findFirstNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Cycle detected
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Returning the first node of the loop
            }
        }
        return null; // No loop found
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

        Node loopNode = findFirstNode(head);
        if (loopNode != null) {
            System.out.println("The first node in the loop is: " + loopNode.data);
        } else {
            System.out.println("No loop detected.");
        }
    }
}
