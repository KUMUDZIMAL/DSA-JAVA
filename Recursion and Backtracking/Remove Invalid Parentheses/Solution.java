class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        int left = 0, right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        backtrack(s, 0, left, right, 0, new StringBuilder(), result);

        return new ArrayList<>(result);
    }

    private void backtrack(String s, int index, int leftRemove, int rightRemove,
                           int balance, StringBuilder current, Set<String> result) {

        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && balance == 0) {
                result.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);

        if (c == '(' && leftRemove > 0) {
            backtrack(s, index + 1, leftRemove - 1, rightRemove,
                    balance, current, result);
        }

        if (c == ')' && rightRemove > 0) {
            backtrack(s, index + 1, leftRemove, rightRemove - 1,
                    balance, current, result);
        }

        current.append(c);

        if (c == '(') {
            backtrack(s, index + 1, leftRemove, rightRemove,
                    balance + 1, current, result);
        } else if (c == ')') {
            if (balance > 0) {
                backtrack(s, index + 1, leftRemove, rightRemove,
                        balance - 1, current, result);
            }
        } else {
            backtrack(s, index + 1, leftRemove, rightRemove,
                    balance, current, result);
        }

        current.deleteCharAt(current.length() - 1);
    }
}