package Synchronization;

class MyThreads extends Thread{

    private Counter counter;

    public MyThreads(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
       for (int i=0;i<1000;i++){
           counter.increament();
       }
    }
}
