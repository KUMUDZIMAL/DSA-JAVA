import java.util.*;

class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(String s, int idx, int parts, StringBuilder curr, List<String> ans) {

        if (parts == 4) {
            if (idx == s.length()) {
                ans.add(curr.toString());
            }
            return;
        }

        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {

            String part = s.substring(idx, idx + len);

            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            int num = Integer.parseInt(part);

            if (num > 255) {
                continue;
            }

            int oldLength = curr.length();

            if (parts > 0) {
                curr.append('.');
            }

            curr.append(part);

            backtrack(s, idx + len, parts + 1, curr, ans);

            curr.setLength(oldLength);
        }
    }
}