import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        // Min Heap (smallest value on top)
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Add first node of each list
        for(ListNode node : lists) {
            if(node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while(!pq.isEmpty()) {
            
            ListNode smallest = pq.poll(); 
            // get smallest node

            current.next = smallest; 
            // attach to result

            current = current.next; 
            // move pointer

            if(smallest.next != null) {
                pq.add(smallest.next); 
                // add next node of that list
            }
        }

        return dummy.next;
    }
}