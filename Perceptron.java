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
    	
    	Perceptron test = new Perceptron(3);
    	System.out.println("number of inputs: " + test.numberOfInputs());
    	double[] x = {5,-4,3};
    	System.out.println("weighted sum: " + test.weightedSum(x));
    	System.out.println("predict: " + test.predict(x));
    	System.out.println(test);
    	test.train(x,1);
    	System.out.println(test);
    }

}