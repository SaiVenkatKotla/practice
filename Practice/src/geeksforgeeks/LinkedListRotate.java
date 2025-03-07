package geeksforgeeks;


public class LinkedListRotate {

    public Node rotate(Node head, int k) {
        int length = length(head);
        length = k % length;
        if (length == 0)
            return head;
        Node temp = head;
        while (length > 1) {
            temp = temp.next;
            length--;
        }
        Node head1 = temp.next;
        temp.next = null;
        temp = head1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return head1;
    }

    private int length(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // Helper method to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        LinkedListRotate list = new LinkedListRotate();
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        int k = 13;
        System.out.println("Original List:");
        list.printList(head);

        Node rotatedHead = list.rotate(head, k);
        System.out.println("Rotated List:");
        list.printList(rotatedHead);
    }
}

