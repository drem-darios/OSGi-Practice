package com.drem.osgi.spell.client;

import com.drem.osgi.spell.services.DictionaryService;
import org.apache.felix.ipojo.annotations.*;

import java.util.Random;

/**
 * A simple Hello service client. This client use annotation instead of XML metadata.
 * If no Hello provider are available, it uses a default implementation.
 *
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
@Component(name = "DictionaryClient")
@Instantiate
public class DictionaryClient implements Runnable {

    /**
     * Delay between two invocations.
     */
    private static final int DELAY = 10000;
    /**
     * Hello services. Injected by the container.
     */
    @Requires
    private DictionaryService dictionaries[]; // Array => Aggregate
    private String wordList[] = {"welcome", "blah", "bienvenue", "tutorial"};
    /**
     * End flag.
     */
    private boolean stopThread;

    /**
     * Run method.
     *
     * @see Runnable#run()
     */
    public void run() {
        while (!stopThread) {
            try {
                invokeDictionaryServices();
                Thread.sleep(DELAY);
            } catch (InterruptedException ie) {
                /* will recheck end */
            }
        }
    }

    /**
     * Invoke dictionary services.
     */
    public void invokeDictionaryServices() {
        String word = wordList[new Random().nextInt(wordList.length)];
        System.out.println("Word selected: " + word);
        for (DictionaryService dictionary : dictionaries) {
            System.out.println(dictionary.getClass().getSimpleName() + ": " + dictionary.checkWord(word));
        }
        System.out.println();
    }

    /**
     * Starting.
     */
    @Validate
    public void starting() {
        Thread thread = new Thread(this);
        stopThread = false;
        thread.start();
    }

    /**
     * Stopping.
     */
    @Invalidate
    public void stopping() {
        stopThread = true;
    }

}
