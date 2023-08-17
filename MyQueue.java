package Queue;

import java.util.NoSuchElementException;

public class MyQueue<T> {

    private Object[] queue;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue() {
        queue = new Object[DEFAULT_CAPACITY];
        size = 0;
        rear = -1;
        front = 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        rear = -1;
        front = 0;
    }

    public void add(T value) {
        if (size == queue.length) {
            increaseCapacity();
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
    }

    private void increaseCapacity() {
        int newCapacity = queue.length * 2;
        Object[] newQueue = new Object[newCapacity];
        System.arraycopy(queue, 0, newQueue, 0, size);
        queue = newQueue;
        front = 0;
        rear = size - 1;
    }

    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return (T) queue[front];
    }

    public T poll() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        T element = (T) queue[front];
        front = (front + 1) % queue.length;
        size--;
        return element;
    }
}