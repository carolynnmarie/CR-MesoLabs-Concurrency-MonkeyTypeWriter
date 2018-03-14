package io.zipcoder;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }


    public void run() {
        try {
            Thread.sleep(30);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }
        while(stringIterator.hasNext()){
           copied += stringIterator.next() + " ";
        }
    }

}

