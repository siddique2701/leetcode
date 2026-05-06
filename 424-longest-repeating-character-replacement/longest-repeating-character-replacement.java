class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int maxFreq = 0;
        int[] count = new int[26];
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            count[ch - 'A']++;

            maxFreq = Math.max(maxFreq, count[ch - 'A']);

            // window invalidனா shrink
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}