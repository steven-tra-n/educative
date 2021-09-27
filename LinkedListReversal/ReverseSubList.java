package LinkedListReversal;

public class ReverseSubList {
    public static ListNode reverse(ListNode head, int p, int q){
        if(head == null){
            return null;
        } else if(p == q){
            return head;
        };

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        for(int i = 0 ; current != null && i < p  - 1; i++){ // Traverse until p
            previous = current;
            current = current.next;
        };

        ListNode connection = previous; // Store before reversing
        ListNode tail = current; 

        for(int i = p; current != null && i < q + 1; i++){
            next = current.next; // Temporary next
            current.next = previous; // Reversal
            previous = current; // Advance previous
            current = next; // Advance current
        };


        if(connection != null){
            connection.next = previous;
        } else{
            head = previous;
        };

        tail.next = current;

        return head;
    };
};

// ListNode head = new ListNode(1);
//     head.next = new ListNode(2);
//     head.next.next = new ListNode(3);
//     head.next.next.next = new ListNode(4);
//     head.next.next.next.next = new ListNode(5);

//     ListNode result = ReverseSubList.reverse(head, 2, 4);
//     System.out.print("Nodes of the reversed LinkedList are: ");
//     while (result != null) {
//       System.out.print(result.value + " ");
//       result = result.next;
//     }