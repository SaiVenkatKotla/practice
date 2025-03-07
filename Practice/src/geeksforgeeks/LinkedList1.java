package geeksforgeeks;

class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList1 {

    /**
     * Removes a loop in the linked list, if present.
     *
     * @param head the head of the linked list
     */
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head, fast = head;

        // Detect if a loop exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break; // Loop detected
            }
        }

        // If no loop exists, return
        if (slow != fast) return;

        // Find the start of the loop
        slow = head;

        // Special case: if the loop starts at the head
        if (fast == head) {
            while (fast.next != head) {
                fast = fast.next;
            }
        } else {
            // Otherwise, move both pointers one step at a time until they meet
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Remove the loop
        fast.next = null;
    }

    /**
     * Helper method to create a loop in the linked list.
     *
     * @param head the head of the linked list
     * @param pos  position (1-based) where the loop starts, 0 if no loop
     */
    public static void createLoop(Node head, int pos) {
        if (pos == 0) return;

        Node loopStartNodes = null;
        Node temp = head;
        int counter = 1;

        while (temp.next != null) {
            if (counter == pos) {
                loopStartNodes = temp;
            }
            temp = temp.next;
            counter++;
        }

        // Create the loop
        temp.next = loopStartNodes;
    }

    /**
     * Helper method to check if the loop is removed.
     *
     * @param head the head of the linked list
     * @return true if no loop is present, false otherwise
     */
    public static boolean isLoopRemoved(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return false; // Loop is still present
            }
        }
        return true; // No loop
    }

    public static void main(String[] args) {
        // Example 1
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(4);
        createLoop(head1, 2);
        removeLoop(head1);
        System.out.println(isLoopRemoved(head1)); // Expected Output: true

        // Example 2
        Node head2 = new Node(1);
        head2.next = new Node(8);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        createLoop(head2, 0);
        removeLoop(head2);
        System.out.println(isLoopRemoved(head2)); // Expected Output: true

        // Example 3
        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(3);
        head3.next.next.next = new Node(4);
        createLoop(head3, 1);
        removeLoop(head3);
        System.out.println(isLoopRemoved(head3)); // Expected Output: true

        int[] values = {16, 16, 10, 12, 9, 9, 14, 17, 12, 7, 18, 8, 16, 8, 9, 8, 11, 8, 2, 18, 2, 18};
        int pos = 6; // 1-based index

        // Create the linked list
        Node head = createLinkedList(values);

        // Create the loop
        createLoop(head, pos);

        // Remove the loop
        removeLoop(head);

        // Verify if the loop is removed
        System.out.println(isLoopRemoved(head)); // Expected Output: true

    }

    /**
     * Creates a linked list from the given array of integers.
     *
     * @param values array of integers to populate the linked list
     * @return head of the created linked list
     */
    public static Node createLinkedList(int[] values) {
        if (values.length == 0) return null;

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        return head;
    }

}

