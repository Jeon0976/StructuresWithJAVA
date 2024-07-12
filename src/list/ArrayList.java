package list;

public class ArrayList<T> implements ListInterface<T> {
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 64;
    private final int NOT_FOUND = -12345;

    // 생성자
    public ArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;

        printElements();
    }

    // 생성자
    public ArrayList(int size) {
        elements = (T[]) new Object[size];
        this.size = 0;

        printElements();
    }

    // 배열 리스트의 맨 앞에 원소 추가하기
    public void push(T element) {
        insertAt(0, element);
    }

    // 배열 리스트의 맨 뒤에 원소 추가하기
    public void append(T element) {
        if (size >= elements.length)
            throw new IllegalStateException("The array is full.");
        else {
            elements[size++] = element;

            printElements();
        }
    }

    // 배열 리스트의 n번째 자리에 원소 x 삽입하기
    public void insertAt(int index, T element) {
        if (elements == null)
            throw new NullPointerException("The array is null.");

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        if (size >= elements.length)
            throw new IllegalStateException("The array is full.");

        for (int i = size; i > index; i--)
            elements[i] = elements[i - 1]; // 우 쉬프트

        elements[index] = element;
        size++;

        printElements();
    }

    // 배열 리스트의 맨 앞의 원소 제거하기
    public T pop() {
        return removeAt(0);
    }

    public T removeLast() {
        if (isEmpty())
            return null;
        else {
            T tmp = elements[--size];
            elements[size] = null;
            printElements();
            return tmp;
        }
    }

    // 배열 리스트의 n번째 원소 삭제하기
    public T removeAt(int index) {
        if (isEmpty() || index < 0 || index >= size)
            return null;
        else {
            T tmp = elements[index];

            for (int i = index + 1; i < size; i++)
                elements[i - 1] = elements[i]; // 좌 쉬프트

            elements[--size] = null;
            printElements();

            return tmp;
        }
    }

    // 배열 리스트에서 원소 x 삭제하기
    public boolean removeItem(T element) {
        int k = 0;
        while (k < size && !(elements[k].equals(element)))
            k++;

        if (k == size)
            return false;
        else {
            for (int i = k + 1; i < size; i ++)
                elements[i - 1] = elements[i];

            elements[--size] = null;
            printElements();
            return true;
        }
    }

    // 배열 리스트의 n번째 원소 알려주기
    public T get(int index) {
        if (index >= 0 && index < size)
            return elements[index];
        else
            return null;
    }

    // 배열 리스트의 n번째 원소를 x로 대체하기
    public void set(int index, T element) {
        if (index >= 0 && index < size) {
            elements[index] = element;
            printElements();
        } else
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    // 원소 x가 배열 리스트의 몇 번째 원소인지 알려주기
    public int indexOf(T element) {
        for (int i = 0; i < size; i++)
            if (elements[i].equals(element))
                return i;

        return NOT_FOUND;
    }

    // 배열 리스트의 총 원소 수 알려주기
    public int size() {
        return size;
    }

    // 배열 리스트가 비어있는지 알려주기
    public boolean isEmpty() {
        return size == 0;
    }

    // 배열 리스트 비우기
    public void clear() {
        elements = (T[]) new Object[elements.length];
        size = 0;

        printElements();
    }

    // 배열의 현재 상태 출력하기
    private void printElements() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++)
            System.out.print(elements[i] + " ");
        System.out.println("]");
    }
}
