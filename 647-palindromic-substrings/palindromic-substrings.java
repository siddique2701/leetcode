
class Solution {

    public int countSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            count += countPal(s, i, i);

            // Even length palindrome
            count += countPal(s, i, i + 1);
        }

        return count;
    }

    private int countPal(String s, int l, int r) {

        int count = 0;

        while (l >= 0 &&
               r < s.length() &&
               s.charAt(l) == s.charAt(r)) {

            count++;

            l--;
            r++;
        }

        return count;
    }
}
