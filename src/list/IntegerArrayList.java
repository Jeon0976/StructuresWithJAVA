package list;

public class IntegerArrayList implements IntegerListInterface {
    private Integer[] items;
    private int count;
    private static final int DEFAULT_CAPACITY = 64;
    private final int NOT_FOUND = -12345;

    // 생성자
    public IntegerArrayList() {
        items = new Integer[DEFAULT_CAPACITY];
        count = 0;

        printItems();
    }

    // 생성자
    public IntegerArrayList(int size) {
        items = new Integer[size];
        count = 0;

        printItems();
    }

    // 배열 리스트의 n번째 자리에 원소 x 삽입하기
    public void add(int index, Integer value) {
        if (items == null)
            throw new NullPointerException("The array is null.");

        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        if (count >= items.length)
            throw new IllegalStateException("The array is full.");

        for (int i = count; i > index; i--)
            items[i] = items[i - 1]; // 우시프트

        items[index] = value;
        count++;

        printItems();
    }
    // 배열 리스트의 맨 뒤에 원소 추가하기
    public void append(Integer value) {
        if (count >= items.length)
            throw new IllegalStateException("The array is full.");
        else {
            items[count++] = value;

            printItems();
        }
    }

    // 배열 리스트의 n번째 원소 삭제하기
    public Integer remove(int index) {
        if (isEmpty() || index < 0 || index >= count) {
            return null;
        } else {
            Integer tmp = items[index];

            for (int i = index + 1; i < count; i++)
                items[i - 1] = items[i]; // 좌시프트

            count--;
            printItems();
            return tmp;
        }
    }

    // 배열 리스트에서 원소 x 삭제하기
    public boolean removeItem(Integer value) {
        int k = 0;
        while (k < count && !items[k].equals(value))
            k ++;

        if (k == count) {
            return false;
        } else {
            for (int i = k + 1; i < count; i++)
                items[i - 1] = items[i]; // 좌시프트

            count --;
            printItems();
            return true;
        }
    }

    // 배열 리스트의 n번째 원소 알려주기
    public Integer get(int index) {
        if (index >= 0 && index < count)
            return items[index];
        else
            return null;
    }

    // 배열 리스트의 n번째 원소를 x로 대체하기
    public void set(int index, Integer value) {
        if (index >= 0 && index < count) {
            items[index] = value;
            printItems();
        } else
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    // 원소 x가 배열 리스트의 몇 번째 원소인지 알려주기
    public int indexOf(Integer value) {
        for (int i = 0; i < count; i++)
            if (items[i].equals(value))
                return i;

        return NOT_FOUND;
    }

    // 배열 리스트의 총 원소 수 알려주기
    public int size() {
        return count;
    }

    // 배열 리스트가 비어있는지 알려주기
    public boolean isEmpty() {
        return count == 0;
    }

    // 배열 리스트 비우기
    public void clear() {
        items = new Integer[items.length];
        count = 0;

        printItems();
    }

    // 배열의 현재 상태 출력하기
    private void printItems() {
        System.out.print("[ ");
        for (int i = 0; i < count; i++)
            System.out.print(items[i] + " ");
        System.out.println("]");
    }
}
