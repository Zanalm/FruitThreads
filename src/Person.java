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
			System.out.println(name + " " + level);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	void Hungry() {
		if (level > 20) {
			// do what when not hungry
			takeEnergy(); // the person will keep on losing energy
			System.out.println("not hungry" + level);
		} else if (level <= 20 && level >= 0) { // sets the hungry-interval
			// do what when hungry??
			System.out.println(name + " is dying for some more fruit. Energy level: " + level);
			int getEnergy = bag.RemoveFruit();
			level += getEnergy;
		}
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