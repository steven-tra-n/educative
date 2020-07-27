package FastSlowPointers;

public class LinkedListCycleStart {
    public static ListNode findCycleStart(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode cycleStart = head;
        int cycleCounter = 0;

        while(fast != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                cycleStart = slow;
                break;
            };
        };

        do{
            cycleStart = cycleStart.next;
            cycleCounter++;
        } while(cycleStart != slow);

        slow = fast = head;

        for(int i = 0; i < cycleCounter; i++){
            fast = fast.next;
        };

        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        };

        return slow;
    };
};

// ListNode head = new ListNode(1);
// head.next = new ListNode(2);
// head.next.next = new ListNode(3);
// head.next.next.next = new ListNode(4);
// head.next.next.next.next = new ListNode(5);
// head.next.next.next.next.next = new ListNode(6);

// head.next.next.next.next.next.next = head.next.next;
// System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

// head.next.next.next.next.next.next = head.next.next.next;
// System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

// head.next.next.next.next.next.next = head;
// System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);