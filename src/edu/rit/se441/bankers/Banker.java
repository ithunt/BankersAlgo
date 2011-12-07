package edu.rit.se441.bankers;

import net.jcip.annotations.GuardedBy;
import sun.tools.tree.ThisExpression;

import java.util.HashMap;

/**
 * @author ian hunt
 * @date 12.06.11
 */
public class Banker {

    private final int totalResources;
    
    @GuardedBy("this")
    private volatile int allocatedResources;
    @GuardedBy("this")
    private final HashMap<String, Integer> claims;
    @GuardedBy("this")
    private final HashMap<String, Integer> allocations;

    /**
     * Initialize the new Banker object to manage nUnits of resource
     * @param nUnits
     */
    public Banker(int nUnits) {
        this.totalResources = nUnits;
        claims = new HashMap<String, Integer>();
        allocations = new HashMap<String, Integer>();

    }

    /**
     * The current  thread (available via static method Thread.currentThread())
     *   attempts to register a claim for up to nUnits units of resource.
     *
     *   The method calls System.exit(1) if
     *      (a) the thread already has a claim registered,
     *      (b) nUnits is not strictly positive, or
     *      (c) nUnits exceeds the number of resources in the system.
     *   Print a message of the form:
     *             Thread name sets a claim for nUnits units.
     *           where name is the thread name (via Thread.currentThread().getName())
     *           and nUnits is the number of resources claimed and return.
     * @param nUnits
     */
    public void setClaim(int nUnits) {

         if( null != claims.get(Thread.currentThread().getName()) ||
                nUnits < 1 ||
                nUnits > this.totalResources ) {
             if( nUnits > this.totalResources)
                System.err.println(Thread.currentThread().getName() + " attempted to claim more than available resources. Exiting");
             System.exit(1);
         }

        System.out.println(Thread.currentThread().getName() + "  sets a claim for " + nUnits + " units." );

        synchronized (this) {
            claims.put( Thread.currentThread().getName() , new Integer(nUnits) );
        }

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
    public synchronized void request(int nUnits) {

        final String currentThreadName = Thread.currentThread().getName();
        final int remaining = claims.get(currentThreadName) - allocations.get(currentThreadName);

        if(     null == claims.get(currentThreadName)   ||
                nUnits < 1  ||
                nUnits > ( remaining ))
        {
            if( nUnits > (remaining))
                System.err.println(currentThreadName + " requested " + nUnits + ". Only " +
                    remaining + " more may be claimed. Exiting ");
            System.exit(1);
        }

        
        System.out.println(currentThreadName + " requests " + nUnits + " units.");
        
        //do work
        
        boolean safe = true;
        if( safe ) {        
            System.out.println(currentThreadName + " has " + nUnits + " units allocated");
        
            //update banker state
            return;
        } else {
            while( !safe ) {
                
                
                safe = true;
            }
        }

        
        //if not
        
       

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
    public synchronized void release(int nUnits) {
        
        final String currentThreadName = Thread.currentThread().getName();
        if(     null == claims.get(currentThreadName) ||
                nUnits < 1 ||
                nUnits > allocations.get(currentThreadName) ) 
        {
            System.exit(1);
        }
        
        System.out.println(currentThreadName + " releases " + nUnits + " units.");
        
        final int newAllocation = allocations.get(currentThreadName) - nUnits;

        if (0 == newAllocation) {
            allocations.remove(currentThreadName);
        } else {
            allocations.put(currentThreadName, newAllocation);
        }

        
        
        

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
