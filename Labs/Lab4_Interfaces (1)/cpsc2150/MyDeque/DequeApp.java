package cpsc2150.MyDeque;
import java.util.Scanner;
public class DequeApp {
    public static void main(String[] args) {

        IDeque q;
        String a = "3";
    /*
    Prompt  the  user  to  pick  an  implementation  using  the  following
    message:"Enter  1  for  array  implementation  or  2  for  List implementation"
     */
        while (!a.equals("1") && !a.equals("2")) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter 1 for array implementation or 2 for List implementation");
            a = myObj.nextLine();
        }
        if (a == "1"){
            q = new ArrayDeque();
        }
        else
            q = new ListDeque();

        Integer x = 3;
        q.enqueue(x);
        x = -8;
        q.enqueue(x);
        x = 15;
        q.enqueue(x);
        x = 0;
        q.enqueue(x);
        x = -4;
        q.enqueue(x);
        System.out.print("<");
        for(int i=0;i<5;i++) {
            if (i == 4)
                System.out.println(q.dequeue() + ">");
            else
                System.out.print(q.dequeue() + ", ");

        }
    }
}

