public class DigitSum {


	public static int digitSum(int n){
        if (n == 0) { return n; }
		if (n < 0 && n > -10) { return n; }
		else if (n < 10 && n > 0) { return n; }
		return digitSum(n / 10) + (n % 10);
	}


	public static void main(String[] args){
		int n = StdIn.readInt();

		StdOut.printf("Doing mod %d by 10 is equal to %d%n%n", n, (n % 10));

		StdOut.printf("Doing %d floormod by 10 is equal to %d%n", n, Math.floorMod(n, 10));

		StdOut.printf("The sum of all the digits in %d is %d%n", n, digitSum(n));
	}
}