class Solution {

    private int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(matrix, dp, i, j));
            }
        }

        return answer;
    }

    private int dfs(int[][] matrix, int[][] dp, int row, int col) {

        if (dp[row][col] != 0)
            return dp[row][col];

        int max = 1;

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 &&
                newRow < matrix.length &&
                newCol >= 0 &&
                newCol < matrix[0].length &&
                matrix[newRow][newCol] > matrix[row][col]) {

                max = Math.max(max,
                        1 + dfs(matrix, dp, newRow, newCol));
            }
        }

        dp[row][col] = max;

        return max;
    }
}