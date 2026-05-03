class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // Step 1: check if k nodes exist
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            // Step 2: reverse first k nodes

            curr = reverseKGroup(curr, k); 
            // recursive call for remaining list

            while (count-- > 0) {
                ListNode next = head.next; 
                // store next node

                head.next = curr; 
                // reverse link

                curr = head; 
                // move curr

                head = next; 
                // move head
            }

            head = curr; 
            // new head after reverse
        }

        return head;
    }
}