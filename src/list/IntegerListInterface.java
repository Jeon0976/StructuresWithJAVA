package list;

public interface IntegerListInterface {
    public void add(int index, Integer value);
    public void append(Integer value);

    public Integer remove(int index);
    public boolean removeItem(Integer value);

    public Integer get(int index);
    public void set(int index, Integer value);

    public int indexOf(Integer value);
    public int size();
    public boolean isEmpty();
    public void clear();
}
