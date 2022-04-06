import java.util.ArrayList;

public class MatchCount {

	public static int matchCount(ArrayList<Integer> v1, ArrayList<Integer> v2){
		if (v1.size() == 0 || v2.size() == 0) { return 0; }				// base case
		int v1Top  = v1.remove(0);										// e.remove() returns the element that you removed
		int v2Top  = v2.remove(0);										// Saves the two values
		int count  = ((v1Top == v2Top) ? 1 : 0) + matchCount(v1, v2);	// Test if the value is equal or not
		v1.add(0, v1Top); 												// Repopulate
		v2.add(0, v2Top);						
		return count;													//Integer exit for total number of matches. 

	}

	public static void main(String[] args){
		ArrayList<Integer> v1 = new ArrayList<Integer>();
		v1.add(2);v1.add(5);v1.add(0);v1.add(3);v1.add(8);v1.add(9);v1.add(1);v1.add(1);v1.add(0);v1.add(7);
		ArrayList<Integer> v2 = new ArrayList<Integer>();
		v2.add(2);v2.add(5);v2.add(3);v2.add(0);v2.add(8);v2.add(4);v2.add(1);

		System.out.println(v1);
		System.out.println(v2);

		System.out.printf("The amount of matches between these two arraylists is calculated to %d%n", matchCount(v1, v2));

	}
}