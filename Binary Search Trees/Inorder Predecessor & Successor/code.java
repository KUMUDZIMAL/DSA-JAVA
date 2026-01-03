/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node pre = null, suc = null;
        Node curr = root;

        // Find predecessor
        while (curr != null) {
            if (curr.data < key) {
                pre = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        curr = root;

        // Find successor
        while (curr != null) {
            if (curr.data > key) {
                suc = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        ArrayList<Node> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(suc);
        return ans;
    }
}


