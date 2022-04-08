public class Sierpinski {

    // Height of an equilateral triangle with the specified side length.
    public static double height(double length){
	    return length * (Math.sqrt(3) / 2.0);
    }

    // Draws a filled equilateral triangle with the specified side length
    // whose bottom vertex is (x, y).
    public static void filledTriangle(double x, double y, double length){
	double[] a = {x, x - (height(length) / 2.0), x + (height(length) / 2.0)};
	double[] b = {y, y + height(length), y + height(length)};
	StdDraw.filledPolygon(a, b);
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled
    // triangle has the specified side length and bottom vertex (x, y).
    public static void sierpinski(int n, double x, double y, double length){}

    // Takes an integer command-line argument n;
    // draws the outline of an upwards equilateral triangle of length 1
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0);
    // and draws a Sierpinski triangle of order n that fits inside the outline.
    public static void main(String[] args){
	int n = Integer.parseInt(args[0]);
	double[] ufx = {0, 0.5, 1};
	double[] ufy = {0, (Math.sqrt(3) / 2.0),0};
	StdDraw.polygon(ufx, ufy);
	sierpinski(n);
    }
}
