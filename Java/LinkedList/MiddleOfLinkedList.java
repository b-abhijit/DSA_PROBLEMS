// Given a linked list, find the middle node of the list. If there are 2 middle nodes, return the second one.

package LinkedList;

import LinkedList.utility.CreateLinkedList;
import LinkedList.utility.ListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode head = CreateLinkedList.createLinkedList();

        System.out.println("Middle value of linked list: " + getLinkedListMiddle(head));
    }

    static int getLinkedListMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }
}
