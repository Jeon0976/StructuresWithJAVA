package list;

public class LinkedList<T> implements ListInterface<T> {
    private Node<T> head;
    private int size;

    private final int NOT_FOUND = -12345;

    public LinkedList() {
        head = null;
        size = 0;

        printElements();
    }

    // 연결 리스트의 맨 앞에 원소 추가하기
    public void push(T element) {
        insertAt(0, element);
    }

    // 연결 리스트 맨 마지막에 원소 추가하기
    public void append(T element) {
        if (head == null)
            head = new Node<>(element);
        else {
            Node<T> prevNode = head;

            while (prevNode.getNext() != null)
                prevNode = prevNode.getNext();

            Node<T> newNode = new Node<>(element);
            prevNode.setNext(newNode);
        }

        size++;
        printElements();
    }

    // 연결 리스트에 원소 x 삽입하기
    public void insertAt(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        if (index == 0) {
            Node<T> newNode = new Node<>(element, head);
            head = newNode;
        } else {
            Node<T> prevNode = getNode(index - 1);
            Node<T> newNode = new Node<>(element, prevNode.getNext());
            prevNode.setNext(newNode);
        }

        size++;
        printElements();
    }

    public T pop() {
        return removeAt(0);
    }

    public T removeLast() {
        return removeAt(size - 1);
    }

    // 연결 리스트의 n번째 원소 삭제하기
    public T removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        Node<T> currNode = null;
        Node<T> prevNode = null;

        if (index == 0) {
            currNode = head;
            head = head.getNext();
        } else {
            prevNode = getNode(index-1);
            currNode = prevNode.getNext();
            prevNode.setNext(currNode.getNext());
        }

        size--;
        printElements();

        return currNode.getData();
    }

    // 연결 리스트에서 원소 x 삭제하기
    public boolean removeItem(T element) {
        if (size == 0) return false;

        Node<T> currNode = head;
        Node<T> prevNode = null;

        for (int i = 0; i < size; i++) {
            if (currNode.getData().equals(element)) {
                if (prevNode == null)
                    head = currNode.getNext();
                else
                    prevNode.setNext(currNode.getNext());
                size--;
                printElements();
                return true;
            }

            prevNode = currNode;
            currNode = currNode.getNext();
        }

        return false;
    }

    // 연결 리스트의 n번째 원소 알려주기
    public T get(int index) {
        if (index >= 0 && index < size) {
            return getNode(index).getData();
        } else
            return null;
    }

    // 연결 리스트의 n번째 노드 알려주기
    private Node<T> getNode(int index) {
        if (index >= 0 && index < size) {
            Node<T> currentNode = head;

            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            return currentNode;
        } else
            return null;
    }

    // 연결 리스트의 n번째 원소를 x로 대체하기
    public void set(int index, T element) {
        if (index >= 0 && index < size) {
            getNode(index).setData(element);
            printElements();
        } else
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    // 원소 x가 연결 리스트의 몇 번째 원소인지 알려주기
    public int indexOf(T element) {
        Node<T> currNode = head;
        for (int i = 0; i < size; i++) {
            if (currNode.getData().equals(element))
                return i;
            currNode = currNode.getNext();
        }

        return NOT_FOUND;
    }

    // 연결 리스트의 총 원소 수 알려주기
    public int size() {
        return size;
    }

    // 연결 리스트가 비어있는지 알려주기
    public boolean isEmpty() {
        return size == 0;
    }

    // 연결 리스트 비우기
    public void clear() {
        head = null;
        size = 0;

        printElements();
    }

    // 연결 리스트 현재 상태 출력하기
    private void printElements() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(getNode(i).getData() + " ");
        }
        System.out.println("]");
    }
}
