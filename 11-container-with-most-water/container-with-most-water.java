class Solution {
    public int maxArea(int[] height) {
        int l =0;
        int r = height.length -1;
        int ans =0;
        while(l<r) {
            int w = r -l;
            int h = Math.min(height[l],height[r]);
            int wa = w*h;
            ans = Math.max(ans,wa);
            if(height[l] < height[r]) {
                l++;
            } else {

                r--;
            }
            
        }
        return ans;
    }
}