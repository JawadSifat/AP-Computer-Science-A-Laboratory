/*************************************************************************
 * Name                       : Jamie S. 
 * Date Created               : June 2 2022
 * Date Last Updated          : June 4 2022
 * Compilation                : javac RingBuffer.java
 * Execution                  : java  RingBuffer
 * Expected Location          : /RingBuffer.java
 * 
 * 
 * Purpose: A RingBuffer datatype 
 *
 * Expected runtime output     : /ringbufferoutput.txt 
 * 
 *****************************************************************************/
import java.util.Arrays;          // Used to print Arrays to Standard Output

public class RingBuffer {
    private double[] rb;          // items in the buffer
    private int first;            // index for the next dequeue or peek
    private int last;             // index for the next enqueue
    private int size;             // number of items in the buffer

    // create an empty buffer, with given max capacity
    public RingBuffer(int capacity) {
        rb    = new double[capacity];
        first = 0;
        last  = 0;
        size  = 0;
    }

    // return number of items currently in the buffer
    public int size() {
        return size; 
    }

    // is the buffer empty (size equals zero)?
    public boolean isEmpty() {
        if (size == 0) return true;
        return false; 
    }

    // is the buffer full (size equals array capacity)?
    public boolean isFull() {
        if (size == rb.length) return true;
        return false;    
    }

    // add item x to the end
    public void enqueue(double x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last++;
        size++;
        if (last == rb.length) last = 0;
    }

    // delete and return item from the front
    public double dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        double elementDequeued = rb[first];
        first++;
        size--;
        if (first == rb.length) first = 0;
        return elementDequeued;
    }

    // return (but do not delete) item from the front
    public double peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    // Prints verbose diag info
    public void printVerboseInfo(){
        System.out.printf("Capacity: %d%nSize: %d%nFirst: %d%nLast: %d%nPeek: %f%nIsEmpty: %b --- IsFull: %b%n", rb.length, size, first, last, peek(), isEmpty(), isFull());
        for (int i = 0; i < size(); i++){
            System.out.printf("%.3f | ", rb[i]);
        }
        System.out.println();
    }

    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) {
            buffer.enqueue(i);
        }
        buffer.dequeue();
        buffer.enqueue(6.0);
        buffer.dequeue();
        //buffer.enqueue(7.5);
        buffer.printVerboseInfo();

        double t = buffer.dequeue();
        buffer.enqueue(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());
    }

}
