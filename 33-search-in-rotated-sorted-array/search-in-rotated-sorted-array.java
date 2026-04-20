class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Left half sorted?
            if (nums[left] <= nums[mid]) {
                // Target இந்த sorted half-ல இருக்கா?
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;  // Go left
                } else {
                    left = mid + 1;   // Go right
                }
            }
            // Right half sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;   // Go right
                } else {
                    right = mid - 1;  // Go left
                }
            }
        }

        return -1; // Not found
    }
}