/*
To find the node where the cycle starts, we follow these steps:
After detecting a cycle using the Floyd's cycle detection algorithm, we keep the fast pointer at the node where the slow and fast pointers met. Let's call this node meetingPoint.
We reset the slow pointer back to the head of the linked list.
We move both the slow and fast pointers at the same pace, one step at a time, until they meet again.
The node at which they meet again is the starting node of the cycle.
*/

// Floyd's cycle detection algorithm

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class FirstNodeCycleDetection {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // Empty list or single node, no cycle
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null; // No cycle detected
        }

        slow = head; // Reset slow pointer to head

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // Return the node where the cycle is detected
    }

    public static void main(String[] args) {
        // Create a sample linked list with a cycle
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creates a cycle

        ListNode cycleNode = detectCycle(head);

        if (cycleNode != null) {
            System.out.println("Cycle detected at node with value: " + cycleNode.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}
