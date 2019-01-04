package concurrency;

/**
 * Created by kader.belli on 04.01.2019.
 */
public class DiningPhilosophers{
    public static void main(String[] args){
        Table table = new Table(5);
        table.startEating();
    }
}

class Table{
    Philosopher[] guests;
    Integer[] forks;
    
    Table(int n){
        guests = new Philosopher[n];
        forks = new Integer[n];
        for(int i = 0; i < n; i++)
        {
            forks[i] = 1;
            guests[i] = new Philosopher(i, forks);
        }
    }
    
    void startEating()
    {
        for(Philosopher p : guests)
        {
            p.start();
        }
    }
    
    
}
class Philosopher extends Thread{
    int id;
    int fork1;
    int fork2;
    Integer[] forks;
    
    Philosopher(int id, Integer[] forks){
        this.id = id;
        this.forks = forks;
        if(id % 2 == 0)
        {
            fork1 = id;
            fork2 = (id + 1) % forks.length;
        }
        else
        {
            fork2 = id;
            fork1 = (id + 1) % forks.length;
        }
    }
    
    @Override
    public void run(){
        while(true)
        {
            synchronized(forks[fork1])
            {
                System.out.println("Philosopher " + id + " acquires fork " + fork1);
                synchronized((forks[fork2]))
                {
                    System.out.println("Philosopher " + id + " acquires fork " + fork2);
                    System.out.println("Philosopher " + id + " eating");
                    try
                    {
                        sleep(100);
                    } catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
