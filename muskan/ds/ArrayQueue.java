package muskan.ds;
public class ArrayQueue<E> implements Queue<E> 
{
  // instance variables
  /** Default array capacity. */
  public static final int CAPACITY = 1000;      // default array capacity

  /** Generic array used for storage of queue elements. */
  private E[] data;                             // generic array used for storage

  /** Index of the top element of the queue in the array. */
  private int f = 0;                            // index of the front element

  /** Current number of elements in the queue. */
  private int sz = 0;                           // current number of elements

  // constructors
  /** Constructs an empty queue using the default array capacity. */
  public ArrayQueue() 
  { 
  data=(E[])new Object[CAPACITY];
  }         // constructs queue with default capacity

  /**
   * Constructs and empty queue with the given array capacity.
   * @param capacity length of the underlying array
   */
  @SuppressWarnings({"unchecked"})
  public ArrayQueue(int capacity) 
  { 
  data=(E[])new Object[capacity];
  }

  // methods
  /**
   * Returns the number of elements in the queue.
   * @return number of elements in the queue
   */
  @Override
  public int size() 
  { 
  return sz;
  }

  /** Tests whether the queue is empty. */
  @Override
  public boolean isEmpty() 
  { 
  return sz==0;
  }

  /**
   * Inserts an element at the rear of the queue.
   * This method runs in O(1) time.
   * @param e   new element to be inserted
   * @throws IllegalStateException if the array storing the elements is full
   */
  @Override
  public void enqueue(E e) throws IllegalStateException 
  {
  data[sz]=e;
  sz++;
  }

  /**
   * Returns, but does not remove, the first element of the queue.
   * @return the first element of the queue (or null if empty)
   */
  @Override
  public E first() 
  {
  if(sz==0)
  return null;
  else
  return data[f];
  }

  /**
   * Removes and returns the first element of the queue.
   * @return element removed (or null if empty)
   */
  @Override
  public E dequeue() 
  {
   if(sz==0)
  return null;
  
  E value;
  value=data[f];
  
  for (int i = 0; i <sz-1; i++) { 
                data[i] = data[i + 1]; 
            } 

sz--;
  return value;
 }

  /**
   * Returns a string representation of the queue as a list of elements.
   * This method runs in O(n) time, where n is the size of the queue.
   * @return textual representation of the queue.
   */
  public String toString() 
  {
  StringBuilder sb = new StringBuilder("(");
      int i=f;
    while (f<sz) {
      sb.append(dequeue());
        sb.append(", ");
   f++;
    }
    f=i;
    sb.append(")");
    return sb.toString();
  
  
  
  
  }
  
  
  
}