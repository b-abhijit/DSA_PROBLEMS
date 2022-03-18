package LinkedList.utility;

public class CreateLinkedList {

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6

    public static ListNode createLinkedList() {
        ListNode head = new ListNode(1);
        ListNode temp = head;

        temp.next = new ListNode(2);
        temp = temp.next;

        temp.next = new ListNode(3);
        temp = temp.next;

        temp.next = new ListNode(4);
        temp = temp.next;

        temp.next = new ListNode(5);
        temp = temp.next;

        temp.next = new ListNode(6);
        temp = temp.next;

        return head;
    }
}
