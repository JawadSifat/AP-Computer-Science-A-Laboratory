import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;


public class ImageClassifier {

	// Creates a feature vector (1D array) from the given picture.
    public static double[] extractFeatures(Picture picture){
    	double[][] matrix = new double[picture.height()][picture.width()];
    	for (int row = 0; row < picture.height(); row++){
    		for (int col = 0; col < picture.width(); col++){
    			matrix[row][col] = 1.0 * picture.get(row, col).getBlue();
    		}
    	}

    	ArrayList<Double> grayScale = new ArrayList<Double>();
   		for (int row = 0; row < picture.height(); row++){
    		for (int col = 0; col < picture.width(); col++){
    			grayScale.add(matrix[row][col]);
    		}
    	}

    	double[] out = new double[picture.height() * picture.width()];
        for (int i = 0; i < out.length; i++){
            out[i] = grayScale.get(i);
        }

    	return out;
    }

    // See below.
    public static void main(String[] args){
    	In trainingFile = new In(args[0]);
    	In testingFile  = new In(args[1]);


    	int m1 = trainingFile.readInt();
    	int w1 = trainingFile.readInt();
    	int h1 = trainingFile.readInt();

    	ArrayList<String>  trainingFileNames = new ArrayList<String>();
    	ArrayList<Integer> trainingLabel 	 = new ArrayList<Integer>();

    	while (!trainingFile.isEmpty()){
    		trainingFileNames.add(trainingFile.readString());
    		trainingLabel.add(trainingFile.readInt());
    	}

        /*
    	for (int i = 0; i < 12; i++){
    		StdOut.printf("Filename: %s Label: %d %n", trainingFileNames.get(i), trainingLabel.get(i));
    	}
        */


    	int m2 = testingFile.readInt();
    	int w2 = testingFile.readInt();
    	int h2 = testingFile.readInt();

    	ArrayList<String> testingFileNames  = new ArrayList<String>();
    	ArrayList<Integer> testingLabel 	= new ArrayList<Integer>();

    	while (!testingFile.isEmpty()){
    		testingFileNames.add(testingFile.readString());
    		testingLabel.add(testingFile.readInt());
    	}
        /*
    	for (int i = 0; i < 12; i++){
    		StdOut.printf("Filename: %s Label: %d %n", testingFileNames.get(i), testingLabel.get(i));
    	}

        */
        int success = 0;
        int failure = 0;
        MultiPerceptron main = new MultiPerceptron(m1, w1 * h1);
        int[] numbers = new int[10];

        for (int i = 0; i < trainingFileNames.size(); i++){
            Picture currentPicture = new Picture(trainingFileNames.get(i));
            int currentLabel = trainingLabel.get(i);
            //currentPicture.show();
            //StdOut.println(currentLabel);
            double[] pictureExtract = extractFeatures(currentPicture);
            //StdOut.println(Arrays.toString(pictureExtract));            
            main.trainMulti(pictureExtract, currentLabel);
        }

        for (int i = 0; i < testingFileNames.size(); i++){
            Picture testingPicture = new Picture(testingFileNames.get(i));
            int currentTestingLabel = testingLabel.get(i);
            //testingPicture.show();
            double[] testingPictureExtract = extractFeatures(testingPicture);
            if (main.predictMulti(testingPictureExtract) == currentTestingLabel){
                success++;
            }
            else{
                failure++;
                numbers[currentTestingLabel]++;
                //testingPicture.show();
                //StdOut.println(trainingFileNames.get(i));
            }
        }


        StdOut.printf("Test Error Rate: %f %n", (1.0 * failure) / (success + failure));
        StdOut.printf("Digits by order of misclassification: %s", Arrays.toString(numbers));
        }
}
