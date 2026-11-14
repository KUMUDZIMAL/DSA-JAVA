class TextEditor {

    StringBuilder left;
    StringBuilder right;

    public TextEditor() {
        left = new StringBuilder();
        right = new StringBuilder();
    }

    public void addText(String text) {
        left.append(text);
    }

    public int deleteText(int k) {
        int deleted = Math.min(k, left.length());

        left.delete(left.length() - deleted, left.length());

        return deleted;
    }

    public String cursorLeft(int k) {

        int moves = Math.min(k, left.length());

        for (int i = 0; i < moves; i++) {
            char ch = left.charAt(left.length() - 1);
            left.deleteCharAt(left.length() - 1);
            right.append(ch);
        }

        return getLastTen();
    }

    public String cursorRight(int k) {

        int moves = Math.min(k, right.length());

        for (int i = 0; i < moves; i++) {
            char ch = right.charAt(right.length() - 1);
            right.deleteCharAt(right.length() - 1);
            left.append(ch);
        }

        return getLastTen();
    }

    private String getLastTen() {
        int start = Math.max(0, left.length() - 10);
        return left.substring(start);
    }
}


/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */