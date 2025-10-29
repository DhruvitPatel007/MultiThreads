package multithreadingpackage;

public class yieldThreads extends Thread {

    public yieldThreads(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i<10 ; i++){
            System.out.println(Thread.currentThread().getName()+" "+ i);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        yieldThreads y1 = new yieldThreads("Lav");
        yieldThreads y2 = new yieldThreads("Dhruvit");

        y1.start();
        y2.start();
    }
}
