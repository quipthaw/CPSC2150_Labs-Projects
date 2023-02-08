package cpsc2150.MyDeque;

import cpsc2150.MyDeque.IDeque;
import cpsc2150.MyDeque.ListDeque;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestListDeque {
    private IDeque<Integer> MakeADeque()
    {
        IDeque<Integer> q;
        q = new ListDeque<>();
        return q;
    }






    //Tests for enqueue
    @Test
    public void testEnqueue1Element()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        assertTrue(q.toString().equals("<0>"));
    }

    @Test
    public void testEnqueue5Element()
    {
        IDeque<Integer> q = MakeADeque();


        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        assertTrue(q.toString().equals("<0, 1, 2, 3, 4>"));
    }

    @Test
    public void testEnqueue100Element()
    {
        IDeque<Integer> q = MakeADeque();
        String test = "<";
        for(int i=0;i<100;i++) {
            q.enqueue(i);
            if(i<99)
                test += i + ", ";
            else if(i==99)
                test += i;
        }
        test += ">";
        assertTrue(q.length()==100);
        assertTrue(q.toString().equals(test));
    }






    // Tests for Deque
    @Test
    public void TestDequeue1Deque()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(1);
        q.dequeue();
        assertTrue(q.toString().equals("<1>"));
    }

    @Test
    public void TestDequeue1Element()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(1);
        q.dequeue();
        assertTrue(q.toString().equals("<>"));
    }

    @Test
    public void TestDequeueMultipleDequeues()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
        q.dequeue();
        assertTrue(q.toString().equals("<2, 3, 4>"));
    }









    // Tests for inject
    @Test
    public void TestInject1Element()
    {
        IDeque<Integer> q = MakeADeque();
        q.inject(0);
        assertTrue(q.toString().equals("<0>"));
    }

    @Test
    public void TestInject5Elements()
    {
        IDeque<Integer> q = MakeADeque();
        q.inject(0);
        q.inject(1);
        q.inject(2);
        q.inject(3);
        q.inject(4);
        assertTrue(q.toString().equals("<4, 3, 2, 1, 0>"));
    }

    @Test
    public void ThirdTestInject100Elements()
    {

        IDeque<Integer> q = MakeADeque();
        String test = "<";
        for(int i= 99;i>=0;i--) {
            if (i > 0)
                test += i + ", ";
            else if (i == 0)
                test += i;
        }
        test += ">";

        for(int i= 0;i<100;i++) {
            q.inject(i);
        }


        assertTrue(q.toString().equals(test));
    }










    // Tests for removeLast
    @Test
    public void TestRemoveLast1Element()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        assertTrue(q.removeLast()==0);
        assertTrue(q.toString().equals("<>"));
    }

    @Test
    public void TestRemoveLast3Elements()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        assertTrue(q.removeLast()==2);
        assertTrue(q.toString().equals("<0, 1>"));
    }

    @Test
    public void TestRemoveLast100Elements()
    {
        IDeque<Integer> q = MakeADeque();
        String test = "<";
        for(int i=0;i<100;i++) {
            q.enqueue(i);
            if(i<98)
                test += i + ", ";
            else if(i==98)
                test += i + ">";
        }
        q.removeLast();
        assertTrue(q.toString().equals(test));
        assertTrue(q.length()==99);
    }







    // Tests for Clear
    @Test
    public void FirstTestClearMultipleElements()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        q.clear();
        assertTrue(q.toString().equals("<>"));
    }

    @Test
    public void SecondTestClear1Element()
    {
        IDeque<Integer> q = MakeADeque();
        q.clear();
        assertTrue(q.toString().equals("<>"));
    }

    @Test
    public void TestClearFull()
    {
        IDeque<Integer> q = MakeADeque();
        for(int i=0;i<100;i++)
            q.enqueue(i);
        q.clear();
        assertTrue(q.toString().equals("<>"));
    }







    // Tests for peek
    @Test
    public void FirstTestPeek1Element()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        assertTrue(q.peek() == 0);
    }

    @Test
    public void TestPeekMultipleElements()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        assertTrue(q.peek()==0);
    }

    @Test
    public void TestPeekFullArray() {

        IDeque<Integer> q = MakeADeque();
        for (int i = 0; i < 100; i++)
            q.enqueue(i);

        assertTrue(q.peek()==0);
    }











    // Tests for endOfDeque
    @Test
    public void FirstTestEndOfDeque1Element()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        assertTrue(q.endOfDeque()==0);
    }

    @Test
    public void SecondTestEndOfDequeMultipleElements()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        assertTrue(q.endOfDeque()==2);
    }

    @Test
    public void TestEndOfDequeFullDeque()
    {
        IDeque<Integer> q = MakeADeque();
        for(int i=0;i<100;i++)
            q.enqueue(i);
        assertTrue(q.endOfDeque()==99);
    }









    // Tests for insert
    @Test
    public void TestInsertAtFront()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(2);
        q.insert(1,1);
        assertTrue(q.toString().equals("<1, 0, 2>"));
    }

    @Test
    public void TestInsertAtEnd()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(1);
        q.insert(2,3);
        assertTrue(q.toString().equals("<0, 1>"));
    }

    @Test
    public void ThirdTestInsertInMiddle()
    {
        IDeque<Integer> q = MakeADeque();

        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        q.insert(8,3);
        assertTrue(q.toString().equals("<0, 1, 8, 2, 3>"));
    }









    // Tests for remove
    @Test
    public void TestRemoveAtFront()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        assertTrue(q.remove(1)==0);
        assertTrue(q.toString().equals("<>"));
    }

    @Test
    public void SecondTestRemoveAtEnd()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        assertTrue(q.remove(3)==2);
        assertTrue(q.toString().equals("<0, 1>"));
    }

    @Test
    public void ThirdTestRemoveFromMiddle()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        assertTrue(q.remove(2)==1);
        assertTrue(q.toString().equals("<0, 2>"));
    }









    // Tests for get
    @Test
    public void FirstTestGetFront()
    {
        IDeque<Integer> q = MakeADeque();
        q.inject(0);
        assertTrue(q.get(1)==0);
    }

    @Test
    public void SecondTestGetLast()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(3);

        assertTrue(q.get(3) == 3);
    }

    @Test
    public void ThirdTestGetMiddle()
    {
        IDeque<Integer> q = MakeADeque();
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        assertTrue(q.get(2)==1);
    }

}
