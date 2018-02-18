

public class Main {

	public static void main(String[] args) {
		Bag bag = new Bag();
		Thread t1 = new Thread(new Person("Bertil")); // Creating 3 new threads
														// symbolizing persons
														// with different names
		Thread t2 = new Thread(new Person("Klaes-Göran"));
		Thread t3 = new Thread(new Person("Kerstin"));
		t1.start(); // Starts the new thread by executing the method.
		t2.start();
		t3.start();
	}
}
