package multithreadingpackage;

public class Test1 {
    public static void main(String[] args) {

        World1 world1 = new World1();

        Thread t1 = new Thread(world1);
        t1.start();


        for (; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }

    //Using Runnable Interface
}
