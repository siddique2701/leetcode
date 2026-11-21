
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode sortList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle node
        ListNode mid = getMid(head);

        // Split the list into two halves
        ListNode right = mid.next;
        mid.next = null;

        // Recursively sort both halves
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        // Merge both sorted halves
        return merge(leftSorted, rightSorted);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }
}
