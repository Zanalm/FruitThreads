import java.util.Random;

public class Person implements Runnable {

	private String name;
	private int level;
	//private int energy;
	private Bag bag;

	public Person(String name) {
		// 90-30+1=61 and 30 needs to be added to the result. Range from 30-90
		Random ran = new Random();
		level = ran.nextInt(61) + 30;
		this.name = name;
		System.out.println(this.name + " created with " + "an energy of " + level);
	}

	void takeEnergy() {
		try {
			level -= 10; // Decrease the persons energy by 10 every second
			//System.out.println(name + " " + level);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


	void Hungry() {
			while ((level > 0) && bag.fruitInBag()) {
				takeEnergy();
				if ((level < 20) && (level > 0)) {
					System.out.println(this.name + " has " + this.level + " energy and is hungry...");
					Fruit fruit = takeFruit();
					if (fruit != null)
						consumeFruit(fruit); // If the Person got a fruit, it then eats it
				}
			}
			if (level <= 0)
				System.out.println(this.name + " be dead... Rest in Pieces"); // If the Person's life is less or =
																						// to zero, print this message
			else
				System.out.println("Bag is empty... " + this.name + " is leaving the party"); // If there's no fruit left,
																								// print this
		/*if (level > 20) {
			// do what when not hungry
			takeEnergy(); // the person will keep on losing energy
			//System.out.println("not hungry" + level);
		} else if (level <= 20 && level >= 0) { // sets the hungry-interval
			// do what when hungry??
			System.out.println(name + " is dying for some more fruit. Energy level: " + level);
			int getEnergy = bag.RemoveFruit();
			level += getEnergy;
		}*/
	}
	private Fruit takeFruit() {
		Fruit fruit = Bag.RemoveFruit();
		if (fruit != null)
			System.out.println(this.name + " picked " + fruit.fruitName() + " and indulge in it");
		return fruit;
	}
	private void consumeFruit(Fruit fruitToEat) {
		level += fruitToEat.energy();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.name + " ate " + fruitToEat.fruitName() + " with " + fruitToEat.energy()
				+ " energy and now has " + this.level + " energy. Good for them");
	}

	@Override
	public void run() {
		// fix the loop so that it makes sense
		while (level > 10) {
			takeEnergy();
			Hungry();
		}
		System.out.println(name + " is dead");

	}

}