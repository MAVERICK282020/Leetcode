class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        backtrack(0, n, board, cols, diag1, diag2, ans);

        return ans;
    }

    private void backtrack(
            int row,
            int n,
            char[][] board,
            boolean[] cols,
            boolean[] diag1,
            boolean[] diag2,
            List<List<String>> ans) {

        // All queens placed
        if (row == n) {

            List<String> solution = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }

            ans.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {

            int d1 = row - col + n - 1;
            int d2 = row + col;

            // Position already attacked
            if (cols[col] || diag1[d1] || diag2[d2])
                continue;

            // Place queen
            board[row][col] = 'Q';

            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // Move to next row
            backtrack(
                row + 1,
                n,
                board,
                cols,
                diag1,
                diag2,
                ans
            );

            // Backtrack
            board[row][col] = '.';

            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}