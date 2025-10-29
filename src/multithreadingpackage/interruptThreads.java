package multithreadingpackage;

public class interruptThreads extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("Thread is running");
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted "+e);
        }

    }

    public static void main(String[] args) {
        interruptThreads t1 = new interruptThreads();
        t1.start();
        t1.interrupt();
    }
}
