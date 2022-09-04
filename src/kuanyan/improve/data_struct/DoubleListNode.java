package kuanyan.improve.data_struct;

public class DoubleListNode<T> {
    public T value;
    public DoubleListNode<T> last = null;
    public DoubleListNode<T> next = null;

    public DoubleListNode(T value) {
        this.value = value;
    }
}
