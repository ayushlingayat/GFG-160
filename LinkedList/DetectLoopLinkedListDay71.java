// Node class definition
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DetectLoopLinkedListDay71 {

    // Function to detect loop using Floyd's Cycle Detection Algorithm
    public static boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    // Function to create a loop in the linked list (for testing)
    public static void createLoop(Node head, int position) {
        if (head == null || position == 0) return;
        
        Node temp = head;
        Node loopNode = null;
        int count = 1;

        while (temp.next != null) {
            if (count == position) {
                loopNode = temp;
            }
            temp = temp.next;
            count++;
        }
        temp.next = loopNode; // Creating the loop
    }

    // Function to print the linked list (used when there is no loop)
    public static void printList(Node head) {
        Node temp = head;
        int count = 0; // Limit to prevent infinite loop in case of cycle
        while (temp != null && count < 20) { // Avoid infinite loops
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            count++;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Print the linked list before loop creation
        System.out.println("Original Linked List:");
        printList(head);

        // Create a loop at position 2 (1-based index)
        createLoop(head, 2);

        // Detect loop in the linked list
        if (detectLoop(head)) {
            System.out.println("Loop detected in the linked list!");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
