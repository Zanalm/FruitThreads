
// the site with this example http://blog.weetech.co/2014/11/how-to-set-java-thread-name-thread-pool.html
public class Main implements Runnable {
	private String toSay;

	public Main(String st) {
		toSay =	st;
		}

	public void run() {
		for (;;)
			System.out.println(toSay);
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thr1	= new Thread (new Main("hi"));
		Thread thr2	= new Thread (new Main("bye"));
		thr1.start();
		thr2.start();
	}

}