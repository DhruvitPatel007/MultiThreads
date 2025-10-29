package Synchronization;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThreads t1 = new MyThreads(counter);
        MyThreads t2 = new MyThreads(counter);

        t1.start();
        t2.start();

        try{
            t1. join();
            t2.join();
        }
        catch (Exception e){
            System.out.println("Error Occured "+e);
        }

        System.out.println(counter.getCount());


    }
}
