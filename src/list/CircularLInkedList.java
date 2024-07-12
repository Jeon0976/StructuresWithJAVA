package list;

public class CircularLInkedList<T> implements ListInterface<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private final int NOT_FOUND = -12345;

    public CircularLInkedList() {
        head = null;
        tail = null;
        size = 0;

        printElements();
    }

    // 연결 리스트의 맨 앞에 원소 추가하기
    public void push(T element) {
        insertAt(0, element);
    }

    // 연결 리스트 맨 마지막에 원소 추가하기
    public void append(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null)
            push(element);
        else {
            newNode.setNext(head);
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
        printElements();
    }

    // 연결 리스트에 원소 x 삽입하기
    public void insertAt(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            if (head == null) {
                head = newNode;
                tail = newNode;
                head.setNext(head);
            } else {
                newNode.setNext(head);
                head = newNode;
                tail.setNext(head);
            }
        } else {
            Node<T> prevNode = getNode(index - 1);
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);

            if (index == size)
                tail = newNode;
        }

        size++;
        printElements();
    }

    // 연결 리스트의 맨 앞의 원소 제거하기
    public T pop() {
        return removeAt(0);
    }

    // 연결 리스트의 마지막 원소 제거하기
    public T removeLast() {
        if (size == 0)
            return null;

        Node<T> currNode = tail;
        Node<T> prevNode = null;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            prevNode = getNode(size - 2);
            prevNode.setNext(head);
            tail = prevNode;
        }

        size--;
        printElements();
        return currNode.getData();
    }

    // 연결 리스트의 n번째 원소 삭제하기
    public T removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        Node<T> currNode = null;
        Node<T> prevNode = null;

        if (index == 0) {
            currNode = head;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                tail.setNext(head);
            }
        } else {
            prevNode = getNode(index - 1);
            currNode = prevNode.getNext();
            prevNode.setNext(currNode.getNext());

            if (currNode == tail)
                tail = prevNode;
        }

        size--;
        printElements();

        return currNode.getData();
    }

    // 연결 리스트에서 원소 x 삭제하기
    public boolean removeItem(T element) {
        if (size == 0) return false;

        Node<T> currNode = head;
        Node<T> prevNode = tail;

        for (int i = 0; i < size; i++) {
            if (currNode.getData().equals(element)) {
                if (currNode == head) {
                    head = head.getNext();
                    tail.setNext(head);
                } else {
                    prevNode.setNext(currNode.getNext());
                }

                if (currNode == tail)
                    tail = prevNode;

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
        if (index >= 0 && index < size)
            return getNode(index).getData();
        else
            return null;
    }

    // 연결 리스트의 n번째 노드 알려주기
    private Node<T> getNode(int index) {
        if (index >= 0 && index < size) {
            Node<T> currNode = head;

            for (int i = 0; i < index; i++) {
                currNode = currNode.getNext();
            }
            return currNode;
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
        tail = null;
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
