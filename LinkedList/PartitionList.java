/*
The input linked list is 1 -> 4 -> 3 -> 2 -> 5 -> 2. After partitioning around x = 3, the resulting linked list becomes 1 -> 2 -> 2 -> 3 -> 4 -> 5, 
where all values less than x (3 in this case) are on the left side and all values greater than or equal to x are on the right side.
*/
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode leftDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);
        ListNode leftTail = leftDummy;
        ListNode rightTail = rightDummy;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }

        rightTail.next = null;
        leftTail.next = rightDummy.next;

        return leftDummy.next;
    }

    public static void main(String[] args) {
        // Create the input linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        // Create an instance of PartitionList class
        PartitionList partitionList = new PartitionList();

        // Perform partitioning
        ListNode result = partitionList.partition(head, 3);

        // Print the partitioned list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
