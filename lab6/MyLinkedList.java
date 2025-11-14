package lab6;

import java.util.*;

/**
 * Власна реалізація колекції типу List на базі однозв’язного списку.
 * Тип колекції — узагальнений клас Aircraft (з лабораторної роботи №5).
 */
public class MyLinkedList<T> implements List<T> {

    /**
     * Внутрішній клас, що представляє вузол однозв’язного списку.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private int size;

    // Порожній конструктор
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Конструктор, що приймає один елемент
    public MyLinkedList(T element) {
        this();
        add(element);
    }

    //Конструктор, що приймає колекцію елементів
    public MyLinkedList(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (T item : this) {
            if (Objects.equals(item, o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (T item : this) {
            arr[i++] = item;
        }
        return arr;
    }

    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) return false;
        if (Objects.equals(head.data, o)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.data, o)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T item : c) {
            add(item);
            modified = true;
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.data;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        T old = current.data;
        current.data = element;
        return old;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Некоректний індекс: " + index);
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++)
                current = current.next;
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        if (index == 0) {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++)
            current = current.next;
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Некоректний індекс: " + index);
    }

    // Решта методів List
    @Override public int indexOf(Object o) { int i=0; for(T t:this){if(Objects.equals(t,o))return i; i++;} return -1; }
    @Override public int lastIndexOf(Object o) { return indexOf(o); }
    @Override public ListIterator<T> listIterator() { throw new UnsupportedOperationException(); }
    @Override public ListIterator<T> listIterator(int index) { throw new UnsupportedOperationException(); }
    @Override public List<T> subList(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }
    @Override public <E> E[] toArray(E[] a) { throw new UnsupportedOperationException(); }
    @Override public boolean containsAll(Collection<?> c) { for(Object o:c) if(!contains(o)) return false; return true; }
    @Override public boolean addAll(int index, Collection<? extends T> c) { throw new UnsupportedOperationException(); }
    @Override public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException(); }
}
