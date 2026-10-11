
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        java.util.Arrays.fill(map, -1);

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            left = Math.max(left, map[c] + 1);
            map[c] = right;

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
