/*
CPSC 2150
Manning Graham and Harrison Tun
 */
package cpsc2150.MyDeque;
import java.util.Scanner;
public class DequeApp<T> {
    public static void main(String[] args) {

        IDeque <Integer> q;
        String a = "3";
        String b = "1";

    //Prompt  the  user  to  pick  an  implementation  using  the  following
    //message:"Enter  1  for  array  implementation  or  2  for  List implementation"

        while (!a.equals("1") && !a.equals("2"))
        {
            Scanner myObj = new Scanner(System.in);
            //Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter 1 for array implementation or 2 for List implementation");
            a = myObj.nextLine();
        }
        if (a == "1"){ q = new ArrayDeque<Integer>(); }
        else q = new ListDeque<Integer>();

    while(b!= "12")
    {

        Scanner myObj2 = new Scanner(System.in);
        System.out.println("i.Add to the end of the deque\n" +
                "ii.Add to the front of the deque\n" +
                "iii.Remove from the front of the deque\n" +
                "iv.Remove from the end of the deque\n" +
                "v.Peek at the front of the deque\n" +
                "vi.Peek at the end of the deque\n" +
                "vii.Insert into a position in the deque\n" +
                "viii.Remove a value from any position in the deque and return it\n" +
                "ix.Peek at a value in any position in the deque\n" +
                "x.Returns the length of the deque\n" +
                "xi.Clears the deque\n" +
                "xii.Exit" );
        System.out.println(q.toString());
        b = myObj2.nextLine();
        if (b.equals("1"))
        {
            Scanner myObj3 = new Scanner(System.in);
            System.out.println("What integer would you like to add?");
            b = myObj3.nextLine();
            q.enqueue(Integer.parseInt(b));
            b = "1";
        }

        else if(b.equals("2"))
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What integer would you like to add?");
            b = scanner.nextLine();
            q.inject(Integer.parseInt(b));
            b = "2";
        }

        else if(b.equals("3"))
        {
            Integer x = q.dequeue();
            System.out.println("You removed " + x);
        }
        else if(b.equals("4"))
        {
            Integer x = q.removeLast();
            System.out.println("You removed " + x);
        }

        else if(b.equals("5"))
        {
            Integer tmp = q.peek();
            System.out.println(tmp);
        }
        else if(b.equals("6"))
        {
            Integer x = q.endOfDeque();
            System.out.println(x + " is at the end of the deque");
        }
        else if(b.equals("7"))
        {
            Scanner myObj3 = new Scanner(System.in);
            System.out.println("What integer would you like to add?");
            b = myObj3.nextLine();
            System.out.println("What position would you like to add at?(First element is 1)");
            String pos = myObj3.nextLine();
            int test = Integer.parseInt(pos);
            if(test>q.length() ||  test<1) { System.out.println("Invalid input"); }
            else { q.insert(Integer.parseInt(b),Integer.parseInt(pos)); }
            b = "7";
        }
        else if(b.equals("8"))
        {
            Scanner myObj3 = new Scanner(System.in);
            System.out.println("What position would you like to remove at?(First element is 1)");
            b = myObj3.nextLine();
            int test = Integer.parseInt(b);
            if(test>q.length() ||  test<1) { System.out.println("Invalid input"); }

            else
                {
                    Integer x = q.remove(Integer.parseInt(b));
                    System.out.println("You removed " + x);
                }
            b = "8";
        }
        else if(b.equals("9"))
        {
            Scanner myObj3 = new Scanner(System.in);
            System.out.println("What position would you like to peek at?(First element is 1)");
            b = myObj3.nextLine();
            int test = Integer.parseInt(b);

            if(test>q.length() ||  test<1) { System.out.println("Invalid input"); }

            else { System.out.println("That element is " + q.get(Integer.parseInt(b))); }
            b = "9";
        }
        else if(b.equals("10")){ System.out.println(q.length()); }

        else if(b.equals("11")){
            q.clear();
            System.out.println(" Deque Cleared. ");
        }

        else if(b.equals("12")){ b = "12"; }

        else if(b.equals("13")){ System.out.println (q.toString()); }

        else System.out.println("You have not Entered a valid menu option. Please try again");

        q.toString();
    }
    }
}

