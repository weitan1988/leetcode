/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ReverseLinkedList {
    /**
     * @param head
     * @return A linked list can be reversed either iteratively or recursively. Could you implement both?
     */
    public ListNode reverseListI(ListNode head) {
        // Iterative
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next.next;
            curr.next.next = prev.next;
            prev.next = curr.next;
            curr.next = temp;
        }
        return dummy.next;
    }

    public ListNode reverseListII(ListNode head) {
        // Recursive
        if (head == null || head.next == null) return head;
        ListNode restStart = head.next;
        head.next = null;
        ListNode restEnd = reverseListII(restStart);
        restStart.next = head;
        return restEnd;
    }
}