public class ArrayDeque<T> {
    private T[] items;
    private int size;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }
    public int size() {
        return size;
    }
    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arrycopy(items,0,a,0,size);
        items =a ;
    } 
    public void addFirst(T x){ 
        if(size == items.length){
            resize(size*2);
        }
        System.arrycopy(items,0,items,1,size);
        items[0] = x;
        size += 1;
    }
    public void addLast(T x){
        if(size == items.length){
            resize(size*2);
        }
        items[size] = x;
        size += 1;
    }
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }
    public T get(int i){
        return items[i];
    }
    public T getLast(){return items[size-1];}
    public T getFirst(){return items[0];}
    public T removeFirst(){
        T x = getFirst();
        System.arrycopy(items,1,items,0,size-1);
        size -= 1;
        return x;
    }
    public T removeLast(){
        T x = getLast();
        items[size-1] = null;
        size -= 1;
        return x;
    }
    public void printDeque(){
        for(int i = 0;i<size;i++){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }
    public T remove(int i){
        T x = get(i);
        System.arrycopy(items,i+1,items,i,size-i-1);
        size -= 1;
        return x;
    }
    public ArrayDeque(ArrayDeque other){
        items = (T[]) new Object[other.size()];
        size = other.size();
        System.arrycopy(other.items,0,items,0,size);
    }
    
}