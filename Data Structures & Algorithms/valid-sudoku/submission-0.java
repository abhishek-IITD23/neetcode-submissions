class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Arrays to track seen digits (1-9) for rows, columns, and 3x3 boxes
        // Using size 10 so we can map the digit character directly to its index
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                
                // Skip empty cells
                if (val == '.') {
                    continue;
                }
                
                // Convert char digit to integer index
                int digit = val - '0';
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If the digit is already seen in the current row, column, or box, it's invalid
                if (rows[r][digit] || cols[c][digit] || boxes[boxIndex][digit]) {
                    return false;
                }

                // Mark the digit as seen
                rows[r][digit] = true;
                cols[c][digit] = true;
                boxes[boxIndex][digit] = true;
            }
        }

        return true;
    }
}
