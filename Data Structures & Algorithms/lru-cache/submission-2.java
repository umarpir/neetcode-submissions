// hashmap for key -> return linked list node (this node is in the linked list) - > double linked list.
// tail -> val -> val -> val -> head

class LRUCache {

    private HashMap<Integer, ListNode> cacheMap;
    ListNode head;
    ListNode tail;
    int capacity;


    public LRUCache(int capacity) {
        this.cacheMap = new HashMap<>();
        this.capacity = capacity;
        this.head = new ListNode();
        this.tail = new ListNode();

        head.prev = tail;
        tail.next = head;

    }
    
    public int get(int key) {
        ListNode existing = cacheMap.get(key);

        if(existing == null)
        {
            return -1;
        }

        ListNode previous = existing.prev;
        ListNode next = existing.next;
        previous.next = next;
        next.prev = previous;

        ListNode front = head.prev;
        front.next = existing;
        existing.prev = front;
        existing.next = head;
        head.prev = existing;

        return existing.val;

    }
    
    public void put(int key, int value) {

        ListNode existing = cacheMap.get(key);
        ListNode newEntry = new ListNode(key, value);

        //new entry
        ListNode front = head.prev;
        front.next = newEntry;
        newEntry.next = head;
        head.prev = newEntry;
        newEntry.prev = front;

        // if exists, keep the key and replace the node reference
        if(existing != null)
        {
            ListNode previousExisting = existing.prev;
            ListNode nextExisting = existing.next;

            previousExisting.next = nextExisting;
            nextExisting.prev = previousExisting;
        }
        cacheMap.put(key, newEntry);

        if(cacheMap.size() > capacity)
        {
            ListNode lastUsed = tail.next;
            ListNode nextLast = lastUsed.next;

            tail.next = nextLast;
            nextLast.prev = tail;
            cacheMap.remove(lastUsed.key);
        }
        
    }

    class ListNode{

        int key;
        int val;
        ListNode next;
        ListNode prev;

        ListNode(){}

        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }

        public ListNode(int key, int val, ListNode next, ListNode prev){
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
