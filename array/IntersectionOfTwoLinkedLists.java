/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class InterSectionOfTwoLinkedList {
    /**
     * @param headA
     * @param headB
     * @return Write a program to find the node at which the intersection of two singly linked lists begins.
     * Notes:
     * If the two linked lists have no intersection at all, return null.
     * The linked lists must retain their original structure after the function returns.
     * You may assume there are no cycles anywhere in the entire linked structure.
     * Your code should preferably run in O(n) time and use only O(1) memory.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode nodeA = headA, nodeB = headB;
        while(nodeA.next != null) {
            lenA++;
            nodeA = nodeA.next;
        }
        while(nodeB.next != null) {
            lenB++;
            nodeB = nodeB.next;
        }

    }
}