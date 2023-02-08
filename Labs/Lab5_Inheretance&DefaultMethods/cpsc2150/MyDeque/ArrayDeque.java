/*
CPSC 2150
Manning Graham and Harrison Tun
 */

package cpsc2150.MyDeque;
import java.util.*;
import java.util.Arrays;

/**
 * @invariant max length = 100
 */

public class ArrayDeque extends AbsDeque implements IDeque {

    // where the data is stored. myQ[0] is the front of the deque
    private Integer[] myQ;

    //tracks how many items are in the deque
    // also used to find the end of the deque
    private int myLength;

    //Constructor to initialize array
    ArrayDeque() {
        myQ = new Integer[100];
    }

    /*** @param:Integer x to be added
     * @pre:None
     * @post:Adds x to end of deque
     **/
    public void enqueue(Integer x) {
        if (myLength == MAX_LENGTH) {
            System.out.println("Queue is full");
            return;
        }
        myQ[myLength] = x;
        myLength++;
    }

    /**
     * @pre:Deque is not empty
     * @post:Removes and returns integer at front of deque
     **/
    public Integer dequeue() {
        Integer x = myQ[0];
        for (int i = 0; i < myLength - 1; i++) {
            myQ[i] = myQ[i + 1];
        }
        myLength--;
        return x;
    }

    /**
     * @param:Integer x to be added
     * @pre:None
     * @post:Adds x to front of deque
     **/
    public void inject(Integer x) {

        Integer tmp1 = myQ[0];
        Integer tmp2;
        myQ[0] = x;
        for (int i = 1; i < myLength + 1; i++) {
            tmp2 = myQ[i];
            myQ[i] = tmp1;
            tmp1 = tmp2;
        }
        myLength++;
    }

    /**
     * @pre:Deque is not empty
     * @post:Removes and returns Integer at end of the deque
     **/
    public Integer removeLast() {
        Integer x = myQ[myLength];
        myQ[myLength] = null;
        myLength--;
        return x;
    }

    /**
     * @pre:none
     * @post:Returns myLength
     **/
    public int length() {
        return myLength;
    }

    /**
     * @pre:none
     * @post: myQ[i] == NULL
     **/
    public void clear() {
        for (int i = 0; i < myLength; i++) {
            myQ[i] = null;
        }
    }
}
