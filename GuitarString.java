
/*************************************************************************
 * Name                       : Jamie S. 
 * Date Created               : June 2nd 2022
 * Date Last Updated          : June 2nd 2022
 * Compilation                : javac GuitarString.java
 * Execution                  : java  GuitarString
 * Expected Location          : /GuitarString.java
 * 
 * Expected Runtime Output    : Shown in stringRuntime.txt 
 * 
 *****************************************************************************/
import java.util.Arrays;        // Used only to print arrays to Standard Out
import java.util.Random;        // Used only in pluck()

public class GuitarString {

    protected RingBuffer buffer; // ring buffer
    private final double SAMPLING_RATE = 44100.0; // Standard sampling rate
    private int time = 0;

    // create a guitar string of the given frequency
    public GuitarString(double frequency) {
        int n  = (int) Math.ceil(SAMPLING_RATE / frequency);
        buffer = new RingBuffer(n);
        while (!buffer.isFull()) buffer.enqueue(0);
    }

    // create a guitar string with size & initial values given by the array
    public GuitarString(double[] init) {
        buffer = new RingBuffer(init.length);
        for (int i = 0; i < init.length; i++){
            buffer.enqueue(init[i]);
        }
        // NOTE: last should be set to 0 after this constructor
    }

    public int length(){
        return buffer.size();
    }

    // pluck the guitar string by replacing the buffer with white noise
    public void pluck() {
        while (!buffer.isEmpty()) buffer.dequeue();
        while (!buffer.isFull())  buffer.enqueue((Math.random()) - 0.5); 
    }

    // advance the simulation one time step
    /*
 This method applies the Karplus–Strong update: delete the sample at 
 the front of the  ring buffer and add the average of the first two 
 samples multiplied by the energy decay factor to the end of the ring buffer.
    */

    public void tic() {
        double first      = sample();
        buffer.dequeue();
        double second     = sample();
        double karplusAvg = .994 * (0.5 * (first + second));
        buffer.enqueue(karplusAvg);
        time++;
    }

    // return the current sample
    public double sample() {
        return buffer.peek();
    }

    // return number of times tic was called
    public int time() {
        return time;
    }

  public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);
      double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
      GuitarString testString = new GuitarString(samples);
      for (int i = 0; i < N; i++) {
          int t = testString.time();
          double sample = testString.sample();
          System.out.printf("%6d %8.4f\n", t, sample);
          testString.tic();
      }
   }

}
