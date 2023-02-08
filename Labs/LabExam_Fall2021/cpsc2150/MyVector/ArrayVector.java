package cpsc2150.MyVector;

import java.util.Arrays;

public class ArrayVector<T> extends AbsVector<T> implements IVector<T> {


    /**
     * @invariant 0 <= myVector.size() <= MAX_LENGTH
     *
     * @correspondence self = [myVector represented as a sequence of values]
     */


    private T[] myV;

    private int myLength;


    /**
     * <p>
     * This creates a new array-based vector that is initially empty.
     * </p>
     *
     * @pre None
     *
     * @post myVector = [a value array of MAX_LENGTH]
     */
    ArrayVector(){
        myV = (T[]) new Object[100];
    }




    //public methods

    @Override
    public void addElement(T val) {

        if(myLength == MAX_LENGTH){
            System.out.println("Vector is Full");
            return;
        }
        myV[myLength] = val;
        myLength++;
    }

    @Override
    public T removeElement() {
        T x = myV[0];
        for (int i = 0; i < myLength - 1; i++){
            myV[i] = myV[i+1];
        }
        myLength--;
        return x;
    }

    @Override
    public boolean contains(T val) {
        for(int i = 0; i < myLength; i++){
            if(myV[i] == val){
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int pos) {
        return myV[pos];
    }

    @Override
    public int length() {
        return myLength;
    }

    @Override
    public void clear() {
        for(int i = 0; i < myLength; i++){
            myV[i] = null;
        }
        myLength = 0;
    }
}
