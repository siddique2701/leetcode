
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int idx = 0;

        for (int i = 0; i < n; i++) {
            // 1. Remove smaller or equal values from the tail
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // 2. Add the current index
            deque.offerLast(i);

            // 3. Remove indices outside the current window
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 4. Record maximum when the window is complete
            if (i >= k - 1) {
                result[idx++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
