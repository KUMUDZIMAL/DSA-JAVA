// Time Complexity: O(NlogN) -> N(BFS Traversal) + logN(TreeMap Insertion and Search)
// Space Complexity: O(N) -> O(N) + O(N) +O(N) -> AL + Map + Queue

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Pair{
    Node node;
    int hd;
    Pair(Node node, int hd){
        this.node=node;
        this.hd=hd;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {

        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        q.offer(new Pair(root,0));

        while (!q.isEmpty()) {
            Pair P = q.poll();
            Node node = P.node;
            int hd = P.hd;
    


      
             map.put(hd,node.data);
         
       
            if (node.left != null) {
                q.offer(new Pair(node.left, hd-1));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, hd+1));
            }
        }

    for(Map.Entry<Integer,Integer> entry: map.entrySet()){
        ans.add(entry.getValue());
    }


        return ans;
    }
}