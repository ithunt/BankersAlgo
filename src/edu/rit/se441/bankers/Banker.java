package edu.rit.se441.bankers;

/**
 * @author ian hunt
 * @date 12.06.11
 */
public class Banker {

    /**
     * Initialize the new Banker object to manage nUnits of resource
     * @param nUnits
     */
    public Banker(int nUnits) {

    }

    /**
     * The current  thread (available via static method Thread.currentThread())
     *   attempts to register a claim for up to nUnits units of resource.
     *
     *   The method calls System.exit(1) if
     *      (a) the thread already has a claim registered,
     *      (b) nUnits is not strictly positive, or
     *      (c) nUnits exceeds the number of resources in the system. Print a message of the form:
     *             Thread name sets a claim for nUnits units.
     *           where name is the thread name (via Thread.currentThread().getName())
     *           and nUnits is the number of resources claimed and return.
     * @param nUnits
     */
    public void setClaim(int nUnits) {

    }

    /**
     * Request nUnits more resources.
     * The method calls System.exit(1) if:
     *      (a) the current thread has no claim registered,
     *      (b) nUnits is not strictly positive or
     *      (c) nUnits exceeds the invoking thread's remaining claim.
     * Print the message
     *      Thread name requests nUnits units.
     * If allocating the resources results in a safe state, print the message
     *      Thread name has nUnits units allocated
     * Update banker's state and return.
     * Otherwise enter a loop waiting for the state to change and retrying until allocation leads to a safe state.
     * Whenever reawakened, print the message
     *      Thread name awakened in request.
     * When a safe state is found, print
     *      Thread name has nUnits units allocated
     * Update the banker's state and return.
     *
     * @param nUnits
     */
    public void request(int nUnits) {

    }

    /**
     * Release nUnits resources.
     *
     * The method calls System.exit(1) if
     *      (a) the current thread has no claim registered,
     *      (b) nUnits is not strictly positive or
     *      (c) nUnits exceeds the number of units allocated to the current thread.
     * Print the message
     *      Thread name releases nUnits units.
     * Release nUnits of the units allocated to the current thread,
     *    notify any and all threads waiting for their allocation, and return.
     *
     * @param nUnits
     */
    public void release(int nUnits) {

    }

    /**
     * Returns the number of units allocated to the current thread.
     *
     * @return
     */
    public int allocated() {
        return 0;
    }

    /**
     * Returns the number of units remaining in the current thread's claim
     *
     * @return the maximum number of units current thread can request
     */
    public int remaining() {
        return 0;
    }

}
