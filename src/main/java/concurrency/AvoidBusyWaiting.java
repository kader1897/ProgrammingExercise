package concurrency;

/**
 * Created by kader.belli on 03.01.2019.
 */

public class AvoidBusyWaiting{
    public static void main(String[] args){
        Object lock = new Object();
        WaitingThread thread1 = new WaitingThread(1, 5000, lock);
        WaitingThread thread2 = new WaitingThread(2, 10000, lock);
        
        thread1.start();
        thread2.start();
    }
}
class WaitingThread extends Thread{
    private int id;
    private int sleepTime;
    private Object lock;
    
    public WaitingThread(int id, int sleepTime, Object lock){
        this.id = id;
        this.sleepTime = sleepTime;
        this.lock = lock;
    }
    
    @Override
    public void run(){
        System.out.println("Thread " + id + " started.");
        synchronized(lock)
        {
            Thread task = new TheTask(id, lock, sleepTime);
            synchronized(task)
            {
                task.start();
                try
                {
                    System.out.println("Thread " + id + " waiting.");
                    task.wait();
                    System.out.println("Thread " + id + " continues execution...");
                } catch(InterruptedException e)
                {
                    System.out.println("Main thread interrupted!");
                }
            }

        }
    }
}

class TheTask extends Thread{
    private int threadId;
    private Object theLock;
    private int sleepTime;
    
    public TheTask(int threadId, Object theLock, int sleepTime){
        this.threadId = threadId;
        this.theLock = theLock;
        this.sleepTime = sleepTime;
    }
    @Override
    public void run(){
        synchronized(this)
        {
            try
            {
                System.out.println("Task for thread " + threadId + " started.");
                sleep(sleepTime);
                System.out.println("Task finished.");
            } catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            this.notify();
        }
    }
}