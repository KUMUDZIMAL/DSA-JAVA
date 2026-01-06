class LRUCache {
class Node {
  int key,value;
  Node prev,next;
  Node(int k,int v){
    key=k;
    value=v;
}

}
Map<Integer,Node> map;
Node head,tail;
int capacity;

    public LRUCache(int capacity) {
    this.capacity=capacity;
    map=new HashMap<>();
    head=new Node(0,0);
    tail=new Node(0,0);
    head.next=tail;
    tail.prev=head;
    }
    public void deleteNode(Node node){
       Node demo = node.prev;
       demo.next=node.next;
       Node demo2=node.next;
       demo2.prev=demo;
   
}
public void insertAfterHead(Node node){
    Node currNode=head.next;
head.next=node;
node.next=currNode;
node.prev=head;
currNode.prev=node;
}
    
    public int get(int key) {
      if(map.containsKey(key)) {
        Node node=map.get(key);
        deleteNode(node);
        insertAfterHead(node);
     return node.value;
    }
       
      else{
        return -1;
      }}
         
    
    public void put(int key, int value) {
      if(map.containsKey(key)){
        Node node=map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        node.value = value;
      }
      else{
        if(map.size()==capacity){
            Node node=tail.prev;
               deleteNode(tail.prev);
             map.remove(node.key);
            
        }
           Node newnode=new Node(key,value);
               insertAfterHead(newnode);
               map.put(key,newnode);
      }
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */