import java.util.Random;

public abstract class Fruit {
	// print out the information about the fruits, energy and stuff

	public abstract int energy(); // For returning the energy
	public abstract String fruitName(); // returning the name
	
	// This is for the randomized energy for fruit
	public int addEnergy(int min, int max) {
		Random randomInt = new Random();
		 int randomNumber = randomInt.nextInt((max - min) + 1) + min;
		 return randomNumber;
		
		
	}

}
