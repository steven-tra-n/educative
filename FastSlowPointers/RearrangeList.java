package FastSlowPointers;

public class RearrangeList {
    public static void reorder(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode startFirstHalf = head;
        ListNode startSecondHalf;

        while(fast != null && fast.next != null){ // Find middle of list
            slow = slow.next;
            fast = fast.next.next;
        };

        startSecondHalf = reverse(slow);

        while(startSecondHalf != null){

        };
    };

    private static ListNode reverse(ListNode head){
        ListNode prev = null; // End of list;

        while(head != null){
            ListNode next = head.next; // Save connection since we will soon disconnect head.next
            head.next = prev; // Disconnect and attach to end of list initially
            prev = head; // Connect head towards end of list
            head = next; // Advance one node
        };

        return prev;
    };
};

// ListNode head = new ListNode(2);
// head.next = new ListNode(4);
// head.next.next = new ListNode(6);
// head.next.next.next = new ListNode(8);
// head.next.next.next.next = new ListNode(10);
// head.next.next.next.next.next = new ListNode(12);
// RearrangeList.reorder(head);
// while (head != null) {
// System.out.print(head.value + " ");
// head = head.next;
// }