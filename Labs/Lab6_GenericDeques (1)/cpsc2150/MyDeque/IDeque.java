/*
CPSC 2150
Manning Graham and Harrison Tun
 */

package cpsc2150.MyDeque;

/**
 * @Invariant: Max Length == 100
 */
public interface IDeque<T> {

    public static final int MAX_LENGTH = 100;

    /** Adds x to the end of the deque
     * @param:Integer x to be added
     * @pre:None
     * @post: [Adds x to end of deque]
     **/
    public void enqueue(T x);


    /** Removes and returns the integer at the front of the deque
     * @pre:Deque is not empty
     * @post:Removes and integer at front of deque
     * @return value at front of deque
    **/
    public T dequeue();


    /** Adds x to the front of the deque
     * @param:Integer x to be added
     * @pre:None
     * @post:Adds x to end of deque
     **/
    public void inject(T x);


    /** Removes and returns the integer at the end of the deque
     * @pre:Deque is not empty
     * @post:Removes Integer at end of the deque
     * @return Integer at end of deque
     **/
    public T removeLast();


    /** Returns the number of integers in the deque
     * @pre:none
     * @return myLength
    **/
    public int length();


    /** Clears the entire deque
     * @pre:none
     * @post:clears array
     **/
    public void clear();

    /** Shows element at the front of the deque
     * @pre: deque length > 0
     * @post: Gives element at the front of the deque
     * @return Elements at front of deque
     **/
    default T peek()
    {
        T tmp = this.dequeue();
        this.inject(tmp);
        return tmp;
    }

    /** Shows element at the back of the deque
     * @pre: deque length > 0
     * @post: Gives element at the back of the deque
     * @return element at the back of the deque
     **/
    default T endOfDeque()
    {
        T tmp = this.removeLast();
        this.enqueue(tmp);
        return tmp;
    }

    /** Inserts element at any position in array
     * @pre: pos>0 AND pos<deque length
     * @post: inserts element at specified position in array
     **/
    default void insert(T x, int pos)
    {
        for(int i=0;i<this.length();i++)
        {
            if(i==pos-1) {
                this.enqueue(x);
            }
            else{
                this.enqueue(this.dequeue());
            }
        }
    }

    /** Removes and returns element at the specified pos of the deque
     * @pre:deque pos > 0 AND pos < deque length
     * @post: Removes element at the specified position of the deque
     * @return element at the specified position of the deque
     **/
    default T remove(int pos)
    {
        pos = pos - 1;
        T tmp = null;
        for(int i = 0; i <= length(); i++){
            if( i == pos ){
                tmp = dequeue();
            }
            else enqueue(dequeue());
        }
        return tmp;
    }

    /** Shows element at the given position of the deque
     * @pre: deque pos > 0 AND pos < deque length
     * @post: gives element at the specified position of the deque
     * @param pos the specified position to look up
     * @return the character in position 'pos' of the deque
     **/
    default T get(int pos){
        pos = pos - 1;
        T temp;
        for(int i=0; i<pos; i++){
            this.enqueue(this.dequeue());
        }
        temp = peek();
        for(int j=0; j<(length()-pos); j++) {
            this.enqueue(this.dequeue());
        }
        return temp;
    }
}
