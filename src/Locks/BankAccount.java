package Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();


    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+ " attempting to withdraw "+ amount);

        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance>=amount){
                    try{
                        System.out.println(Thread.currentThread().getName()+ " proceeding with withdrawal");
                        Thread.sleep(3000);
                        balance= balance-amount;
                        System.out.println(Thread.currentThread().getName()+ " withdrawal completed"+ " Remaining balance "+balance);


                    }catch (Exception e){
                        Thread.currentThread().interrupt();
                    }
                    finally {
                        lock.unlock();
                    }
                }
                else {
                    System.out.println(Thread.currentThread().getName()+" Insufficient balance");
                }
            }
            else {
                System.out.println(Thread.currentThread().getName()+ " could not acquire the lock");
            }



        }catch (Exception e){
            Thread.currentThread().interrupt();
        }

        if (Thread.currentThread().isInterrupted()){
            System.out.println("We have log of interrupted thread");
        }


    }
}
