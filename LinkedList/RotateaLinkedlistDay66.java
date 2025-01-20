class RotateaLinkedlistDay66 {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate the size of the linked list
        int size = 1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            size++;
        }

        // Make the linked list circular
        current.next = head;

        // Find the node where the rotation should end
        k = k % size;
        int stepsToNewHead = size - k;

        // Traverse to the new head
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Break the circular linked list to get the rotated list
        head = newTail.next;
        newTail.next = null;

        return head;
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        RotateaLinkedlistDay66 list = new RotateaLinkedlistDay66();

        // Creating a simple linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        list.printList(head);

        // Rotating the linked list by k positions
        int k = 2;
        head = list.rotate(head, k);

        System.out.println("Rotated Linked List:");
        list.printList(head);
    }
}
