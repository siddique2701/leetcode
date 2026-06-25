class Solution {

    public int racecar(int target) {

        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {

            dp[i] = Integer.MAX_VALUE;

            int m = 1;
            int j = 1;

            // Find smallest j such that (2^j - 1) >= i
            while (m < i) {
                j++;
                m = (1 << j) - 1;
            }

            // Exact match
            if (m == i) {
                dp[i] = j;
                continue;
            }

            // Overshoot then reverse
            dp[i] = j + 1 + dp[m - i];

            // Reverse before reaching target
            for (int k = 0; k < j - 1; k++) {

                int forward = (1 << (j - 1)) - 1;
                int backward = (1 << k) - 1;

                dp[i] = Math.min(
                        dp[i],
                        (j - 1) + 1 + k + 1 + dp[i - forward + backward]
                );
            }
        }

        return dp[target];
    }
}