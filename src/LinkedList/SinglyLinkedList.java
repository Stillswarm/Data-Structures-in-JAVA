
package LinkedList;

import java.util.Scanner;

/**
 *
 * @param <T> the datatype of the values to be stored in the linked list
 * @author <a href="https://github.com/Stillswarm">Stillswarm</a>
 */
public class SinglyLinkedList<T> implements LinkedList<T> {

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node<T> head;

    public SinglyLinkedList() {
        size = 0;
        head = null;
    }

    @Override
    public void insertFirst(T value) {
        var newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        ++size;
    }

    @Override
    public void insertLast(T value) {
        var newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            var current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        ++size;
    }

    @Override
    public void insertAt(int position, T value) {
        if (position == 1) insertFirst(value);
        else if (position > size) insertLast(value);
        else {
            var newNode = new Node<>(value);
            int pos = 1;
            var current = head;
            while (pos++ < position - 1) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        ++size;
    }

    @Override
    public T deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchNodeException(1);
        } else {
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
                var current = head;
                while (current.next.next != null) {
                    current = current.next;
                }

                T value = current.next.data;
                current.next = null;

                --size;
                return value;
            }
        }
    }

    @Override
    public T deleteAt(int position) {
        if (position < 0 || size < position) {
            Scanner sc = new Scanner(System.in);
            sc.nextInt();
            throw new NoSuchNodeException(position);
        } else {
            if (position == 1) {
                return deleteFirst();
            } else {
                var current = head;
                int pos = 1;
                while (pos++ < position - 1) {
                    current = current.next;
                }

                T value = current.next.data;
                current.next = current.next.next;

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
}
