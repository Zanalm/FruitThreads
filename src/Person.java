import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Person implements Runnable {

	private String name;
	private int level;

	public Person(String name) {
		// I need a max and min value!!!!!
		// 90-30+1=61 and 30 needs to be added to the result. Range from 30-90
		Random ran = new Random();
		level = ran.nextInt(61) + 30;
		this.name = name;
		System.out.println(this.name + " created with " + "an energy of " + level);
	}

	void EnergyPower() {
		try {
			level -= 10; // descrese energy by 10 every secod
			System.out.println(name + " " + level);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	void Hungry() {
		if(level > 20) {
			// do what when not hungry
			System.out.println("not hungry" + level);
			
		}else if(level < 20) {
			// do what when hungry??
			System.out.println("hungry" + level);
		}
	}
	
	@Override
	public void run() {
		// fix the loop so that it makes sense
		while(level > 10) {
		EnergyPower();
		Hungry();
		}
		System.out.println(name + " is dead");

	}

}