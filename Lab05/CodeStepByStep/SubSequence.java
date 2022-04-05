public class SubSequence {

	private static int counter = 0;

	/**
	 * 
	 * First word: Hello
	 * Second word: llo
	 * 
	 * 
	 * */

	public static boolean isSubsequenceConsecutive(String first, String second){
		/**
		 * Base Case
		 * */
		if (first.length() < second.length()) { return false; }
		if (first.substring(0, second.length()).equals(second)) { return true; }




		/**
		 * Debugging
		 * */
		//StdOut.printf("====Currently now, the first word is %s====%n", first);
		//counter += 1; 
		//StdOut.printf("isSubsequence was called %d times %n %n", counter);

		/**
		 * Recursive case
		 * */
		return isSubsequenceConsecutive(first.substring(1, first.length()), second);
	}

	public static boolean isSubsequence(String first, String second){
		if (second.length() == 0) { return true; }
		if (first.length() == 0) { return false; }
		if (first.charAt(0) == second.charAt(0)){
			second = second.substring(1);
			first  = first.substring(1);
			return isSubsequence(first, second);
		}
		return isSubsequence(first.substring(1), second);
	}

	public static void main(String[] args){
		String first  = args[0];
		String second = args[1];

		//StdOut.printf("First word is %s, the subword is supposed to be %s %n The program checks that this is [%b]. %nplease verify this yourself%n", first, second, isSubsequenceConsecutive(first, second));
		StdOut.printf("First word is %s, the subword is supposed to be %s %n The program checks that this is [%b]. %nplease verify this yourself%n", first, second, isSubsequence(first, second));

	}
}