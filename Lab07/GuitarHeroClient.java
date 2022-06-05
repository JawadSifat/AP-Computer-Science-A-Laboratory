/*************************************************************************
 * Name                       : Jamie S. 
 * Date Created               : June 4 2022
 * Date Last Updated          : June 4 2022
 * Compilation                : javac RingBuffer.java
 * Execution                  : java  RingBuffer
 * Expected Location          : /RingBuffer.java
 * 
 * 
 * Purpose: To act as a client to GuitarHero.
 * 
 * 
 *****************************************************************************/


public class GuitarHeroClient {


	public static void main(String[] args){
		GuitarHero main = new GuitarHero();
		while (true){
			if (StdDraw.hasNextKeyTyped()){
				char key  = StdDraw.nextKeyTyped();
				int index = main.keyboard().indexOf(key);
				main.strings()[index].pluck();
			}


			double sample = 0.0;

			for (GuitarString string : main.strings()){
				sample += string.sample();
			}

			StdAudio.play(sample);
			

			for (GuitarString string : main.strings()){
				string.tic();
			}

		}
	}
}