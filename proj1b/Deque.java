public interface Deque<Item>{
    public int size();
    public void addFirst(Item x);
    public void addLast(Item x);
    public T removeFirst();
    public T removeLast();
    public T get(int index);
    public boolean isEmpty();
    public void printDeque();
}
