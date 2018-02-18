import java.util.ArrayList;
import java.util.Random;

public class Bag {
	ArrayList<Fruit> fruitBag = new ArrayList<Fruit>();
	// fix public functions for adding and removing fruits. they will be called in
	// person and main

	public Bag() {
		for (int i = 0; i < 20; i++) { // need to fix it, for now this'll generate 3*20 fruits
			fruitBag.add(new Pear());
			fruitBag.add(new Banana());
			fruitBag.add(new Apple());
		}
		System.out.println(fruitBag.size());
	}

	public synchronized int RemoveFruit() {
		Fruit getFruit = fruitBag.get(fruitBag.size() - 1);
		//System.out.println("gklghg" + getFruit.energy());
		fruitBag.remove(fruitBag.size() - 1);
		System.out.println(getFruit.fruitName() + getFruit.energy());
		return getFruit.energy();
		
		// this needs to check if a person is hungry, and let the person take a fruit,
		// then
		// the fruit will be removed from the ArrayList
	}

	public void RandomFruit() {

	    Random r = new Random();
	    int surpriseFruit = r.nextInt(100);

	    if (surpriseFruit < 20){ // 20% chance
	        // do something when this is true
	    }
	    
	}

	public void newFruits(String fruitName) { // For creating new fruits in the bag
		//int drawFruit =
		switch (fruitName) {
		case "Pear": fruitBag.add(new Pear());
			break;
		case "Apple": fruitBag.add(new Apple());
			break;
		case "Banana": fruitBag.add(new Banana());
			break;
		}
		System.out.println(fruitName + "energy: " + fruitBag.get(fruitBag.size() -1).energy() + "blubb blubb");
		
		}
	
	
}