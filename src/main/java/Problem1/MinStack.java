package Problem1;

public class MinStack extends ArrayStack<Integer> {
    // okay to add member variables
    // can only use Stack interface and ArrayStack from this folder
    // do not use Java Stack
    int size = 0;
    int keepSize = 0;
    int minSize = 0;
    private Integer[] stack;
    private Integer[] min;

    public MinStack(int size) {
        // homework
        super(size);
        stack = new Integer[size];
        min = new Integer[size];
        keepSize = size;
    }

    @Override
    public boolean push(Integer val) {
        // homework
        if(size < stack.length) {
            stack[size] = val;
            size++;
            if (min[0] == null) {
                min[0] = val;
            } else if (stack[size -1] < min[minSize]){
                minSize++;
                min[minSize] = val;
            }
            return true;
        }
        return false;
    }

    @Override
    public Integer pop() {
        // homework
        if(size == 0){
            System.out.println("Stack is empty");
        }
        if(minSize == 0) {
            min = new Integer[keepSize];
        } else if(minSize > 0) {
            if (stack[size - 1] == min[minSize]) {
                minSize--;
            }
        }
        Integer val = stack[size - 1];
        size--;
        return val;
    }

    public Integer getMin() {
        // homework
        // loop of any kind is not allowed
        if(min.length == 0 || min == null){
            return null;
        }
        return min[minSize];
    }
}

