package KWayMerge;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static ListNode merge(ListNode[] lists){
        ListNode resultHead = null;
        ListNode resultTail = null;

        // 5.
        if(lists.length == 1){
            return lists[0];
        };

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);
        
        // 1. Since the arrays are sorted, we can add the first element from each into a min heap
        // 2. Pop from the min heap and add that to the result
        // 3. Add the next from the pop back into the heap
        // 4. What happens when the length of all lists are not the same?
        // 5. Default case?

        // 1.
        for(ListNode root : lists){
            if(root != null){
                minHeap.add(root);
            };
        };

        while(!minHeap.isEmpty()){
            // 2.
            ListNode node = minHeap.poll();

            if(resultHead == null){
                resultHead = node;
                resultTail = node;
            } else{
                resultTail.next = node;
                resultTail = resultTail.next;
            };

            // 3.
            if(node.next != null){
                minHeap.add(node.next);
            };
        };


        return resultHead;
    };
};

// ListNode l1 = new ListNode(2);
// l1.next = new ListNode(6);
// l1.next.next = new ListNode(8);

// ListNode l2 = new ListNode(3);
// l2.next = new ListNode(6);
// l2.next.next = new ListNode(7);

// ListNode l3 = new ListNode(1);
// l3.next = new ListNode(3);
// l3.next.next = new ListNode(4);

// ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
// System.out.print("Here are the elements form the merged list: ");
// while (result != null) {
//   System.out.print(result.value + " ");
//   result = result.next;
// }