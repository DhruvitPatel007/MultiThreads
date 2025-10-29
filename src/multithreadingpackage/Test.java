package multithreadingpackage;

public class Test {
    public static void main(String[] args) {

        World t1 = new World();

        t1.start();

        for(; ;){
            System.out.println(Thread.currentThread().getName());
        }


    //Direct Extending the thread
    }
}
