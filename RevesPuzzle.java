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
    
    public static void helper(int n){}

    public static int spare(){return 1;}
    
    public static void main(String args[]){
	int n = Integer.parseInt(args[0]);
	int k = findK(n);
	helper();
    }
}
