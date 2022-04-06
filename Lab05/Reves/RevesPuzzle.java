/******************************************************************************
 *  Reiko Chen & Jawad Sifat 
 *  Compilation:  javac RevesPuzzle.java
 *  Execution:    java RevesPuzzle int
 *  Dependencies: 
 *
 *  % java RevesPuzzle n
 * 
 *  $ java RevesPuzzle 3
 *    move disc 1 from A to B
 *    move disc 2 from A to C
 *    move disc 3 from A to D
 *    move disc 2 from C to D
 *    move disc 1 from B to D
 *
 ******************************************************************************/
public class RevesPuzzle{
    public static int findK(int n){
	return n + 1 - (int) Math.pow(2 * n + 1, 0.5);
    }
    
    public static void helper(int disks, int start, int end, int spare1, int spare2){
    if(disks <= 0) return;
	if (disks == 1) {
        	System.out.println("move disk " + disks + " from peg " + letter(start) + " to peg " + letter(end));
        	return;
	}
    if(disks > 1){
    	helper(disks - 2, start, spare1, end, spare2);
        System.out.println("move disc " + (disks - 1) + " from peg " + letter(start) + " to peg " + letter(spare2));
        System.out.println("move disc " + disks + " from peg " + letter(start) + " to peg " + letter(end));
        System.out.println("move disc " + (disks - 1) + " from peg " + letter(spare2) + " to peg " + letter(end));
    	helper(disks - 2, spare1, end, spare2, start);
    }
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
	helper(n, 1, 4, 2, 3);
    }
}
