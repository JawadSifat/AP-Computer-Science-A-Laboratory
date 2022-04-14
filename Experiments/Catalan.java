import java.util.Arrays;

public class Catalan {

	public static long catalanNumberHelper(int n, long prev){
		long out = (2 * ((2 * n) + 1)) / (n + 2);
		out  	 = out * prev;
		return out;
	}

	public static void catalanPrint(long[] array){
		System.out.print("[");
		for (long x : array){
			if (x == 0) { break; }
			System.out.print(x + ", ");
		}
		System.out.println("]");
	}

	public static long catalanNumber(int k){
		long[] sequence = new long[(k + 1)];
		sequence[0] = 1;
		for (int i = 1; i <= k; i++){
			StdOut.printf("Going to calculate C_%d sub %d + 1%n", i, sequence[i - 1]);
			StdOut.printf("CatalanCalc: %d and %d is %d%n", i-1, i, catalanNumberHelper(i-1, i + 1));
			sequence[i] = catalanNumberHelper(i - 1, i + 1);		// i = n + 1 
			catalanPrint(sequence);
		}
		catalanPrint(sequence);
		return sequence[k];
	}

	public static void main(String[] args){

		int k = StdIn.readInt();

		StdOut.println(catalanNumber(k));
	}

}