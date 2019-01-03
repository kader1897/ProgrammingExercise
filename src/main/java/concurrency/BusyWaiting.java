package concurrency;

/**
 * Created by kader.belli on 03.01.2019.
 */
public class BusyWaiting{
    public static void main(String[] args){
    
        System.out.println("Main method started.");
        Thread task = new Task();
        task.start();
        while(task.isAlive()){
            continue;
        }
        System.out.println("Main method execution continues...");
    }
    
}

class Task extends Thread{
    @Override
    public void run(){
        try
        {
            System.out.println("Task started.");
            sleep(10000);
            System.out.println("Task finished.");
        } catch(InterruptedException e)
        {
            System.out.println("Task interrupted!");
        }
    }
}
