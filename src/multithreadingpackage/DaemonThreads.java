package multithreadingpackage;

import java.net.DatagramSocket;

public class DaemonThreads extends Thread {

    @Override
    public void run() {
        while (true){
            System.out.println("Running");
        }
    }

    public static void main(String[] args) {
        DaemonThreads d1 = new DaemonThreads();

        d1.setDaemon(true);
        d1.start();
        System.out.println("Main");

    }
}
