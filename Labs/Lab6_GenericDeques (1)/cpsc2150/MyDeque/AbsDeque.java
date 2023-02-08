/*
CPSC 2150
Manning Graham and Harrison Tun
 */

package cpsc2150.MyDeque;

import javax.swing.*;

public abstract class AbsDeque<T> implements IDeque<T>{
    @Override

    public String toString() {

        if(length() == 0)
        {
            //System.out.println("Deque is empty!");
            String tmp = "<>";
            return tmp;
        }

        //System.out.println("Deque is: ");
        String ret = "<";
        T addToStringI = null;
        for (int i = 0; i < length(); i++) {
            addToStringI = dequeue();
            if (i == length()) {
                ret += addToStringI;
            } else {
                ret += (addToStringI + ", ");
            }
            enqueue(addToStringI);
        }
        ret += ">";
        return ret;
    }
}
