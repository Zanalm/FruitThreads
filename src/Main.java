

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Bag bag = new Bag();
		Thread t1 = new Thread(new Person("Bertil", bag)); // Creating 3 new threads
														// symbolizing persons
														// with different names
		Thread t2 = new Thread(new Person("Klaes-Göran", bag));
		Thread t3 = new Thread(new Person("Kerstin", bag));
		t1.start(); // Starts the new thread by executing the method.
		t2.start();
		t3.start();
		
		
	}
}
