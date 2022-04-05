/******************************************************************************
 *  Reiko Chen & Jawad Sifat 
 *  Compilation:  javac RevesPuzzle.java
 *  Execution:    java RevesPuzzle int
 *  Dependencies: 
 *
 *  % java RevesPuzzle n
 *
 ******************************************************************************/
//Not tested yet
public class RevesPuzzle{
    public static int findK(int n){
	return n + 1 - (int) Math.pow(2 * n + 1, 0.5);
    }
    
    public static void helper(int disks, int start, int end, iint spare){
	if (disks == 1) {
        	System.out.println("move disk " + disks + " from peg " + letter(start) + " to peg " + letter(end));
        	return;
	}
    	helper(disks - 1, start, spare(start, end), end);
    	System.out.println("move disk " + disks + " from peg " + letter(start) + " to peg " + letter(end));
    	helper(disks - 1, spare(start, end), end, start);
    }


    public static int spare(int start, int end){
	if (start != 1 && end != 1) return 1;
	if (start != 2 && end != 2) return 2;
	if (start != 3 && end != 3) return 3;
    	return 4;
    }
	
    public static String letter(int num){
	if (num == 1) return "A";
	if (num == 2) return "B";
	if (num == 3) return "C";
	return "D";
    }
    
    public static void main(String args[]){
	int n = Integer.parseInt(args[0]);
	int k = findK(n);
	//A = 1, B = 2, C = 3, D = 4
	helper(k, 1, 2, spare(start, end));
	helper(n - k, 1, 4, spare(start, end));
	helper(k, 2, 4, spare(start, end));
    }
}
