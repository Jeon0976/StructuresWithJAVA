import Stack.ArrayStack;
import Stack.LinkedStack;
import list.ArrayList;
import list.CircularLInkedList;
import list.DoublyLinkedList;
import list.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.push(10);
        System.out.println(stack.peek());
        stack.popAll();
        stack.push(3);
    }
}