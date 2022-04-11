import java.util.Arrays;

public class CombinationsBottom {


	public static long combin(int n, int k){
		if (k == 0 || k == n) return 1;
		if (n <= 0 || k < 0 || k > n) return 0;
		long[] c = new long[n + 1];
		c[0] = 1; 
		c[1] = 2;
		for (int i = 2; i <= c.length; i++){
			c[i] = 2 + ( 2 * (c[i - 1] + c[i - 2]) );
			System.out.println(Arrays.toString(c));
		}
		return c[k];

	}

	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);

		System.out.println(combin(n, k));
	}
}