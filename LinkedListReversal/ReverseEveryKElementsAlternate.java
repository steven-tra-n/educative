package LinkedListReversal;

public class ReverseEveryKElementsAlternate {
    public static ListNode reverse(ListNode head, int k) {
        ListNode current = head;
        ListNode next = null;
        ListNode previous = null;
        ListNode tail = null;
        ListNode connection = null;

        while(true){
            connection = previous; // Set end of old sub list
            tail = current; // Set end of new sub list

            for(int i = 0; current != null && i < k; i++){
                next = current.next; // Temporary storage
                current.next = previous; // Reversal
                previous = current; // Advance previous
                current = next; // Advance current
            };
            
            if(connection != null){
                connection.next = previous; // Set next node for end of old list to start of new sub list
            } else{
                head = previous; // Set head to start of new sub list on the first go
            };

            tail.next = current; // Set next node for end of new sub list to start of new new sub list

            // previous = tail; // Set new end of old sub list

            // connection = previous;
            // tail = current;

            for(int i = 0; current != null && i < k; i++){
                previous = current;
                current = current.next;
            };

            if(current == null){ // Reached end
                break;
            };
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

//     ListNode result = ReverseEveryKElements.reverse(head, 2);
//     System.out.print("Nodes of the reversed LinkedList are: ");
//     while (result != null) {
//       System.out.print(result.value + " ");
//       result = result.next;
//     }