
class Solution {
    private int rows, cols;
    private int[][] memo;
    private final int[][] DIRS = {{-1,0},{1,0},{0,-1},{0,1}};

    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        memo = new int[rows][cols];

        int answer = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                answer = Math.max(answer, dfs(matrix, r, c));
            }
        }
        return answer;
    }

    private int dfs(int[][] matrix, int r, int c) {
        if (memo[r][c] != 0) return memo[r][c];

        int maxLength = 1;
        for (int[] d : DIRS) {
            int nr = r + d[0], nc = c + d[1];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                    && matrix[nr][nc] > matrix[r][c]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, nr, nc));
            }
        }

        return memo[r][c] = maxLength;
    }
}
