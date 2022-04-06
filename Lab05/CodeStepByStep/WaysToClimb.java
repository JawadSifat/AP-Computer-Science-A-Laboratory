import java.util.ArrayList;

public class WaysToClimb {

	public static void waysToClimb(int s, ArrayList<Integer> temp){
    		if(s < 0){
        		return;}
    		if(s == 0 && !temp.isEmpty()){
        		System.out.println(temp);
        		return;
    			}
    
    		if (s > 0) {
        		temp.add(1);
        		waysToClimb(s - 1, temp);
        		temp.remove(temp.size() - 1);
        
        		temp.add(2);
        		waysToClimb(s - 2, temp);
        		temp.remove(temp.size() - 1);
    		}
	}

	public static void waysToClimb(int stairs){
    		ArrayList<Integer> temp = new ArrayList<Integer>();
   	 	waysToClimb(stairs, temp);
	}


	public static void main(String[] args){
		int n = StdIn.readInt();

		StdOut.printf("Given the number of stairs is %d our output is ", n); 
		waysToClimb(n);
		StdOut.println();
	}
}
