package Stack;

import list.Node;

public class LinkedStack<T> implements StackInterface<T> {
    private Node<T> top;
    private int size;
    private final T ERROR = null;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public void push(T element) {
        top = new Node<>(element, top);

        size++;

        printStack();
    }

    public T pop() {
        if (isEmpty()) return ERROR;

        Node<T> temp = top;
        top = top.getNext();

        size--;

        printStack();
        return temp.getData();
    }

    public void popAll() {
        top = null;

        size = 0;
        printStack();
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (isEmpty()) return ERROR;
        else return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    // 동적 생성으로 인한 항상 false
    public boolean isFull() {
        return false;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    private Node<T> getNode(int index) {
        if (index >= 0 && index < size) {
            Node<T> temp = top;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp;
        } else {
            return null;
        }
    }

    private void printStack() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(getNode(i).getData() + " ");
        }
        System.out.println("]");
    }
}
