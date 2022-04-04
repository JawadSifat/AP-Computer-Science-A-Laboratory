/******************************************************************************
 *  Reiko Chen & Jawad Sifat 
 *  Compilation:  javac RevesPuzzle.java
 *  Execution:    java RevesPuzzle int
 *  Dependencies: 
 *
 *  % java RevesPuzzle n
 *
 ******************************************************************************/

public class RevesPuzzle{
    public static int findK(int n){
	return n + 1 - (int) Math.pow(2 * n + 1, 0.5);
    }
    
    public static void helper(int n, int k, int start, int end){}

    public static int spare(){}
    
    public static void main(String args[]){
	int n = Integer.parseInt(args[0]);
	int k = findK(n);
	//A = 1, B = 2, C = 3, D = 4
	helper();
    }
}
