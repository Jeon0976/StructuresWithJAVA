package list;

public class DoublyLinkedList<T> implements ListInterface<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private final int NOT_FOUND = -12345;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;

        printElements();
    }

    public void push(T element) {
        insertAt(0, element);
    }

    public void append(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            push(element);
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }

        size++;
        printElements();
    }

    public void insertAt(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            }
        } else {
            Node<T> prevNode = getNode(index - 1);
            newNode.setNext(prevNode.getNext());

            if (prevNode.getNext() != null) {
                prevNode.getNext().setPrev(newNode);
            }

            newNode.setPrev(prevNode);
            prevNode.setNext(newNode);
            if (newNode.getNext() == null) {
                tail = newNode;
            }
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

    public T removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        Node<T> currNode = null;

        if (index == 0) {
            currNode = head;
            if (head.getNext() != null) {
                head = head.getNext();
                head.setPrev(null);
            } else {
                head = null;
                tail = null;
            }
        } else {
            currNode = getNode(index);
            Node<T> prevNode = currNode.getPrev();
            Node<T> nextNode = currNode.getNext();

            if (prevNode != null)
                prevNode.setNext(nextNode);
            if (nextNode != null)
                nextNode.setPrev(prevNode);
            if (currNode == tail)
                tail = prevNode;
        }

        size--;
        printElements();

        return currNode.getData();
    }

    public boolean removeItem(T element) {
        if (size == 0) return false;

        Node<T> currNode = head;

        for (int i = 0; i < size; i++) {
            if (currNode.getData().equals(element)) {
                Node<T> prevNode = currNode.getPrev();
                Node<T> nextNode = currNode.getNext();

                if (prevNode == null)
                    head = nextNode;
                else
                    prevNode.setNext(nextNode);
                if (nextNode != null)
                    nextNode.setPrev(prevNode);
                if (currNode == tail)
                    tail = prevNode;

                size--;
                printElements();
                return true;
            }
            currNode = currNode.getNext();
        }

        return false;
    }

    public T get(int index) {
        if (index >= 0 && index < size)
            return getNode(index).getData();
        else
            return null;
    }

    private Node<T> getNode(int index) {
        if (index >= 0 && index < size) {
            Node<T> currNode = null;
            if (index < size / 2) {
                currNode = head;
                for (int i = 0; i < index; i++)
                    currNode = currNode.getNext();
            } else {
                currNode = tail;
                for (int i = size - 1; i > index; i--)
                    currNode = currNode.getPrev();
            }

            return currNode;
        } else
            return null;
    }

    public void set(int index, T element) {
        if (index >= 0 && index < size) {
            getNode(index).setData(element);
            printElements();
        } else
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    public int indexOf(T element) {
        Node<T> currNode = head;
        for (int i = 0; i < size; i++) {
            if (currNode.getData().equals(element))
                return i;
            currNode = currNode.getNext();
        }

        return NOT_FOUND;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

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
