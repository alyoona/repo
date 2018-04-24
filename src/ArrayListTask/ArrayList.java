package ArrayListTask;

public class ArrayList implements List {
    static final int INITIAL_CAPACITY = 5;

    Object[] array;
    int size;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public ArrayList(int capacity) {
        array = new Object[capacity];
    }

    public void add(Object value) {

    }

    @Override
    public void add(Object value, int index) {

    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    @Override
    public Object set(Object value, int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }

    public Object remove(int index) {
        return null;
    }
}
