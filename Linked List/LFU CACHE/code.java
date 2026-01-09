import java.util.*;
class LFUCache {

    class Node {
        int key, val, freq;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            val = v;
            freq = 1;
        }
    }

    class DLL {
        Node head, tail;
        int size;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    int capacity, minFreq;
    Map<Integer, Node> keyMap;
    Map<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;
        Node node = keyMap.get(key);
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.val = value;
            update(node);
            return;
        }

        if (keyMap.size() == capacity) {
            DLL minList = freqMap.get(minFreq);
            Node removed = minList.removeLast();
            keyMap.remove(removed.key);
        }

        Node node = new Node(key, value);
        keyMap.put(key, node);
        freqMap.computeIfAbsent(1, k -> new DLL()).addFirst(node);
        minFreq = 1;
    }

    private void update(Node node) {
        int freq = node.freq;
        DLL list = freqMap.get(freq);
        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DLL()).addFirst(node);
    }
}
