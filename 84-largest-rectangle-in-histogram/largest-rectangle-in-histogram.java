class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea =0;
        int n = heights.length;
        for(int i=0; i <=n; i++) {
            int currH = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() && currH < heights[stack.peek()]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[top] * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}