package FastSlowPointers;

public class PalindromicLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        // String firstHalf = "", secondHalf = "";
        StringBuilder firstHalf = new StringBuilder();
        StringBuilder secondHalf = new StringBuilder();

        while(fast != null && fast.next != null){
            firstHalf.append(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        };

        if(fast != null){ // List length is odd, so we should skip over the middle node
            slow = slow.next;
        };

        while(slow != null){
            secondHalf.append(slow.value);
            slow = slow.next;
        };

        secondHalf = secondHalf.reverse();

        System.out.println(firstHalf);
        System.out.println(secondHalf);

        return firstHalf.toString().equals(secondHalf.toString());
    };

    private ListNode reverse(ListNode head){
        ListNode prev = null; // End of list

        while(head != null){ // We want to point the head of the list to the end. Stop iterating when it reaches the end
            ListNode next = head.next;  // Temporarily store head.next
            head.next = prev; // Connect head.next to the end of the list
            prev = head;
            head = next;
        };

        return head;
    };
};

// ListNode head = new ListNode(2);
// head.next = new ListNode(4);
// head.next.next = new ListNode(6);
// head.next.next.next = new ListNode(4);
// head.next.next.next.next = new ListNode(2);
// System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

// head.next.next.next.next.next = new ListNode(2);
// System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));