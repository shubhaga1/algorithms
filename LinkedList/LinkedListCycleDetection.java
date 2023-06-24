class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycleDetection {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // Empty list or single node, no cycle
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle detected
    }

    public static void main(String[] args) {
        // Create a sample linked list with a cycle
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creates a cycle

        boolean hasCycle = hasCycle(head);
        System.out.println("Linked List has a cycle: " + hasCycle);
    }
}
