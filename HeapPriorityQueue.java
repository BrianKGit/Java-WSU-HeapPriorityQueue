import java.util.*;

public class HeapPriorityQueue<E> implements QueueInterface<E> {

   //data members
   private ArrayList priorityQ;
   private int lastIndex;
   
   //constructor
   public HeapPriorityQueue() {
   
      priorityQ = new ArrayList();
      lastIndex = 0;
   }
    
   public int size() {
      
      return lastIndex;
   }
   
   public boolean isEmpty() {
      
      return lastIndex == 0;
   }
   
   public E front() throws EmptyQueueException { //peek method
   
      if(isEmpty()) {
         throw new EmptyQueueException("Empty Queue");
      }
      
      return (E) priorityQ.get(0);
   }
    
   public void enqueue( E newObject ) {
   
      priorityQ.add(lastIndex, newObject);
      
      if(lastIndex == 0) {
         lastIndex ++;
         return;
      }
      
      int parentIndex;
      int currentIndex = lastIndex;
      
      while(true) {
      
         if(currentIndex % 2 == 0) {//right child
            parentIndex = currentIndex / 2 - 1;
         } else {
            parentIndex = (currentIndex - 1) / 2;
         }
         
         Comparable child = (Comparable) priorityQ.get(currentIndex);
         Comparable parent = (Comparable) priorityQ.get(parentIndex);
         
         if(child.compareTo(parent) < 0) {//child < parent
            //swap
            E temp = (E) priorityQ.get(currentIndex);
            priorityQ.set(currentIndex, priorityQ.get(parentIndex));
            priorityQ.set(parentIndex, temp);
         }
         
         currentIndex = parentIndex; //continue the process to the root
         
         if(currentIndex == 0) {
            break;
         }
      
         
      }//end while
      
      lastIndex++;
      
   }//end enqueue()
   
   public E dequeue() throws EmptyQueueException {
   
      if(isEmpty()) {
         throw new EmptyQueueException("Empty Queue");
      }
      
      E removedObj = (E) priorityQ.get(0); //retrieve the object at the root
      
      if( lastIndex == 1 ) { //no node in the heap
         priorityQ.set(0, null);
         lastIndex--;
         return removedObj;
      }
      
      if( lastIndex == 2 ) { //only one node remaining
         priorityQ.set(0, priorityQ.get(lastIndex - 1));
         priorityQ.set(lastIndex - 1, null);
         lastIndex--;
         return removedObj;
      }
      
      priorityQ.set(0, priorityQ.get(lastIndex - 1));
      priorityQ.set(lastIndex - 1, null);
      lastIndex--;
      
      int parentIndex = 0;
      int currentIndex = 0;
      
      while(true) {
      
         int leftChildIndex = (2 * currentIndex + 1);
         int rightChildIndex = 2 * (currentIndex + 1);
         
         int minChildIndex;
         
         if(leftChildIndex >= lastIndex && rightChildIndex >= lastIndex) {//no children
            break;
         } else if(rightChildIndex >= lastIndex) { //no right child, only left child
            minChildIndex = leftChildIndex;
         } else {
            Comparable left = (Comparable) priorityQ.get(leftChildIndex);
            Comparable right = (Comparable) priorityQ.get(rightChildIndex);
            
            if(left.compareTo(right) < 0) {
            minChildIndex = leftChildIndex;
            } else {
               minChildIndex = rightChildIndex;
            }
         }
         
         //compare the object with the smaller child
         Comparable child = (Comparable) priorityQ.get(minChildIndex);
         Comparable parent = (Comparable) priorityQ.get(currentIndex);
         
         if(child.compareTo(parent) < 0) {
            //swap
            E temp = (E) priorityQ.get(currentIndex);
            priorityQ.set(currentIndex, priorityQ.get(minChildIndex));
            priorityQ.set(minChildIndex, temp);
         }
         
         currentIndex = minChildIndex;
      
      }//end while
      
      priorityQ.remove(null); //remove null objects
      
      return removedObj;
      
   }//end dequeue()
   
   public String toString() {
      
      return "" + priorityQ;
      
   }//end toString()
   
}//end class
