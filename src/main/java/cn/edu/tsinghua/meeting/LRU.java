package cn.edu.tsinghua.meeting;

import java.util.HashMap;

public class LRU {
  private HashMap<Integer, Node> cache = new HashMap<>();
  private int size;
  private int capacity;
  private Node head, tail;

  public LRU(int capacity) {
    this.size = 0;
    this.capacity = capacity;
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.pre = head;
  }

  public Integer get(int key) {
    Node node = cache.get(key);
    if (node == null) {
      return -1;
    }
    removeNode(node);
    addToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    Node node = cache.get(key);
    if (node == null) {
      Node newNode = new Node(key, value);
      cache.put(key, newNode);
      addToHead(node);
      size++;
      if (size > capacity) {
        Node tailNode = tail.pre;
        cache.remove(tailNode.key);
        --size;
      }
    } else {
      node.value = value;
      removeNode(node);
      addToHead(node);
    }
  }

  private void removeNode(Node node) {
    node.pre.next = node.next;
    node.next.pre = node.pre;
  }

  private void addToHead(Node node) {
    node.pre = head;
    node.next = head.next;
    head.next.pre = node;
    head.next = node;
  }

}

class Node {
  int value;
  int key;
  Node pre;
  Node next;

  public Node() {

  }

  public Node(int key, int value) {
    key = this.key;
    value = this.value;
  }
}

