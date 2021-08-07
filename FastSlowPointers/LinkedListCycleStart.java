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
            cycleCounter++; // Count cycle length
        } while(cycleStart != slow);

        slow = fast = head; // Reset both pointers

        for(int i = 0; i < cycleCounter; i++){
            fast = fast.next; // Increment pointer by cycle length so the pointer is now somewhere inside the cycle
        };

        while(fast != slow){
            fast = fast.next; // Increment both pointers by one. Since there is a cycle, they will eventually run into each other
            slow = slow.next; // Since they are incremented by one, they can only meet at the start of the cycle
        };

        return slow;
    };

    public static ListNode findCycleStart2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int counter = 0;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){ // Found intersection, start counting
                break;
            };  
        };

        do{
            slow = slow.next;
            counter++;
        } while(fast != slow); // Count until next intersection

        fast = head;
        slow = head;

        for(int i = 0; i < counter; i++){
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