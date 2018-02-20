import java.util.ArrayList;
import java.util.Random;

public class Bag {
	Random rand;
	static ArrayList<Fruit> fruitBag = new ArrayList<Fruit>();

	public Bag() {
		rand = new Random();
		createFruits(20);
		System.out.println("----Fruit bag created with " + fruitBag.size() + " fruits----");
	}

	public synchronized Fruit RemoveFruit() {
		Fruit fruit = null;
		if (fruitBag.size() > 0) {
			fruit = fruitBag.get(0);
			System.out.println("----Bag now contains: " + fruitBag.size() + " fruits----");
			fruitBag.remove(0);
			RandomFruit();
		} else {
			System.out.println("Fruit bag is empty. Exiting.");
			System.exit(1);
		}
		return fruit;
	}

	public synchronized static boolean fruitInBag() {
		return fruitBag.size() > 0;
	}

	private void createFruits(int count) {
		int i;
		for (i = 0; i < count; ++i) {
			Fruit fruit = null;
			switch (rand.nextInt(3)) {
			case 0:
				fruit = new Apple();
				break;
			case 1:
				fruit = new Banana();
				break;
			case 2:
				fruit = new Pear();
				break;
			}
			if (fruit == null) {
				System.out.println("Failed creating fruit. Exiting...");
				 System.exit(1);
			}
			fruitBag.add(fruit);
			System.out.println(
					"- " + fruit.fruitName() + " with " + fruit.energy() + " energy was added to the fruit bag-");
		}
	}

	public void RandomFruit() {
		Random r = new Random();
		int surpriseFruit = r.nextInt(100);
		if (surpriseFruit < 20) { // 20% chance
			createFruits(5);
		}

	}



}