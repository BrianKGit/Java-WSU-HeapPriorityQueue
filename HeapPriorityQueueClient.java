import java.util.Scanner;

public class HeapPriorityQueueClient {

    static final Scanner console = new Scanner(System.in);
    
    public static void main(String[] args) {
    
       HeapPriorityQueue<Integer> myQueue = new HeapPriorityQueue<Integer>();
       
       myQueue.enqueue( 5 );
       myQueue.enqueue( 9 );
       myQueue.enqueue( 8 );
       myQueue.enqueue( 3 );
       myQueue.enqueue( 4 );
       myQueue.enqueue( 2 );
       
       System.out.println("Queue: " + myQueue);
       
       System.out.println("\nRemove: " + myQueue.dequeue());

       System.out.println("\nQueue: " + myQueue);

    }
}
