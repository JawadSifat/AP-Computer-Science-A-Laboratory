import java.util.ArrayList;

public class WaysToClimb {

	public static ArrayList<Integer> waysToClimbHelper(int n, ArrayList<Integer> out){
		if (n == 1) { out.add(1); return out;}
		out.add(1);
		return waysToClimbHelper(n-1, out);
	}

	public static void waysToClimb(int n){
		ArrayList<Integer> out = new ArrayList<Integer>();
		out = waysToClimbHelper(n, out);
		waysToClimbEditor(n, out);
	}

	public static void waysToClimbEditor(int n, ArrayList<Integer> out){
		

	}


	public static void main(String[] args){
		int n = StdIn.readInt();

		StdOut.printf("Given the number of stairs is %d our output is ", n); 
		waysToClimb(n);
		StdOut.println();
	}
}