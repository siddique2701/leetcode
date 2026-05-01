class Solution {
    public void gameOfLife(int[][] board) {
         int m = board.length, n = board[0].length;
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        // Phase 1: Encode transitions in-place
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int live = 0;

                // Count live neighbors (abs value — catch -1 encoded cells!)
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n
                        && Math.abs(board[nr][nc]) == 1) live++;
                }

                // Live cell dies → encode as -1
                if (board[r][c] == 1 && (live < 2 || live > 3))
                    board[r][c] = -1;

                // Dead cell born → encode as 2
                if (board[r][c] == 0 && live == 3)
                    board[r][c] = 2;
            }
        }

        // Phase 2: Finalize — decode back to 0/1
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++) {
                if (board[r][c] == -1) board[r][c] = 0; // died
                if (board[r][c] ==  2) board[r][c] = 1; // born
            }
    }
}