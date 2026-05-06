class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] count = new int[128];

        // Step 1: store t frequencies
        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int left = 0;
        int right = 0;
        int required = t.length(); // how many chars still needed

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char rChar = s.charAt(right);

            // If needed char
            if (count[rChar] > 0) {
                required--;
            }

            count[rChar]--; // include char in window
            right++;

            // When window is valid
            while (required == 0) {

                // Update answer
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lChar = s.charAt(left);

                count[lChar]++;

                // If removing breaks condition
                if (count[lChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}