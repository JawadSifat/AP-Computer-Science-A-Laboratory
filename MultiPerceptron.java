/** *****************************************************************************                                                                                                                 
 *  Name:        Jamie  and Stanley                                                                                                                                                     
 *  DOE Name:    Jawad Sifat and Stanley Zheng                                                                                                                                   
 *                                                                                                                                                                                                
 *  Title:  MultiPerceptron
 *
 *  Description:  Implement a MultiPerceptron class using Perceptron
 *
 *  Written:            3/3/2022
 *  Last updated:       3/7/2022
 *  Assignment Due:     3/8/2022
 *
 *  Compilation:   javac -classpath .:stdlib.jar MultiPerceptron.java
 *  Execution:     java -classpath .:stdlib.jar MultiPerceptron
 *  
 *  Expectation: Prints to standard output a training of MultiPerceptron on four input vectors
 * 
 *   Example: 
 *   % java -classpath .:stdlib.jar MultiPerceptron
 *   ((0.0, 0.0, 0.0),(0.0, 0.0, 0.0))
 *   ((5.0, -4.0, 3.0),(5.0, -4.0, 3.0))
 *   ((7.0, -1.0, 1.0),(7.0, -1.0, 1.0))
 *   ((7.0, -1.0, 1.0),(7.0, -1.0, 1.0))
 *   ((1.0, -6.0, 8.0),(1.0, -6.0, 8.0))
 *********************************************************************************** */

public class MultiPerceptron {
    private int m,n;
    private Perceptron[] perceptrons;
    // Creates a multi-perceptron object with m classes and n inputs.
    public MultiPerceptron(int m, int n) {
        this.m = m;
        this.n = n;
        perceptrons = new Perceptron[m];
        for (int i = 0; i < perceptrons.length; i++) {
            perceptrons[i] = new Perceptron(n);
        }
    }

    // Returns the number of classes m.
    public int numberOfClasses() {
        return m;
    }

    // Returns the number of inputs n (length of the feature vector).
    public int numberOfInputs() {
        return n;
    }

    // Returns the predicted label (between 0 and m-1) for the given input.
    public int predictMulti(double[] x) {
        int largestIndex = 0;
        int largest = perceptrons[0].predict(x);
        for (int i = 0; i< perceptrons.length;i++) {
            int curr = perceptrons[i].predict(x);
            if (curr > largest) {
                largest = curr;
                largestIndex = i;
            }
        }
        return largestIndex;
    }

    // Trains this multi-perceptron on the labeled (between 0 and m-1) input.
    public void trainMulti(double[] x, int label) {
        for (int i = 0; i< perceptrons.length;i++) {
            perceptrons[i].train(x,label);
        }
    }

    // Returns a string representation of this MultiPerceptron.
    public String toString() {
        String out = "(";
        for (Perceptron x:perceptrons) {
            out+= x.toString() + ",";
        }
        String finalOut = out.substring(0,out.length()-1);
        finalOut += ")";
        return finalOut;
    }

    // Tests this class by directly calling all instance methods.   
    public static void main(String[] args) {
        int m = 2;
        int n = 3;

        double[] training1 = {  5.0, -4.0,  3.0 };  // class 1
        double[] training2 = {  2.0,  3.0, -2.0 };  // class 0
        double[] training3 = {  4.0,  3.0,  2.0 };  // class 1
        double[] training4 = { -6.0, -5.0,  7.0 };  // class 0

        MultiPerceptron perceptron = new MultiPerceptron(m, n);
        StdOut.println(perceptron);
        perceptron.trainMulti(training1, 1);
        StdOut.println(perceptron);
        perceptron.trainMulti(training2, 0);
        StdOut.println(perceptron);
        perceptron.trainMulti(training3, 1);
        StdOut.println(perceptron);
        perceptron.trainMulti(training4, 0);
        StdOut.println(perceptron);

    }

}