class Solution {

    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Build histogram
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // Largest rectangle in current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight = (i == heights.length)
                    ? 0
                    : heights[i];

            while (!stack.isEmpty() &&
                   currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}