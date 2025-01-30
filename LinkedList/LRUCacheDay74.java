import java.util.HashMap;
import java.util.Map;

public class LRUCacheDay74 {
    class Node {
        int key, value;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null; // Fixed (prev should not be assigned 'prev')
        }
    }

    class LRUCache {
        private int cap;
        private Map<Integer, Node> cm;
        private Node head, tail;

        LRUCache(int cap) {
            this.cap = cap;
            this.cm = new HashMap<>();

            // Dummy head and tail for easier list management
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cm.containsKey(key)) return -1;

            Node n = cm.get(key);
            remove(n);
            add(n);
            return n.value;
        }

        public void put(int key, int value) {
            if (cm.containsKey(key)) {
                Node oldNode = cm.get(key);
                remove(oldNode);
            }

            Node node = new Node(key, value);
            cm.put(key, node);
            add(node);

            if (cm.size() > cap) {
                Node toDelete = tail.prev; // LRU node
                remove(toDelete);
                cm.remove(toDelete.key);
            }
        }

        private void add(Node node) {
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
        }

        private void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }

    public static void main(String[] args) {
        LRUCacheDay74 obj = new LRUCacheDay74();
        LRUCache cache = obj.new LRUCache(2); // Capacity = 2

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1)); // 10 (1 is recently used)

        cache.put(3, 30); // Removes key 2 (Least Recently Used)
        System.out.println(cache.get(2)); // -1 (not found)

        cache.put(4, 40); // Removes key 1 (Least Recently Used)
        System.out.println(cache.get(1)); // -1 (not found)
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(4)); // 40
    }
}
