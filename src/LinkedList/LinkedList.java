package LinkedList;

/**
 *
 * Represents a general linked list
 * @author <a href="https://github.com/Stillswarm">Stillswarm</a>
 */
public interface LinkedList<T> {
    void insertFirst(T value);

    void insertLast(T value);

    /**
     * NOTE: when {@code position} lies beyond the size of the list, the value should be
     * appended to the end of the list.
     * @param position 1-based index of the node whose value is to be deleted
     */
    void insertAt(int position, T value);

    T deleteFirst();

    T deleteLast();

    /**
     *
     * @param position 1-based index of the node whose value is to be deleted
     * @return the value of the node placed at {@code position}
     * @throws NoSuchNodeException when node is out of valid range.
     */
    T deleteAt(int position);

    int size();

    boolean isEmpty();
}
