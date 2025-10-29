package multithreadingpackage;

public class MyThreads extends Thread{
    @Override
    public void run() {
        System.out.println("Outside Running ");
        try {
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreads t1 = new MyThreads();
        System.out.println("1st "+t1.getState());
        t1.start();
        System.out.println("2nd "+t1.getState());
        Thread.sleep(3000);
        System.out.println("3rd "+t1.getState());
        t1.join();
        System.out.println("4th "+t1.getState());

    }
}
