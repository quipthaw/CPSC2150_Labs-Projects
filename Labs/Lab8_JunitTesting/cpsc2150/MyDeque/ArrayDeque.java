/*
CPSC 2150
Manning Graham and Harrison Tun
 */

package cpsc2150.MyDeque;
//import kotlin.Suppress;
//import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

import java.util.*;
import java.util.Arrays;

/**
 * @invariant max length = 100
 */

public class ArrayDeque<T> extends AbsDeque<T> implements IDeque<T> {

    // where the data is stored. myQ[0] is the front of the deque
    private T[] myQ;

    //tracks how many items are in the deque
    // also used to find the end of the deque
    private int myLength;

    //Constructor to initialize array
    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        myQ = (T[]) new Object[100];
    }

    /*** @param:Integer x to be added
     * @pre:None
     * @post:Adds x to end of deque
     **/
    public void enqueue(T x) {
        if (myLength == MAX_LENGTH) {
            System.out.println("Queue is full");
            return;
        }
        myQ[myLength] = x;
        myLength++;
    }

    /**
     * @pre:Deque is not empty
     * @post:Removes integer at front of deque
     * @return integer at front of deque
     **/
    public T dequeue() {
        T x = myQ[0];
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
    public void inject(T x) {

        T tmp1 = myQ[0];
        T tmp2;
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
     * @post:Removes Integer at end of the deque
     * @return Integer at end of the deque
     **/
    public T removeLast() {
        T x = myQ[myLength-1];
        myQ[myLength-1] = null;
        myLength--;
        return x;
    }

    /**
     * @pre:none
     * @post:Returns myLength
     * @return mylength
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
        myLength = 0;
    }
}
