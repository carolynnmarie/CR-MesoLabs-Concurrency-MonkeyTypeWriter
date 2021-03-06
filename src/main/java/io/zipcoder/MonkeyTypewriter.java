package io.zipcoder;


import java.util.NoSuchElementException;

public class MonkeyTypewriter extends Copier{

    public MonkeyTypewriter(String toCopy) {
        super(toCopy);
    }



    public static void main(String[] args) throws InterruptedException {
        String introduction = "It was the best of times,\n" +
                "it was the worst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";



        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities by Charles Dickens.


        UnsafeCopier notSafe = new UnsafeCopier(introduction);
        Thread[] notSafeThreads = new Thread[5];
        for (int i = 0; i < notSafeThreads.length; i++) {
            notSafeThreads[i] = new Thread(notSafe);
            notSafeThreads[i].start();
        }



        SafeCopier safe = new SafeCopier(introduction);
        Thread[] safeThread = new Thread[5];
        for(int i = 0; i<safeThread.length; i++){
            safeThread[i] = new Thread(safe);
            safeThread[i].start();
        }


        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println(notSafe.copied);
        System.out.println("____________________________________________");
        System.out.println(safe.copied);


    }

    @Override
    public void run() {

    }
}