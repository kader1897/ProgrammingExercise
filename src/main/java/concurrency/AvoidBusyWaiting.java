package concurrency;

/**
 * Created by kader.belli on 03.01.2019.
 */

public class AvoidBusyWaiting{
    public static void main(String[] args){
        Object lock = new Object();
        synchronized (lock){
            Thread task = new TheTask(lock, 5000);
            task.start();
            try
            {
                System.out.println("Main thread waiting.");
                lock.wait();
                System.out.println("Main thread continues execution...");
            } catch(InterruptedException e)
            {
                System.out.println("Main thread interrupted!");
            }
        }
    }
}

class TheTask extends Thread{
    private Object theLock;
    private int sleepTime;
    
    TheTask(Object theLock, int sleepTime){
        this.theLock = theLock;
        this.sleepTime = sleepTime;
    }
    @Override
    public void run(){
        synchronized(theLock)
        {
            try
            {
                sleep(sleepTime);
                System.out.println("Task finished.");
            } catch(InterruptedException e)
            {
                System.out.println("Task interrupted!");
            }
            theLock.notify();
        }
    }
}