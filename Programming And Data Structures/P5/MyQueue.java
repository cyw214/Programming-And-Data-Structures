/** This class demonstrates how to implement a queue using
  * composition with a linked list. */
public class MyQueue<E> {
  
  private MyLinkedList<E> list;
  
  /** Create a new queue object. */
  public MyQueue() {
    list = new MyLinkedList<E>();
  }
  
  /** Add element e to the end of the queue. */
  public void enqueue(E e) {
    // we assume the tail of the list is the end of the queue
    list.addLast(e);
  }
  
  /** Remove and return the element at the front of the queue. */
  public E dequeue() {
    // we assume the head of the list is the front of the queue
    return list.removeFirst();
  }
  
  /** Return the number of elements in the queue. */
  public int getSize() {
    return list.size();
  }
  /**  Returns the element at position index in the queue without altering the queue*/
  public E peekIndex(int index)
  {
    return list.get(index);
  }
}