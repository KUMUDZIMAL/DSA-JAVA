class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] prefix = new char[n];
        int matched = 0;

        while (matched < n) {
            int c = target.charAt(matched) - 'a';

            if (freq[c] == 0) {
                break;
            }

            prefix[matched] = target.charAt(matched);
            freq[c]--;
            matched++;
        }

        for (int i = matched; i >= 0; i--) {

            if (i < matched) {
                freq[target.charAt(i) - 'a']++;
            }

            if (i == n) {
                continue;
            }

            int targetChar = target.charAt(i) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {

                if (freq[c] == 0) {
                    continue;
                }

                StringBuilder ans = new StringBuilder();

                for (int j = 0; j < i; j++) {
                    ans.append(prefix[j]);
                }

                ans.append((char) ('a' + c));
                freq[c]--;

                for (int x = 0; x < 26; x++) {
                    for (int count = 0; count < freq[x]; count++) {
                        ans.append((char) ('a' + x));
                    }
                }

                freq[c]++;

                return ans.toString();
            }
        }

        return "";
    }
}