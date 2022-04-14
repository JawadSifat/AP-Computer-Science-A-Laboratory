import java.util.Arrays;

public class BetterCatalan {


	public static long catalanHelper(long k, long prev){
		return prev * 2 * (2 * k - 1) / (k + 1); 
	}

	public static long catalanNumber(int n){
		long[] sequence = new long[n + 1];
		sequence[0] 	= 1;
		for (int i = 0; i + 1 < sequence.length; i++){
			StdOut.printf("The Catalan sequence is %s%n", Arrays.toString(sequence));
			sequence[i + 1] = catalanHelper(i + 1, sequence[i]);
		}
		StdOut.printf("Final: %s%n", Arrays.toString(sequence));
		return sequence[n];
	}

	public static long catalan(int k){	
		if (k == 0) return 1;
		long[] val = new long[k + 1];
		val[0] = 1;
		for (int i = 1; i <= k; i++){
			val[i] = val[i - 1] * (4 * i - 2) / (i + 1);
			StdOut.printf("%s%n", Arrays.toString(val));
		}

		StdOut.printf("Final: %s%n", Arrays.toString(val));
		return val[k];
	}

	public static void main(String[] args){
		int k = Integer.parseInt(args[0]);

		StdOut.println(catalan(k));
		StdOut.printf("%n%n Vs. my Catalan%n");
		StdOut.println(catalanNumber(k));
	}
}



