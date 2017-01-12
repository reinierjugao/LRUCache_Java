// LRUNode must be in the same directory

class DoubleLinkedList {

  LRUNode head;
  LRUNode tail;
 
  public DoubleLinkedList() {
    this.head = null;
    this.tail = null;
  } 
 
  public LRUNode addnode(String key, String data) {
    // create new node
    LRUNode node = new LRUNode(key, data);
    
    // insert new node at the end of the list
    this.insertnode(node);
    return node;
  }

  public void insertnode(LRUNode node) {
    // inserts node to end of the list
    node.prev = this.tail;
    node.next = null;

    // if tail is defined
    if (this.tail != null) {
      this.tail.next = node;
    } 

    // if head is not defined
    if (this.head == null) {
      this.head = node;
    }

    // if tail is not defined
    if (this.tail == null) {
      this.tail = node;
    }

    this.tail = node;
  }

  public void movetoend(LRUNode node) {
    // moves node to end of list
    // remove node from list
    this.removenode(node);
    // add node to end of list
    this.insertnode(node);
  }

  public void removenode(LRUNode node) {
    // removes node from list
    
    if (node == this.head) {
      this.head = node.next;
    } else if (node.prev != null) {
      node.prev.next = node.next;
    }

    if (node == this.tail) {
      this.tail = node.prev;
    } else if (node.next != null) {
      node.next.prev = node.prev;
    }

    // clean up node
    node.prev = null;
    node.next = null;
  }

}
