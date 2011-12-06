package edu.rit.se441.bankers;

/**
 * The Client class extends Thread;
 * multiple Client objects content for the pool of resources by calling methods in a shared Banker object.
 *
 * @author ian hunt
 * @date 12.06.11
 */
public class Client extends Thread {

    private String name;
    private Banker banker;
    private int nUnits;
    private int nRequests;
    private long minSleepMillis;
    private long maxSleepMillis;

    public Client(String name, Banker banker, int nUnits, int nRequests, long minSleepMillis, long maxSleepMillis) {
        super(name);
        this.banker = banker;
        this.nUnits = nUnits;
        this.nRequests = nRequests;
        this.minSleepMillis = minSleepMillis;
        this.maxSleepMillis = maxSleepMillis;
    }

    /**
     * Register a claim for up to nUnits of resource with the banker.
     * Then create a loop that will be executed nRequests times;
     * each iteration will either request or release resources by
     *   invoking methods in the banker.
     *
     *   If the banker.remaining() == 0,
     *      then the client will release some units.
     *   If banker.allocated() == 0,
     *      then the client will request some units.
     *   Otherwise, randomly decide whether to request or release units on this iteration.
     *
     *   If requesting units,
     *      choose random number from 1 through banker.remaining()
     *      and issue a request to the bankerr for that many units.
     *   If releasing units,
     *      choose random number from 1 through banker.allocated()
     *      and issue a request to the banker for that many units.
     *   At the end of each loop,
     *      use Thread.sleep(millis) to sleep a random number of milliseconds from minSleepMillis to maxSleepMillis.
     *      This will introduce another dose of non-determinism into your program.
     *   When the loop is done, release any units still allocated and simply return from run( )
     *      this will terminate the client thread.
     */
    public void run() {

    }
}
