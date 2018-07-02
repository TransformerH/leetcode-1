/**
 * a few requirements:
 * 1. access to a random key in O(1) - hashtable
 * 2. remove the last entry in the Cache in O(1) - list
 * 3. Add/Move an entry to the front of the Cache in O(1) - list
 */

class LRUCache {

    private Node tail;
    private Node head;
    private Map<Integer, Node> map;
    private int capacity;
    
    public LRUCache(int capacity) {
        tail = null;
        head = null;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null){
            return -1;
        }
        if (node != tail) {
            if (node == head){
                head = head.next;
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null){
            Node newNode = new Node(key, value);
            if (capacity == 0){
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            if (head == null && tail == null){
                head = newNode; 
            }else{
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }else{
            // modify this node;
            node.value = value;
            if (node != tail) {
                if (node == head){
                    head = head.next;
                }else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }
        }
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */