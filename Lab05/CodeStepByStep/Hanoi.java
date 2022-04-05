public class Hanoi {

	public static int spare(int start, int end) {
    if (start != 1 && end != 1) return 1;
    if (start != 2 && end != 2) return 2;
    return 3;
   
}
public static void help(int disks, int start, int end, int spare) {
    if (disks== 1) {
        System.out.println("move disk " + disks + " from peg " + start + " to peg " + end);
        return;
    }
    help(disks - 1, start, spare(start, end), end);
    System.out.println("move disk " + disks + " from peg " + start + " to peg " + end);
    help(disks -1, spare(start, end), end, start);
}
public static void hanoi(int disks, int start, int end){
    help(disks, start, end, spare(start, end));
}

	public static void main(String[] args){
		
	}
}