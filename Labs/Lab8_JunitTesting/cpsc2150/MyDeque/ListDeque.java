/*
CPSC 2150
Manning Graham and Harrison Tun
 */

package cpsc2150.MyDeque;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @invariants 0 <= myLength <= MAX_LENGTH and
 * [myLength = characters in myQ]
 * Correspondence IDeque = myQ
 */
public class ListDeque<T> extends AbsDeque<T> implements IDeque<T>
{
    private List<T> myQ;

    /**
     * @post myQ.size() = 0 and [myQ is empty]
     */
    public ListDeque()
    {
        myQ = new LinkedList<>();
    }

    /**
     * @pre myQ.size() < MAX_LENGTH
     * @post myQ.size() = #myQ.size() + 1 and x = myQ[myQ.size()]
     * @param x the character being added to the end of deque
     */
    public void enqueue(T x)
    {
        myQ.add(x);
    }

    /**
     * @post myQ.size() = #myQ.size() - 1 and x = myQ[0]
     * @return the character at the front of the deque
     */
    public T dequeue()
    {
        return myQ.remove(0);
    }

    /**
     * @pre myQ.size() < MAX_LENGTH
     * @post myQ.size() = #myQ.size() + 1 and x = myQ[0]
     * @param x The character being added to the front of the deque
     */
    public void inject(T x)
    {
        myQ.add(0, x);
    }

    /**
     * @post myQ.remove(myQ.size()-1)
     * @return The character at the end of the deque
     */
    public T removeLast()
    {
        return myQ.remove(myQ.size()-1);
    }

    /**
     * @post 0 <= myQ.size() <= MAX_LENGTH
     * @return The current characters in myQ
     */
    public int length()
    {
        return myQ.size();
    }

    /**
     * @post myQ.size() = 0
     */
    public void clear()
    {
        myQ.clear();
    }
}
