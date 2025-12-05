//  Time Complexity: O(N)
//  Space Complexity: O(N)

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class Solution {

    List<List<Integer>> treeTraversal(TreeNode root) {

        Stack<Pair> st = new Stack<>();
        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>()); // Preorder
        list.add(new ArrayList<>()); // Inorder
        list.add(new ArrayList<>()); // Postorder

        if (root == null) return list;

        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair P = st.pop();

            // PREORDER
            if (P.num == 1) {
                list.get(0).add(P.node.data);
                P.num++;
                st.push(P);

                if (P.node.left != null)
                    st.push(new Pair(P.node.left, 1));
            }

            // INORDER
            else if (P.num == 2) {
                list.get(1).add(P.node.data);
                P.num++;
                st.push(P);

                if (P.node.right != null)
                    st.push(new Pair(P.node.right, 1));
            }

            // POSTORDER
            else {
                list.get(2).add(P.node.data);
            }
        }

        return list;
    }
}

// ✅ MAIN CLASS (VERY IMPORTANT NAME)
public class Main {

    public static void main(String[] args) {

        // Creating sample tree
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Solution sol = new Solution();
        List<List<Integer>> result = sol.treeTraversal(root);

        System.out.println("Preorder  : " + result.get(0));
        System.out.println("Inorder   : " + result.get(1));
        System.out.println("Postorder : " + result.get(2));
    }
}