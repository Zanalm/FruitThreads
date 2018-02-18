
/*import java.util.Random;*/

public class Banana extends Fruit {
	private int energy;

	/*
	 * Random ran = new Random(); // This is the formula: 35-25+1=11 and 25 needs to
	 * be added to the result. Range from 25-35 int x = ran.nextInt(11) + 25;
	 */
	
	public Banana() {
		energy = addEnergy(25, 35); // This is the energy-interval for the fruit
	}

	@Override
	public int energy() {
		return energy;
	}

	@Override
	public String fruitName() {
		return "Banana";
	}
}
