package Problem1;

public class ArrayStack<T> implements Stack<T> {
    // do not change member variables
    private T[] data;
    private int size;

    private ArrayStack() {
    }

    public ArrayStack(int capacity) {
        // homework
        data = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean push(T val) {
        // homework
        if(size < data.length) {
            data[size] = val;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public T pop() {//Pulls out the first element at
        // homework
        if(size == 0){//checks if stack is empty
            System.out.println("Stack is empty");
        }
        T val = data[size - 1];
        size--;
        return val;
    }

    @Override
    public T peek() {
        // homework
        if (size == 0) {//checks if stack is empty
            System.out.println("Stack is empty");
        }
        T val = data[size - 1];
        return val;
    }
    @Override
    public int size() {
        return size;
    }
}
