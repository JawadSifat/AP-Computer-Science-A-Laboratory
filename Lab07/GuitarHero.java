public class GuitarHero {

	private String keyboard        = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
	private GuitarString[] strings  = new GuitarString[37];

	public GuitarHero(){
		for (int i = 0; i < 37; i++){
			double frequency = 440 * Math.pow(2, ((i - 24.0) / 12.0) );
			strings[i] = new GuitarString(frequency);
		}
	}


	public String keyboard(){
		return keyboard;
	}

	public GuitarString[] strings(){
		return strings;
	}
}