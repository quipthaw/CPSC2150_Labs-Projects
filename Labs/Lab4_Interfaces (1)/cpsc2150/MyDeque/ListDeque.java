package cpsc2150.MyDeque;
import java.util.*;

public class ListDeque implements IDeque
{
    private List<Integer> myQ;
    ListDeque()
    {
        myQ = new LinkedList<>();
    }
    public void enqueue(Integer x)
    {
        myQ.add(x);
    }
    public Integer dequeue()
    {
        return myQ.remove(0);
    }
    public void inject(Integer x)
    {
        myQ.add(0, x);
    }
    public Integer removeLast()
    {
        return myQ.remove(myQ.size()-1);
    }
    public int length()
    {
        return myQ.size();
    }
    public void clear()
    {
        myQ.clear();
    }


}
