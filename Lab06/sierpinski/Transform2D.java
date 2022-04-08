/** ****************************************************************************************************************|                                                                                                                
 *  Name:        Jamie && Reiko                                                                                                                                                            
 *  DOE Name:    Jawad Sifat && Reiko Chen                                                                                                                                    
 *                                                                                                                                                                                                
 *  Title:  Transform2D LAB 6 PART I
 *
 *  Description:  This is the code for Transform 2D which allows us to manipulate polygons through a set of transformation
 * 					functions. 
 * 
 *  Written:       4/6/2022
 *  Last updated:  4/7/2022
 *
 *  Compilation:   javac -classpath .:stdlib.jar Transform2D.java
 *  Execution:     java  -classpath .:stdlib.jar Transform2D
 *  Expected output: see TranformDefaultOutput.txt attached.
 * 
 *  Dependencies/Packages Imported: Princeton Standard Libraries (stdlib.jar) && Java Array Utilities (toString and Equals)
 |******************************************************************************************************************/
import java.util.Arrays;

 public class Transform2D {

 	 /***********************************|
     * 
     * I. PRIVATE FUNCTIONS
     * 
     | **********************************/

	 /***********************************|
     * 
     * II. TRANSFORMATION FUNCTIONS
     * 
     * COPY:      Verified and Working
     * SCALE: 	  Verified and Working
     * TRANSLATE: Verified and Working
     * ROTATION:  Verified and Working
     | **********************************/


    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array){
		double[] out = new double[array.length];
		for(int i = 0; i < array.length; i++){
	    	out[i] = array[i];
		}
		return out;
    }

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha){
		for (int i = 0; i < x.length; i++){
	    	x[i] = x[i] * alpha;
	    	y[i] = y[i] * alpha;
    	}
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy){
    	for (int i = 0; i < x.length; i++){
    		x[i] += dx;
    		y[i] += dy;
    	}
    	return;
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotateRectangular(double[] x, double[] y, double theta){
    	theta = Math.toRadians(theta);
    	for (int i = 0; i < x.length; i++){
    		double temp = x[i];
    		x[i] = x[i] * Math.cos(theta) - y[i] * Math.sin(theta);
    		y[i] = temp * Math.sin(theta) - y[i] * Math.cos(theta);
    	}
    	return;
    }

    public static void rotate(double[] x, double[] y, double theta){
    	theta = Math.toRadians(theta);
    	for (int i = 0; i < x.length; i++){
    		if (x[i] == 0 && y[i] == 0) { continue; } 
    		double r 	      = Math.sqrt(  (x[i] * x[i]) + (y[i] * y[i])  );
    		double polarTheta = Math.atan(y[i] / x[i]);
    		polarTheta        += theta;
    		x[i] 			  = r * Math.cos(polarTheta);
    		y[i]			  = r * Math.sin(polarTheta);
    	}
    	return;
    }

     /***********************************|
     * 
     * III. MAIN CLIENT
     * 
     | **********************************/
    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {
	// Set the x- and y-scale
    double low = -15.0;
    double high = 15.0;
	StdDraw.setScale(low, high);
	StdOut.printf("A window opened to display the computer generated drawing, the panel has scale (%.1f && %.1f)%n%n%n", low, high);

	// Create original polygon
	double[] x = { 0, 1, 1, 0 };
	StdOut.printf("The double array of x coords given is %s%n%n", Arrays.toString(x));
	double[] y = { 0, 0, 2, 1 };
	StdOut.printf("The double array of y coords given is %s%n%n", Arrays.toString(y));

	// Copy original polygon
	double[] cx = copy(x);
	StdOut.printf("The double array cx copied the x coordinates of the double array x, the equality is %b%n %s %n ", Arrays.equals(cx, x), Arrays.toString(cx) );
	double[] cy = copy(y);
	StdOut.printf("The double array cy copied the y coordinates of the double array y, the equality is %b%n %s %n", Arrays.equals(cy, y), Arrays.toString(cy)  );

	// Rotate and translate the copy
	double rotateBy = 45.0;
	double tX 		= 1.0;
	double tY 		= 2.0;
	rotate(cx, cy, rotateBy);
	translate(cx, cy, tX, tY);
	StdOut.printf("After a rotation of %.1f degrees and translation of %.1fX and %.1fY%n, the coordinates of c are %nX: %s &%n Y: %s %n%n", rotateBy, tX, tY, Arrays.toString(cx), Arrays.toString(cy));
	double scale = 2.0;
	scale(cx, cy, scale);
	StdOut.printf("We then dilate the polygon by a scale factor of %f which transforms the coordinates to %n X: %s & %n Y: %s %n%n ", scale, Arrays.toString(cx), Arrays.toString(cy));

	// Draw the copy in blue
	StdDraw.setPenColor(StdDraw.BLUE);
	StdDraw.polygon(cx, cy);

	// Draw the original polygon in red
	StdDraw.setPenColor(StdDraw.RED);
	StdDraw.polygon(x, y);
    }

/**************************************************************************************************************************************|
* 
* IV. END OF FILE
* 
| **************************************************************************************************************************************/
}
