import java.util.ArrayList;
import java.util.Random;

public class Bag {
	Random rand;
	static ArrayList<Fruit> fruitBag = new ArrayList<Fruit>();
	// fix public functions for adding and removing fruits. they will be called in
	// person and main

	public Bag() {
		rand = new Random();
		createFruits(20);
		System.out.println("----Fruit bag created with " + fruitBag.size() + " fruits----");
		/*
		 * for (int i = 0; i < 20; i++) { // need to fix it, for now this'll generate
		 * 3*20 fruits fruitBag.add(new Pear()); fruitBag.add(new Banana());
		 * fruitBag.add(new Apple()); } System.out.println(fruitBag.size());
		 */
	}

	public synchronized Fruit RemoveFruit() {
		Fruit fruit = null;
		if (fruitBag.size() > 0) {
			fruit = fruitBag.get(0);
			fruitBag.remove(0);
			RandomFruit();
		} else {
			System.out.println("Fruit bag is empty. Exiting.");
		}
		System.out.println("----Bag now contains: " + fruitBag.size() + " fruits----");
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
				//System.exit(1);
			}
			fruitBag.add(fruit);
			System.out.println(
					"- " + fruit.fruitName() + " with " + fruit.energy() + " energy was added to the fruit bag-");
		}
	}

	

	/*
	 * Fruit getFruit = fruitBag.get(fruitBag.size() - 1);
	 * //System.out.println("gklghg" + getFruit.energy());
	 * fruitBag.remove(fruitBag.size() - 1); System.out.println(getFruit.fruitName()
	 * + getFruit.energy()); return getFruit.energy();
	 */
	// this needs to check if a person is hungry, and let the person take a fruit,
	// then
	// the fruit will be removed from the ArrayList
	/*
	 * private static Fruit get(int i) { // TODO Auto-generated method stub return
	 * null; }
	 */

	public void RandomFruit() {
		Random r = new Random();
		int surpriseFruit = r.nextInt(100);
		if (surpriseFruit < 20) { // 20% chance
			createFruits(5);
		}

	}
	
	// get this to work... threads should terminate when bag is empty
	public boolean emptyBag() {
		boolean a = false;
		if (fruitBag.size() == 0) {
			System.out.println("innanför");
			a= true;
		}
		return a;
	}
	/*
	 * public void newFruits(String fruitName) { // For creating new fruits in the
	 * bag //int drawFruit = switch (fruitName) { case "Pear": fruitBag.add(new
	 * Pear()); break; case "Apple": fruitBag.add(new Apple()); break; case
	 * "Banana": fruitBag.add(new Banana()); break; } System.out.println(fruitName +
	 * "energy: " + fruitBag.get(fruitBag.size() -1).energy() + "blubb blubb");
	 * 
	 * }
	 */

}