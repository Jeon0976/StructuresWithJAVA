package Stack;

public interface StackInterface<T> {
    public void push(T element);

    public T pop();
    public void popAll();

    public int size();
    public T peek();
    public boolean isEmpty();
    public boolean isFull();
    public void clear();
}
