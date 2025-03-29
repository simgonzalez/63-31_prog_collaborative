public class ListeChainee<E extends Comparable<E>> {
  private class Node {
    public Node next, prev;
    public E element;

    public Node(E el, Node next, Node prev) {
      this.element = el;
      this.next = next;
      this.prev = prev;
    }

    public E find(E el) {
      if (element.equals(el)) {
        return element;
      }
      if (next == null) {
        return null;
      }
      return next.find(el);
    }
  }

  private Node head, tail;
  private int size = 0;

  public void add(E el) {
    Node n = new Node(el, null, tail);
    if (isEmpty()) {
      head = n;
    } else {
      tail.next = n;
    }
    tail = n;
    size++;
  }

  public E find(E el) {
    if (isEmpty()) {
      return null;
    }

    Node current = head;
    while (current != null) {
      if (current.element.equals(el)) {
        return current.element;
      }
      current = current.next;
    }
    return null;
  }


  public E findRec(E element) {
    if (isEmpty()) {
      return null;
    }
    return head.find(element);
  }

  public E unchain() {
    if (isEmpty()) {
      return null;
    }

    E result = head.element;

    if (head == tail) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      head.prev = null;
    }

    size--;
    return result;
  }

  public E get(int i) {
    if (i >= size || i < 0) {
      throw new IndexOutOfBoundsException();
    }

    Node current = head;
    for (int idx = 0; idx < i; idx++) {
      current = current.next;
    }
    return current.element;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return head == null;
  }
}
