package Stack;

public class ArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int top;

    private static final int DEFAULT_CAPACITY = 64;
    private final T ERROR = null;

    public ArrayStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public ArrayStack(int capacity) {
        stack = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T element) {
        if (!isFull())
            stack[++top] = element;

        printStack();
    }

    public T pop() {
        if (isEmpty())
            return ERROR;

        T element = stack[top];
        stack[top--] = null;

        printStack();
        return element;
    }

    public void popAll() {
        for (int i = top; i >= 0; i--)
            pop();
    }

    public int size() {
        return top + 1;
    }

    public T peek() {
        if (isEmpty()) return ERROR;

        return stack[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public void clear() {
        stack = (T[]) new Object[stack.length];
        top = -1;
    }

    private void printStack() {
        System.out.print("[ ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println("]");
    }
}
