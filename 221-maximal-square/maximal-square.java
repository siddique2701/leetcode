class Solution {

    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 1];

        int maxSide = 0;

        for (int r = 1; r <= m; r++) {

            for (int c = 1; c <= n; c++) {

                if (matrix[r - 1][c - 1] == '1') {

                    dp[r][c] = 1 + Math.min(
                        dp[r - 1][c - 1],
                        Math.min(
                            dp[r - 1][c],
                            dp[r][c - 1]
                        )
                    );

                    maxSide = Math.max(maxSide, dp[r][c]);
                }
            }
        }

        return maxSide * maxSide;
    }
}