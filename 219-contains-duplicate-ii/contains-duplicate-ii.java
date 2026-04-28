class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int start = 0;
        int end =0;
        Set<Integer> set = new HashSet<>();

        while(end < nums.length) {
            if(set.contains(nums[end])) {
                return true;
            }

            set.add(nums[end]);
            if(end - start >= k) {
                set.remove(nums[start]);
                start++;
            }
            end++;
        }
        return false;
    }
}