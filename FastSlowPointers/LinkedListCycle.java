package FastSlowPointers;

public class LinkedListCycle {
  public static boolean hasCycle(ListNode head) {
      ListNode fast = head;
      ListNode slow = head;

      while(fast != null && slow != null){ // Neither pointers have reached the end of the linked list
        fast = fast.next.next;
        slow = slow.next;

        if(fast == slow){ // Pointers have caught up with each other
            return true;
        };
      };

      return false;
    };

    public static int hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int counter = 0;

        while(fast != null && fast.next != null){
          fast = fast.next.next;
          slow = slow.next;
          counter++;

          if(fast == slow){
            return counter;
          };
        };
  
        return counter;
      };
};

// ListNode head = new ListNode(1);
// head.next = new ListNode(2);
// head.next.next = new ListNode(3);
// head.next.next.next = new ListNode(4);
// head.next.next.next.next = new ListNode(5);
// head.next.next.next.next.next = new ListNode(6);
// System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

// head.next.next.next.next.next.next = head.next.next;
// System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

// head.next.next.next.next.next.next = head.next.next.next;
// System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));