import java.util.Arrays;
import java.util.ArrayList;

public class CombinationsBottom {

	private static long factorial(long x){
		if (x == 1) return 1;
		return x * factorial(x - 1);
	}

	public static long combin(int n, int k){
		if (k == 0 || k == n) return 1;
		if (n <= 0 || k < 0 || k > n) return 0;
		ArrayList<Long> out = new ArrayList<Long>();
		return (factorial(n)) / (factorial(n - k) * factorial(k));
	}

	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);

		System.out.println(factorial(n) + " AND " + factorial(k));
		System.out.println(combin(n, k));
	}
}