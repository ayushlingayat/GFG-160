class Node { // Defining the Node class
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddNumLinkedListDay69 {
    
    // Function to reverse a linked list
    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

    // Function to add two numbers represented as linked lists
    static Node addTwoLists(Node num1, Node num2) {
        int carry = 0;
        
        Node rev1 = reverse(num1);
        Node rev2 = reverse(num2);
        
        Node head = null;
        Node tail = null;
        
        while (rev1 != null || rev2 != null || carry != 0) {
            int val1 = (rev1 != null) ? rev1.data : 0;
            int val2 = (rev2 != null) ? rev2.data : 0;
            
            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            
            Node temp = new Node(digit);
            
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            
            if (rev1 != null) rev1 = rev1.next;
            if (rev2 != null) rev2 = rev2.next;
        }
        
        Node result = reverse(head);

        // Removing leading zeros
        while (result != null && result.data == 0) {
            result = result.next;
        }

        return (result != null) ? result : new Node(0); // Return at least one zero if all are removed
    }

    // Function to print a linked list
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Number 1: 617 (6 -> 1 -> 7)
        Node num1 = new Node(6);
        num1.next = new Node(1);
        num1.next.next = new Node(7);

        // Number 2: 295 (2 -> 9 -> 5)
        Node num2 = new Node(2);
        num2.next = new Node(9);
        num2.next.next = new Node(5);

        System.out.println("First Number:");
        printList(num1);
        System.out.println("Second Number:");
        printList(num2);

        Node result = addTwoLists(num1, num2);

        System.out.println("Sum of the Two Numbers:");
        printList(result);
    }
}
