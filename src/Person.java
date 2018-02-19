import java.util.Random;

public class Person implements Runnable {

	private String name;
	private int level;
	private Bag bagOfFruits;

	// Constructor
	public Person(String name, Bag bag) {
		bagOfFruits = bag;
		// formula: 90-30+1=61 and 30 needs to be added to the result. Range from 30-90
		Random ran = new Random();
		level = ran.nextInt(61) + 30;
		this.name = name;
		System.out.println(name + " created with " + "an energy of " + level);
	}

	void takeEnergy() {
		try {
			level -= 10; // Decrease the persons energy by 10 every second
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	void Hungry() {
		while ((level > 0) && Bag.fruitInBag()) {
			takeEnergy();
			if ((level < 20) && (level > 0)) { // What will happen if a person is hungry (their energy-level is between 0-20)
				System.out.println(name + " has " + level + " energy and is hungry...");
				Fruit fruit = takeFruit();
				if (fruit != null)
					consumeFruit(fruit);
			}
		}
		if (level <= 0) {
			System.out.println(name + " starved to death. Poor" + name);
		}
		else
			System.out.println("We ran out of fruits in the bag. " + name + " is now going home");
	}

	private Fruit takeFruit() {
		Fruit fruit = bagOfFruits.RemoveFruit();
		if (fruit != null)
			System.out.println(name + " picked " + fruit.fruitName() + " and indulge in it");
		return fruit;
	}

	public void consumeFruit(Fruit eatingFruit) {
		level += eatingFruit.energy();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " grabbed a " + eatingFruit.fruitName() + " with " + eatingFruit.energy()
				+ " energy and now has " + level + " energy. Good for them");
	}

	@Override
	public void run() {
		while (level > 10) { // will run while energy-level is above 10
			takeEnergy();
			Hungry();
		}

	}

}