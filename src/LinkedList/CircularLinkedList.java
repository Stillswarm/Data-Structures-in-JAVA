package LinkedList;

/**
 * @param <T> the datatype of the values to be stored in the circular linked list
 * @author @author <a href="https://github.com/Stillswarm">Stillswarm</a>
 */
public class CircularLinkedList<T> implements LinkedList<T> {

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node<T> head;

    public CircularLinkedList() {
        size = 0;
        head = null;
    }

    @Override
    public void insertFirst(T val) {
        var newNode = new Node<>(val);
        if (isEmpty()) {
            head = newNode;
            head.next = head;
        } else {
            var current = head;
            while (current.next != head) {
                current = current.next;
            }

            newNode.next = head;
            current.next = newNode;
            head = newNode;
        }

        ++size;
    }

    @Override
    public void insertLast(T val) {
        var newNode = new Node<>(val);
        if (isEmpty()) {
            head = newNode;
            head.next = head;
        } else {
            var current = head;
            while (current.next != head) {
                current = current.next;
            }

            newNode.next = head;
            current.next = newNode;
        }
        ++size;
    }

    @Override
    public void insertAt(int position, T val) {
        if (position == 1) {
            insertFirst(val);
        } else if (position > size) {
            insertLast(val);
        } else {
            var newNode = new Node<>(val);
            int pos = 1;
            var current = head;
            while (pos++ < position - 1) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
            ++size;
        }
    }

    @Override
    public T deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchNodeException(1);
        } else if (head.next == head) {
            T val = head.data;
            head = null;
            return val;
        } else {
            var current = head;
            while (current.next != head) {
                current = current.next;
            }

            current.next = head.next;
            T val = head.data;
            head = head.next;
            --size;
            return val;
        }
    }

    @Override
    public T deleteLast() {
        if (isEmpty()) {
            throw new NoSuchNodeException(1);
        } else if (head.next == head) {
            T val = head.data;
            head = null;
            return val;
        } else {
            var current = head;
            while (current.next.next != head) {
                current = current.next;
            }

            T val = current.next.data;
            current.next = head;
            --size;
            return val;
        }
    }

    @Override
    public T deleteAt(int position) {
        if (position == 1) {
            return deleteFirst();
        } else if (position == size) {
            return deleteLast();
        } else if (position > size) {
            throw new NoSuchNodeException(position);
        } else {
            int pos = 1;
            var current = head;
            while (pos++ < position - 1) {
                current = current.next;
            }

            T val = current.next.data;
            current.next = current.next.next;
            --size;
            return val;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        if (head == null) return;

        System.out.print(head.data + " ");
        var current = head.next;
        while (current != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

}
