package cpsc2150.MyDeque;
import java.util.*;
import java.util.Arrays;
//@invariant max length = 100
public class ArrayDeque implements IDeque {
    // where the data is stored. myQ[0] is the front of the deque
    private Integer[] myQ;

    //tracks how many items are in the deque
    // also used to find the end of the deque
    private int myLength;
    //Constructor to initialize array
    ArrayDeque()
    {
        myQ = new Integer[100];
    }

    //@param:Integer x to be added
    //@pre:None
    //@post:Adds x to end of deque
    public void enqueue(Integer x)
    {
        myQ[myLength] = x;
        myLength++;
    }
    //@pre:Deque is not empty
    //@post:Removes and returns integer at front of deque
    public Integer dequeue()
    {
            Integer x = myQ[0];
            /*Integer[] temp = new Integer[100];
            for (int i = 0; i < 99; i++)
                temp[0] = myQ[i + 1];
            myLength--;
            */
        for(int i=0;i<myLength-1;i++)
        {
            myQ[i]=myQ[i+1];
        }
        myLength--;
        return x;
    }
    //@param:Integer x to be added
    //@pre:None
    //@post:Adds x to front of deque
    public void inject(Integer x)
    {
       /* Integer[] temp = new Integer[100];
        for(int i=0;i<99;i++)
            temp[i+1] = myQ[i];
        temp[0] = x;
        myQ = temp;*/
        if(myLength<99) {
            for (int i = 0; i < myLength + 1; i++) {
                myQ[i + 1] = myQ[i];
            }
            myLength++;
        }
        else {
            for (int i = 0; i < 98; i++) {
                myQ[i + 1] = myQ[i];
            }
        }
        myQ[0] = x;
    }
    //@pre:Deque is not empty
    //@post:Removes and returns Integer at end of the deque
    public Integer removeLast()
    {
        Integer x = myQ[myLength];
        /*Integer[] temp = new Integer[100];
        for(int i=0;i<myLength;i++)
            temp[i] = myQ[i];
        myQ = temp;*/
        myQ[myLength] = null;
        myLength--;
        return x;
    }
    //@pre:none
    //@post:Returns myLength
    public int length()
    {
        return myLength;
    }
    //@pre:none
    //@post:clears array
    public void clear()
    {
        //Integer[] temp = new Integer[100];
        myQ = new Integer[100];
        myLength=0;
    }
}

