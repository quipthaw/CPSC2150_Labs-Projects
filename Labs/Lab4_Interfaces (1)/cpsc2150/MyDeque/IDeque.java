//@invariant:Max length is 100

package cpsc2150.MyDeque;

public interface IDeque {
    public static final int MAX_LENGTH= 100;

    // Adds x to the end of the deque
    //@param:Integer x to be added
    //@pre:None
    //@post:Adds x to end of deque
    public void enqueue(Integer x);

    //removes and returns the integer at the front of the deque
    //@pre:Deque is not empty
    //@post:Removes and returns integer at front of deque
    public Integer dequeue();

    // Adds x to the front of the deque
    //@param:Integer x to be added
    //@pre:None
    //@post:Adds x to end of deque
    public void inject(Integer x);

    //removes and returns the integer at the end of the deque
    //@pre:Deque is not empty
    //@post:Removes and returns Integer at end of the deque
    public Integer removeLast();

    //returns the number of integers in the deque
    //@pre:none
    //@post:Returns myLength
    public int length();

    //clears the entire deque
    //@pre:none
    //@post:clears array
    public void clear();

}
