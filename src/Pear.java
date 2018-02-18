/*import java.util.Random;*/

public class Pear extends Fruit {
	private int energy;
/*	Random ran = new Random();
	// 40-20+1=21 and 20 needs to be added to the result. Range from 20-40
	int x = ran.nextInt(21) + 20;*/

	public Pear() {
		energy = addEnergy(20, 40); // This is the energy-interval for the fruit, also calls the addEnergy-method for the random values
	}
	
	@Override
	public int energy() {
		return energy;
	}

	@Override
	public String fruitName() {
		return "Pear";
	}

}
