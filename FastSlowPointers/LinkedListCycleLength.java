package FastSlowPointers;

public class LinkedListCycleLength {
    public static int findCycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode cycleStart = head;
        int cycleCounter = 0;

        while(fast != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                cycleStart = slow; // Find an arbitrary intersecting point in the linked list
                break;
            };
        };

        do{
            cycleStart = cycleStart.next; // Move one node ahead and then loop to find length
            cycleCounter++;
        } while(cycleStart != slow);

        return cycleCounter;
    };
};

// ListNode head = new ListNode(1);
// head.next = new ListNode(2);
// head.next.next = new ListNode(3);
// head.next.next.next = new ListNode(4);
// head.next.next.next.next = new ListNode(5);
// head.next.next.next.next.next = new ListNode(6);
// head.next.next.next.next.next.next = head.next.next;
// System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

// head.next.next.next.next.next.next = head.next.next.next;
// System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));