package LinkedListReversal;

public class ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k) {
        if(k <= 1 || head == null){
            return head;
        };

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        ListNode connection = null;
        ListNode tail = null;

        while(true){
            connection = previous; // Set connection to new head of sub list
            tail = current; // Set tail to new end of sub list

            for(int i = 0; current != null && i < k; i++){
                next = current.next; // Temporary storage
                current.next = previous; // Reversal
                previous = current; // Advance previous
                current = next; // Advance current
            };

            if(connection != null){  // Check if not first reversal
                connection.next = previous;
            } else{ // Set head to first reversal
                head = previous; 
            };

            tail.next = current; // Connect end of reversal to current

            if(current == null){ // Reached end of list
                break;
            };

            previous = tail; // Reset Previous to new end of reversal
        };
    
        return head;
    };
};

// ListNode head = new ListNode(1);
//     head.next = new ListNode(2);
//     head.next.next = new ListNode(3);
//     head.next.next.next = new ListNode(4);
//     head.next.next.next.next = new ListNode(5);
//     head.next.next.next.next.next = new ListNode(6);
//     head.next.next.next.next.next.next = new ListNode(7);
//     head.next.next.next.next.next.next.next = new ListNode(8);

//     ListNode result = ReverseEveryKElements.reverse(head, 3);
//     System.out.print("Nodes of the reversed LinkedList are: ");
//     while (result != null) {
//       System.out.print(result.value + " ");
//       result = result.next;
//     }