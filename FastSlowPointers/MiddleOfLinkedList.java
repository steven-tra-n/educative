package FastSlowPointers;

public class MiddleOfLinkedList {
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        };

        return slow;
    };

    public static ListNode findMiddle2(ListNode head) {
        ListNode slow = head, fast = head;
        int counter = 0;

        while(fast != null && fast.next != null){
            fast = fast.next;
            counter++;
        };

        for(int i = 0; i < counter / 2; i++){
            slow = slow.next;
        };

        if(counter % 2 != 0){
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
// System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

// head.next.next.next.next.next = new ListNode(6);
// System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

// head.next.next.next.next.next.next = new ListNode(7);
// System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);