package LinkedList;


/**
 * This exception gets thrown when user tries to access a node which
 * does not exist in the list
 */
class NoSuchNodeException extends RuntimeException {
    public NoSuchNodeException(int position) {
        super("Node at position " + position + " does not exist!");
    }
}