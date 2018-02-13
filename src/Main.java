
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

// the site with this example http://blog.weetech.co/2014/11/how-to-set-java-thread-name-thread-pool.html
public class Main {

	public static void main(String[] args) throws InterruptedException {
		ThreadFactory GruFactory = null;
		ExecutorService exec = null;

		try {
			String[] Persons = { "Dave", "Stuart", "Kevin", "Jerry", "Carl", "Phil", "Paul", "Mike", "Jorge" };
			GruFactory = new GruThreadFactory(Persons);
			exec = Executors.newFixedThreadPool(Persons.length, GruFactory);

			for (int i = 0; i < 3; i++) { // 3 persons from the person-string
				Person m = new Person();
				exec.execute(m);
			}
			exec.shutdown();
			while (!exec.isTerminated()) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			System.out.println("done");
		}

	}

}