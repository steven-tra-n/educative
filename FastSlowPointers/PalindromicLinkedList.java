package FastSlowPointers;

public class PalindromicLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        // String firstHalf = "", secondHalf = "";
        StringBuilder firstHalf = new StringBuilder();
        StringBuilder secondHalf = new StringBuilder();
        int listCount = 0;

        while(fast != null && fast.next != null){
            firstHalf.append(slow.value);
            slow = slow.next;
            fast = fast.next.next;
            listCount++;
        };

        System.out.println(firstHalf);
        slow = slow.next;

        while(slow != null){
            secondHalf.append(slow.value);
            slow = slow.next;
        };

        secondHalf = secondHalf.reverse();

        System.out.println(firstHalf);
        System.out.println(secondHalf);

        return firstHalf.toString().equals(secondHalf.toString());
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