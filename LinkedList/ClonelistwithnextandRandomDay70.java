// Node class definition
class Node {
    int data;
    Node next, random;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

public class ClonelistwithnextandRandomDay70 {

    public Node cloneLinkedList(Node head) {
        // Step 1: Insert new nodes after each original node
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            Node nn = new Node(curr.data);
            nn.next = curr.next;
            curr.next = nn;
            curr = nn.next;
        }

        // Step 2: Copy random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // Step 3: Separate original and cloned lists
        curr = head;
        Node chead = head.next;
        Node clone = chead;
        while (clone.next != null) {
            curr.next = curr.next.next;
            clone.next = clone.next.next;
            curr = curr.next;
            clone = clone.next;
        }
        curr.next = null;
        clone.next = null;
        
        return chead;
    }

    // Function to print a linked list (including random pointers)
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomData = (temp.random != null) ? temp.random.data : -1;
            System.out.println("Node: " + temp.data + ", Random: " + randomData);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a test case for the linked list with next and random pointers
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Assigning random pointers
        head.random = head.next.next;       // 1 -> 3
        head.next.random = head;            // 2 -> 1
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = head.next; // 5 -> 2

        System.out.println("Original List:");
        printList(head);

        ClonelistwithnextandRandomDay70 obj = new ClonelistwithnextandRandomDay70();
        Node clonedHead = obj.cloneLinkedList(head);

        System.out.println("Cloned List:");
        printList(clonedHead);
    }
}
