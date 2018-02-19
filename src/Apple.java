
public class Apple extends Fruit {
	private int energy;
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
