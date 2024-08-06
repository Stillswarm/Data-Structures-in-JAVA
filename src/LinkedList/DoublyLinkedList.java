package LinkedList;

/**
 * @param <T> the datatype of the values to be stored in the doubly linked list
 * @author <a href="https://github.com/Stillswarm">Stillswarm</a>
 */
public class DoublyLinkedList<T> implements LinkedList<T> {

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public void insertFirst(T value) {
        var newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        ++size;
    }

    @Override
    public void insertLast(T value) {
        var newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        ++size;
    }

    @Override
    public void insertAt(int position, T value) {
        var newNode = new Node<>(value);
        if (head == null || position == 1) {
            insertFirst(value);
        } else if (position > size) {
            insertLast(value);
        } else {
            var current = head;
            int pos = 1;
            while (pos++ < position - 1) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;

            ++size;
        }
    }

    @Override
    public T deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchNodeException(1);
        } else {
            head.next.prev = null;
            T value = head.data;
            head = head.next;
            --size;
            return value;
        }
    }

    @Override
    public T deleteLast() {
        if (isEmpty()) {
            throw new NoSuchNodeException(1);
        } else {
            if (size == 1) {
                return deleteFirst();
            } else {
                T value = tail.data;
                tail.prev.next = null;
                tail = tail.prev;
                --size;
                return value;
            }
        }
    }

    @Override
    public T deleteAt(int position) {
        if (size < position) {
            throw new NoSuchNodeException(position);
        } else {
            if (position == 1) {
                return deleteFirst();
            } else {
                var current = head;
                int pos = 1;
                while (pos++ < position) {
                    current = current.next;
                }

                T value = current.data;
                current.prev.next = current.next;
                current.next.prev = current.prev;

                --size;
                return value;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    private void display() {
        var current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    private void displayReversed() {
        var current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }

        System.out.println();
    }
}
