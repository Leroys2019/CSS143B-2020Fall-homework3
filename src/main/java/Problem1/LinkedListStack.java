package Problem1;

import java.util.LinkedList;

public class LinkedListStack<T> implements Stack<T> {
    // use Java LinkedList to store the data
    // do not change member variables
    private LinkedList<T> data;

    public LinkedListStack() {
        // homework
        data = new LinkedList();
    }

    @Override
    public boolean push(T val) {
        // homework
        data.push(val);
        return true;
    }

    @Override
    public T pop() {
        // homework
        return data.pop();
    }

    @Override
    public T peek() {
        // homework
        return data.peek();
    }

    @Override
    public int size() {
        return data.size();
    }
}
