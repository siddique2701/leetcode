class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int answer   = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Negative வந்தா max & min swap ஆகும் — so temp வேணும்!
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            int tempMin = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));

            maxSoFar = tempMax;
            minSoFar = tempMin;

            answer = Math.max(answer, maxSoFar);
        }

        return answer;

    }
}