package Locks;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

    private static final ReentrantLock lock1 = new   ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();




    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            try{
                lock1.lock();
                System.out.println("Thread 1 locked lock1");
                Thread.sleep(5000);

                lock2.lock();
                System.out.println("Thread1 locked lock2");


            }catch (Exception e){
                System.out.println("Thread 1 interrupted");
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        });

        Thread t2 = new Thread(()->{

            try {
                lock2.lock();
                System.out.println("Thread 2 locked lock2");
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Thread 2 interrupted");
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        });

        t1.start();
        t2.start();

    }


}
