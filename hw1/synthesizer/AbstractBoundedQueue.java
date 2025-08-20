package synthesizer;
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>{
    protected int fillCount;
    protected int capacity;
    @Override
    public int capacity(){
        return capacity;
    }
    @Override
    public int fillCount(){
        return fillCount;
    }
    public abstract void enqueue();
    public abstract T peek();
    public abstract T dequeue();
}
