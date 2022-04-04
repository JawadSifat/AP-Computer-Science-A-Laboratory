public class PrintBinary {

	public static void printBinary(int n){
		if (n == 0) { System.out.print("0"); return; }

		if (n < 0) {
			System.out.print("-");
			n = Math.abs(n);
		}

		if (n == 1) { System.out.print("1"); return; } 

		printBinary(n / 2);
		System.out.print(n % 2);
	}


	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);

		printBinary(n);
	}
}