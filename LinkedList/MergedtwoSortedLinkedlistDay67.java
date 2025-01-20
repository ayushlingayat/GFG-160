public class MergedtwoSortedLinkedlistDay67 {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node sortedMerge(Node head1, Node head2) {
        Node head = new Node(-1), cur = head;
        Node cur1 = head1, cur2 = head2;

        // Merge two sorted linked lists
        while (cur1 != null && cur2 != null) {
            if (cur1.data < cur2.data) {
                cur.next = new Node(cur1.data); 
                cur1 = cur1.next;
            } else {
                cur.next = new Node(cur2.data);
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        // Append the remaining nodes of the list that is not yet finished
        if (cur1 != null) cur.next = cur1;
        if (cur2 != null) cur.next = cur2;

        return head.next;
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
        MergedtwoSortedLinkedlistDay67 list = new MergedtwoSortedLinkedlistDay67();

        // Creating first sorted linked list: 1 -> 3 -> 5
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        // Creating second sorted linked list: 2 -> 4 -> 6
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);

        System.out.println("First Sorted Linked List:");
        list.printList(head1);

        System.out.println("Second Sorted Linked List:");
        list.printList(head2);

        // Merging the two sorted linked lists
        Node mergedHead = list.sortedMerge(head1, head2);

        System.out.println("Merged Sorted Linked List:");
        list.printList(mergedHead);
    }
}
