import java.util.EmptyStackException;

public class SimpleStack {
    private String[] stack;
    private int size;

    public SimpleStack() {
        String[] stack = new String[0];
        size = 0;
    }

    public boolean empty() {
        if (size <= 0) {
            return true;
        }

        return false;
    }

    public String peek() {
        if(size <= 0) {
            throw new EmptyStackException();
        }

        return stack[size-1];
    }

    public String pop() {
        if (size <= 0) {
            throw new EmptyStackException();
        }

        String[] temp = new String[size-1];
        String tempVal;

        for (int i = 0; i < size - 1; i++) {
            temp[i] = stack[i];
        }

        tempVal = stack[size-1];
        stack = temp;

        size--;

        return tempVal;
    }

    public String push(String s) {
        String[] temp = new String[size+1];

        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }
        temp[size] = s;
        stack = temp;

        size++;

        return s;
    }

    public int search(String s) {
        int index = 0;

        for (int i = 0; i < size; i++) {
            if (stack[i] == s) {
                return size - index;
            }
            index++;
        }

        return -1;
    }

    public String toString() {
        String builder = "[";

        for (int i = 0; i < size; i++) {
            builder = builder + stack[i];

            if (size == 0 || i == size - 1) {
                return builder + "]";
            } else {
                builder = builder + ", ";
            }
        }

        return builder + "]";
    }
}
