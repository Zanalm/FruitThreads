
public class Banana extends Fruit {
	private int energy;

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
