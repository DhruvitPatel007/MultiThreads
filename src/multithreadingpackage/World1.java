package multithreadingpackage;

public class World1 implements Runnable {
    @Override
    public void run() {
        for (; ;){
            System.out.println(Thread.currentThread().getName());
        }

    }

    //Using Runnable Interface
}
