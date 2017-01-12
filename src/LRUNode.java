class LRUNode {
  
  // Note: using string will use more memory but will be
  //  more flexible than using integers. If we do not need
  //  this type of flexibility, use integers to save memory
  public String key;
  public String data;
  public LRUNode prev;
  public LRUNode next;

  // Constructor
  //   Creates this node and sets key and data
  public LRUNode(String key, String data) {
    this.next = null;
    this.prev = null;
    this.key = key;
    this.data = data;
  }
}
