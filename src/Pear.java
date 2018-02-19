/*import java.util.Random;*/

public class Pear extends Fruit {
	private int energy;
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
