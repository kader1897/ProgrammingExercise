package concurrency;

/*
 * Created by kad_ER_ on 1/4/2019 12:53 AM
 * Project: ProgrammingExercise
 */

import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) {
        final int n = 10;
        Production production = new Production(n);

        Producer producer = new Producer(production, 1000, true, 100);
        Consumer consumer = new Consumer(production, 1000, true);

        producer.start();
        consumer.start();

    }
}

class Production{
    private int[] buffer;
    private int index;

    Production(int n) {
        buffer = new int[n];
        index = -1;
    }

    synchronized void produce(int n){
        while (index >= buffer.length - 1)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Production interrupted!");
            }
        }


        buffer[++index] = n;
        printBuffer();
        notifyAll();
    }

    synchronized int consume(){
        while(index < 0)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Consumption interrupted!");
            }
        }

        int item = buffer[index--];
        printBuffer();
        notifyAll();

        return item;
    }

    private synchronized void printBuffer()
    {
        StringBuilder sb = new StringBuilder();
        for(int i : buffer)
        {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}

class ProductionSubject extends Thread{
    protected Production production;
    protected Random randomIntervalGenerator;
    protected int interval;
    protected boolean randomize;

    ProductionSubject(Production production, int interval, boolean randomize) {
        this.production = production;
        this.interval = interval;
        this.randomize = randomize;
        this.randomIntervalGenerator = new Random();
    }
}

class Producer extends ProductionSubject{

    private Random random;
    private int limit;

    Producer(Production production, int interval, boolean randomize, int limit) {
        super(production, interval, randomize);
        this.limit = limit;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            int item = random.nextInt(limit);
            production.produce(item);
            int duration = interval;
            if(randomize)
                duration = randomIntervalGenerator.nextInt(interval) + 1;
            System.out.println("Item " + item + " produced. Producer sleeps for " + duration + " milliseconds.");
            try {
                sleep(duration);
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted!");
            }
        }
    }
}

class Consumer extends ProductionSubject{

    Consumer(Production production, int interval, boolean randomize) {
        super(production, interval, randomize);
    }

    @Override
    public void run() {
        while (true)
        {
            int item = production.consume();
            int duration = interval;
            if(randomize)
                duration = randomIntervalGenerator.nextInt(interval) + 1;
            System.out.println("Item " + item + " consumed. Consumer sleeps for " + duration + " milliseconds.");
            try {
                sleep(duration);
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted!");
            }
        }
    }
}
