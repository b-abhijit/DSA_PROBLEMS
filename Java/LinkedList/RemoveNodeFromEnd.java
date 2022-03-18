// Given a linked list, remove the 'n' th node from the end of the list. Here 0 < n <= list.size

package LinkedList;

import LinkedList.utility.CreateLinkedList;
import LinkedList.utility.ListNode;

public class RemoveNodeFromEnd {
    public static void main(String[] args) {
        ListNode head = CreateLinkedList.createLinkedList();
        int n = 3;

        head = removeNode(head, n);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    static ListNode removeNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy, prev= dummy;

        for (int i = 0; i <= n; ++i) {
            curr = curr.next;
        }

        while (curr != null) {
            curr = curr.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return dummy.next;
    }
}
