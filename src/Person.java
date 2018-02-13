import java.util.Random;


public class Person implements Runnable {
    
    private static String[] fruits = {"apple", "banana", "Pear"}; 
    
    public Person() {
     
    }

    @Override
    public void run() {
        try {
            // banana or apple
            int idx = new Random().nextInt(fruits.length);
            System.out.printf("Person %s eating %s %n", Thread.currentThread().getName(), fruits[idx]);
            Thread.sleep((idx * 1000) + 10000);
            System.out.printf("Person %s done eat %s %n", Thread.currentThread().getName(), fruits[idx]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}