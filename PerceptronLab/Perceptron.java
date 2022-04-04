/** *****************************************************************************                                                                                                                 
 *  Name:        Jamie  and Stanley                                                                                                                                                     
 *  DOE Name:    Jawad Sifat and Stanley Zheng                                                                                                                                   
 *                                                                                                                                                                                                
 *  Title:  Perceptron Object class
 *
 *  Description:  Builds a perceptron data type that can train itself on data. 
 *
 *  Written:            3/3/2022
 *  Last updated:       3/7/2022
 *  Assignment Due:     3/8/2022
 *
 *  Compilation:   javac -classpath .:stdlib.jar Perceptron.java
 *  Execution:     java -classpath  .:stdlib.jar Perceptron 
 *  
 *  Expectation: Trains itself by going through the weighted sum of arrays. 
 * 
 * Example Run:
 * java -classpath .:stdlib.jar Perceptron
 * (0.0, 0.0, 0.0)
 * (5.0, -4.0, 3.0)
 * (5.0, -4.0, 3.0)
 * (5.0, -4.0, 3.0)
 * (11.0, 1.0, -4.0)
 *********************************************************************************** */


import java.util.Arrays;

public class Perceptron {
	private int n;
	private double[] weights;
    // Creates a perceptron with n inputs.
    public Perceptron(int n) {
    	this.n = n;
    	weights = new double[n];
    }

    // Returns the number of inputs n.
    public int numberOfInputs() {
    	return n;
    }

    // Returns the weighted sum of the weight vector and x.
    public double weightedSum(double[] x) {
    	double out = 0;
    	for (int i = 0; i < x.length; i++) {
    		out+= x[i] * weights[i];
    	}
    	return out;
    }

    // Predicts the label (+1 or -1) of input x.
    public int predict(double[] x) {
    	if (weightedSum(x) > 0) return 1;
    	return -1;
    }

    // Trains this perceptron on the labeled (+1 or -1) input x.
    public void train(double[] x, int label) {
    	if (!(predict(x) == label)) {
    		if (predict(x) == 1) { //false positive
    			for(int i = 0; i < x.length;i++) {
    				weights[i] -= x[i];
    			}
    		}
    		else {
    			for(int i = 0; i < x.length;i++) { // false negative
    				weights[i] += x[i];
    			}
    		}
    	}
    }

    // Returns a string representation of this perceptron.
    public String toString() {
    	return Arrays.toString(weights).replace('[','(').replace(']',')');
    }

    // Tests this class by directly calling all instance methods.   
    public static void main(String[] args) {
        int n = 3;

        double[] training1 = {  5.0, -4.0,  3.0 };  // yes
        double[] training2 = {  2.0,  3.0, -2.0 };  // no
        double[] training3 = {  4.0,  3.0,  2.0 };  // yes
        double[] training4 = { -6.0, -5.0,  7.0 };  // no

        Perceptron perceptron = new Perceptron(n);
        StdOut.println(perceptron);
        perceptron.train(training1, +1);
        StdOut.println(perceptron);
        perceptron.train(training2, -1);
        StdOut.println(perceptron);
        perceptron.train(training3, +1);
        StdOut.println(perceptron);
        perceptron.train(training4, -1);
        StdOut.println(perceptron);

    }

}
