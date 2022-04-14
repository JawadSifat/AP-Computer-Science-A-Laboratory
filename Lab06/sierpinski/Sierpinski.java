/** ****************************************************************************************************************|                                                                                                                
 *  Name:        Jamie && Reiko                                                                                                                                                            
 *  DOE Name:    Jawad Sifat && Reiko Chen                                                                                                                                    
 *                                                                                                                                                                                                
 *  Title:  Sierpinski LAB 6 PART I
 *
 *  Description: Recursive java file to create a Sierpinski triangle.
 * 
 *  Written:       4/7/2022
 *  Last updated:  4/8/2022
 *
 *  Compilation:   javac -classpath .:stdlib.jar Sierpinski.java
 *  Execution:     java  -classpath .:stdlib.jar Sierpinski
 * 
 *  Dependencies/Packages Imported: Princeton Standard Libraries (stdlib.jar)
 |******************************************************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle with the specified side length.
    public static double height(double length){
	    return length * (Math.sqrt(3) / 2.0);
    }

    // Draws a filled equilateral triangle with the specified side length
    // whose bottom vertex is (x, y).
    public static void filledTriangle(double x, double y, double length){
    	//top right
    	double x1 = x - (length / 2.0);
    	double y1 = y + height(length);
    	//top left
    	double x2 = x + (length / 2.0);
    	double y2 = y + height(length);

	double[] a = {x, x1, x2};
	double[] b = {y, y1, y2};
	StdDraw.filledPolygon(a, b);
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled
    // triangle has the specified side length and bottom vertex (x, y).
    public static void sierpinski(int n, double x, double y, double length){
	if (n == 0)
	    return;
	    filledTriangle(x, y, length);

    	double x0 = x - (length / 2.0);
    	double y0 = y;

    	double x1 = x + (length / 2.0);
    	double y1 = y;
    
    	double x2 = x;
    	double y2 = y + Math.sqrt(3) / 2.0 * length;

	    sierpinski(n - 1, x0, y0, length / 2.0);  //left
    	sierpinski(n - 1, x1, y1, length / 2.0);  //right
    	sierpinski(n - 1, x2, y2, length / 2.0);  //top
    }

    // Takes an integer command-line argument n;
    // draws the outline of an upwards equilateral triangle of length 1
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0);
    // and draws a Sierpinski triangle of order n that fits inside the outline.
    public static void main(String[] args){
    StdDraw.setScale(-2.0, 2.0);
	int n = Integer.parseInt(args[0]);
	double[] ufx = {0, 0.5, 1};
	double[] ufy = {0, (Math.sqrt(3) / 2.0),0};
	StdDraw.polygon(ufx, ufy);
	sierpinski(n, 1, 1, 0.5);
    }
}
