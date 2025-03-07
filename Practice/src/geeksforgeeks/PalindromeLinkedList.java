package geeksforgeeks;


public class PalindromeLinkedList {

    /**
     * Method to check if a linked list is a palindrome.
     *
     * @param head The head of the linked list.
     * @return true if the linked list is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(Node head) {
        if (head != null && head.next == null)
            return true;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverseALinkedList(slow);
        Node firstHalf = head;
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true; // Placeholder return value
    }

    private static Node reverseALinkedList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Helper method to create a linked list from an array
    private static Node createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Main method to test the implementation with examples
    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {1, 2, 1, 1, 2, 1};
        Node head1 = createLinkedList(arr1);
        boolean result1 = isPalindrome(head1);
        System.out.println("Example 1: " + result1); // Expected output: true

        // Example 2
        int[] arr2 = {1, 2, 3, 4};
        Node head2 = createLinkedList(arr2);
        boolean result2 = isPalindrome(head2);
        System.out.println("Example 2: " + result2); // Expected output: false

        // Example 3
        int[] arr3 = {1, 2, 2, 1};
        Node head3 = createLinkedList(arr3);
        boolean result3 = isPalindrome(head3);
        System.out.println("Example 3: " + result3); // Expected output: true

        // Example 4
        int[] arr4 = {1};
        Node head4 = createLinkedList(arr4);
        boolean result4 = isPalindrome(head4);
        System.out.println("Example 4: " + result4); // Expected output: true
    }
}