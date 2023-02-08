package cpsc2150.listDec;

import java.util.List;
import java.util.Random;



/**
 * Extends List and adds default methods shuffle and swap
 *
 * Defines: none
 *
 * Constraints 0 <= j < this.size() AND
 *             0 <= i < this.size() AND
 *             0 <= swaps
 */
public interface IShuffleList<T> extends List<T> {

    /** Adds x to the end of the deque
     * @param: Int swaps: Number of time the List is to have elements swapped
     * @pre: Swaps > 0
     * @post: [List is shuffled by swapping elements int swaps number of times] AND |list.size()| = |#list.size()|
     **/
    default void shuffle(int swaps){
        Random rand = new Random();
        for(int i=0; i<swaps;i++)
        {
            int ind1 = rand.nextInt(this.size());
            int ind2 = rand.nextInt(this.size());
            this.swap(ind1, ind2);
        }
    }

    /** Swaps elements at index i and j
     * @param i: Index of first element to be swapped
     * @param j: Index of second element to be swapped
     * @pre: 0 <= i < this.size() AND 0 <= j < this.size()
     * @post: List has elements swapped at indexes i and j
     */
    default void swap(int i, int j)
    {
        T tmpI = this.get(i);
        T tmpJ = this.get(j);
        this.set(i, tmpJ);
        this.set(j, tmpI);
    }

}
