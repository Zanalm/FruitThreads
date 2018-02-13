import java.util.Random;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class GruThreadFactory implements ThreadFactory {

	static final AtomicInteger poolNumber = new AtomicInteger(1);
	final ThreadGroup group;
	final AtomicInteger threadNumber = new AtomicInteger(1);
	final int namePrefix;
	final String[] persons;

	public GruThreadFactory(String[] persons) {
		SecurityManager s = System.getSecurityManager();
		group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
		namePrefix = poolNumber.getAndIncrement();
		this.persons = persons;
	}

	@Override
	public Thread newThread(Runnable r) {
		int index = new Random().nextInt(persons.length);
		final Thread t = new Thread(group, r, namePrefix + persons[index], 0);
		if (t.isDaemon())
			t.setDaemon(false);
		if (t.getPriority() != Thread.NORM_PRIORITY)
			t.setPriority(Thread.NORM_PRIORITY);
		return t;
	}

}
