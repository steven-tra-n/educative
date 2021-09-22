package LinkedListReversal;

public class ReverseLinkedList {
    public static ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null){
            next = current.next; // Temporary storage of next
            current.next = previous; // Reversal of current node
            previous = current; // Advance previous
            current = next; // Advance current
        };

        return previous;
    };
};

// ListNode head = new ListNode(2);
//     head.next = new ListNode(4);
//     head.next.next = new ListNode(6);
//     head.next.next.next = new ListNode(8);
//     head.next.next.next.next = new ListNode(10);

//     ListNode result = ReverseLinkedList.reverse(head);
//     System.out.print("Nodes of the reversed LinkedList are: ");
//     while (result != null) {
//       System.out.print(result.value + " ");
//       result = result.next;
//     }