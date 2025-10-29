package Locks;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptTest {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1 acquired lock");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread 1 interrupted");
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 trying to acquire lock...");
            lock.lock(); // <---- this is a blocking call
            try {
                System.out.println("Thread 2 acquired lock");
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(2000);
            System.out.println("Main: interrupting Thread 2...");
            t2.interrupt();  // interrupt thread 2 while it’s waiting
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
