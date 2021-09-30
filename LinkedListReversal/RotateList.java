package LinkedListReversal;

public class RotateList {
    public static ListNode rotate(ListNode head, int rotations) {
        ListNode current = head;
        ListNode previous = null;
        ListNode tail = head;

        if(rotations <= 0 || head == null || head.next == null){
            return head;
        };

        for(int i = 0; i < rotations; i++){
            previous = current;

            if(current.next == null){ // Reached end of list
                current = head;
                i++;
            } else{
                current = current.next; // Traverse until rotations are rotated
            };
        };

        while(tail.next != null){ // Store end of list
            tail = tail.next;
        };

        tail.next = head;
        head = current;
        previous.next = null;

        return head;
    };
};

// ListNode head = new ListNode(1);
//     head.next = new ListNode(2);
//     head.next.next = new ListNode(3);
//     head.next.next.next = new ListNode(4);
//     head.next.next.next.next = new ListNode(5);
//     head.next.next.next.next.next = new ListNode(6);

//     ListNode result = RotateList.rotate(head, 3);
//     System.out.print("Nodes of the reversed LinkedList are: ");
//     while (result != null) {
//       System.out.print(result.value + " ");
//       result = result.next;
//     }