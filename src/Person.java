import java.util.Random;

public class Person implements Runnable {

	private String name;
	private int level;
	// private int energy;
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
			if ((level < 20) && (level > 0)) {
				System.out.println(name + " has " + level + " energy and is hungry...");
				Fruit fruit = takeFruit();
				if (fruit != null)
					consumeFruit(fruit);
			}
		}
		if (level <= 0)
			System.out.println(name + " be dead... Rest In Pieces");
		else
			System.out.println("Bag is empty... " + name + " is leaving the party");

		/*
		 * if (level > 20) { // do what when not hungry takeEnergy(); // the person will
		 * keep on losing energy //System.out.println("not hungry" + level); } else if
		 * (level <= 20 && level >= 0) { // sets the hungry-interval // do what when
		 * hungry?? System.out.println(name +
		 * " is dying for some more fruit. Energy level: " + level); int getEnergy =
		 * bag.RemoveFruit(); level += getEnergy; }
		 */
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
		while (level > 10) {
			takeEnergy();
			Hungry();
		}

	}

}