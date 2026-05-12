class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            int lineLength = words[i].length();
            int j = i + 1;

            // Find how many words fit in current line
            while (j < words.length &&
                   lineLength + 1 + words[j].length() <= maxWidth) {

                lineLength += 1 + words[j].length();
                j++;
            }

            int numberOfWords = j - i;
            StringBuilder sb = new StringBuilder();

            // Last line OR single word
            if (j == words.length || numberOfWords == 1) {

                for (int k = i; k < j; k++) {

                    sb.append(words[k]);

                    if (k != j - 1) {
                        sb.append(" ");
                    }
                }

                // Fill remaining spaces
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }

            } else {

                // Total chars without spaces
                int totalChars = 0;

                for (int k = i; k < j; k++) {
                    totalChars += words[k].length();
                }

                int totalSpaces = maxWidth - totalChars;

                int gaps = numberOfWords - 1;

                int spacesPerGap = totalSpaces / gaps;

                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    sb.append(words[k]);

                    if (k != j - 1) {

                        int spacesToApply = spacesPerGap;

                        if (extraSpaces > 0) {
                            spacesToApply++;
                            extraSpaces--;
                        }

                        for (int s = 0; s < spacesToApply; s++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());

            i = j;
        }

        return result;
    }
}