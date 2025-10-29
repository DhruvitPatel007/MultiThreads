package multithreadingpackage;

public class PriorityThreads extends Thread {

    public PriorityThreads(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i<5;i++){
            String a = "";

            for (int j=0; j<10000;j++){
                a+="a";
            }
            System.out.println(Thread.currentThread().getName()+ " - Priority: "+ Thread.currentThread().getPriority());
            try{
                    Thread.sleep(500);
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {

    PriorityThreads l = new PriorityThreads("Low Priority");
        PriorityThreads m = new PriorityThreads("Medium Priority");
        PriorityThreads h = new PriorityThreads("High Priority");

        l.setPriority(1);
        m.setPriority(5);
        h.setPriority(10);

        l.start();
        m.start();
        h.start();


    }
}
