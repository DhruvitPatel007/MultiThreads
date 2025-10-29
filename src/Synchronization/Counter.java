package Synchronization;

public class Counter {
    private int count = 0;

    public synchronized   void  increament(){

        count++;
        //You can use following also
//        synchronized (this){
//            count++;
//        }
    }

    public int getCount(){
        return count;
    }
}
