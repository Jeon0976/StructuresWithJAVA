package list;

public interface ListInterface<T> {
    public void push(T element);
    public void append(T element);
    public void insertAt(int index, T element);

    public T pop();
    public T removeLast();
    public T removeAt(int index);
    public boolean removeItem(T element);

    public T get(int index);
    public void set(int index, T element);
    public int indexOf(T element);

    public int size();
    public boolean isEmpty();
    public void clear();
}
