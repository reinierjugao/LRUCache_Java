import java.util.HashMap;

class LRUCache extends DoubleLinkedList {
  private HashMap <String, LRUNode> keys;
  private int capacity = 0;
  private int count = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.count = 0;
    this.keys = new HashMap<String, LRUNode>();
  }

  public String get(String key) {
    // gets value of a key
    if (!this.keys.containsKey(key)) {
      return "Key does not exist";
    } else {
      LRUNode node = this.keys.get(key);
      this.movetoend(node);
      return node.data;
    }
  }

  public void put(String key, String value) {
    // if key already exists, remove item from double linked list
    // and move it to tail with updated value.
    // If key doesn't already exist, check if this.count > this.capacity.
    //   If count = capacity, remove item at this.head.
    //   Add new item to tail
    // Increment this.count if less than this.capacity

    if (!this.keys.containsKey(key)) {
      if (this.count == this.capacity) {
        LRUNode hnode = this.head;
        this.removenode(hnode);
        this.keys.remove(hnode.key);
      } else {
        this.count++;
      }
      LRUNode node = this.addnode(key, value);
      this.keys.put(key, node);
    } else {
      LRUNode node = this.keys.get(key);
      this.movetoend(node);
      node.data = value;
    }
  }

  public static void main(String[] args) {
    LRUCache obj = new LRUCache(2);
    obj.put("1","1");
    obj.put("2","2");
    System.out.println(obj.get("2"));
    obj.put("3","3");
    obj.put("4","4");
    System.out.println(obj.get("2"));
    
    System.out.println(obj.get("4"));
  }

}
