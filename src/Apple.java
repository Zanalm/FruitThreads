/*import java.util.Random;*/

public class Apple extends Fruit {
	private int energy;

	/*
	 * Random ran = new Random(); // 30-20+1=11 and 20 needs to be added to the
	 * result. Range from 20-30 int x = ran.nextInt(11) + 20;
	 */

	public Apple() {
		energy = addEnergy(20, 30); // This is the energy-interval for the fruit
	}

	@Override
	public int energy() {
		return energy;
	}

	@Override
	public String fruitName() {
		return "Apple";
	}
}
