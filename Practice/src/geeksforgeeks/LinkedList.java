package geeksforgeeks;


public class LinkedList {

    /**
     * Finds the kth node from the end of the linked list.
     *
     * @param head The head of the linked list.
     * @param k    The position from the end (1-based index).
     * @return The value of the kth node from the end, or -1 if k is greater than the number of nodes.
     */
    public int getKthFromLast(Node head, int k) {
        if (head == null || k <= 0) {
            return -1; // Edge case: invalid input
        }

        Node fast = head;
        Node slow = head;

        // Move the fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return -1; // k is greater than the number of nodes
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Return the value of the kth node from the end
        return slow.data;
    }

    // Main method to test the getKthFromLast function with examples.
    public static void main(String[] args) {
        // Example 1: LinkedList = 1->2->3->4->5->6->7->8->9, k = 2
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = new Node(8);
        head1.next.next.next.next.next.next.next.next = new Node(9);

        LinkedList list = new LinkedList();
        int k1 = 2;
        System.out.println("Input: LinkedList = 1->2->3->4->5->6->7->8->9, k = " + k1);
        System.out.println("Output: " + list.getKthFromLast(head1, k1));
        System.out.println();

        // Example 2: LinkedList = 10->5->100->5, k = 5
        Node head2 = new Node(10);
        head2.next = new Node(5);
        head2.next.next = new Node(100);
        head2.next.next.next = new Node(5);

        int k2 = 5;
        System.out.println("Input: LinkedList = 10->5->100->5, k = " + k2);
        System.out.println("Output: " + list.getKthFromLast(head2, k2));
    }
}