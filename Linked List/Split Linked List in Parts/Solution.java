
  class ListNode {
      int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

       
        int size = length / k;

     
        int extra = length % k;

        ListNode[] result = new ListNode[k];

        curr = head;

        for (int i = 0; i < k; i++) {

            result[i] = curr;

       
            int partSize = size + (i < extra ? 1 : 0);

            for (int j = 1; j < partSize && curr != null; j++) {
                curr = curr.next;
            }

  
            if (curr != null) {
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }

        return result;
    }
}