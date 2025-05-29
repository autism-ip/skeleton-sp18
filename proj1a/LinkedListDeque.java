public class LinkedListDeque<T> {
    public static class IntNode<T> {
		public T item;
		public IntNode<T> next;
		public IntNode<T> prev;

		public IntNode(T item, IntNode<T> next, IntNode<T> prev) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
		
	}
	private int size;
	private IntNode<T> sentinel;
	
	
	public LinkedListDeque() {
		sentinel = new IntNode<T>(null, null,null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		
		size = 0;
	}

	public void addFirst(T x) {
		IntNode<T> p = new IntNode<T>(x,sentinel.next,sentinel);
		sentinel.next = p;
		sentinel.next.prev = p;
		size += 1;
	}
	public void addLast(T x) {
		sentinel.prev.next = new IntNode(x,sentinel,sentinel.prev);
		sentinel.prev = sentinel.prev.next;
		size += 1;
	}
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	public int size() {
		return size;
	}
	public T removeFirst() {
		if(sentinel.next == sentinel){
			return null;
		}
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size -= 1;
		return sentinel.next.item;
	}
	public T removeLast() {
		if(sentinel.prev == sentinel){
			return null;
		}
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		size -= 1;
		return sentinel.prev.item;
	}
	public void printDeque() {
        IntNode<T> p = sentinel.next;
		while (p != sentinel) {
			System.out.print(p.item+" ");
			p = p.next;
		}
        System.out.println();
	}
	
	public T get(int index) {
		if(index < 0 || index >= size) {
			return null;
		}
		IntNode<T> p = sentinel.next;
		for(int i = 0;i<index;i++) {
			p = p.next;
		}
		return p.item;
    }   
    public T getRecursive(int index) {
		if(index < 0 || index >= size) {
			return null;
		}
        else if (index == 0) {
			return sentinel.next.item;
		}
        return getRecursiveHelper(sentinel.next,index-1);
    }
	public T getRecursiveHelper(IntNode<T> p,int index) {
		if(index == 0) {
			return p.item;
		}
		return getRecursiveHelper(p.next,index-1);
	}

   public  LinkedListDeque(LinkedListDeque other) {
		sentinel = new IntNode<T>(null,null,null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		size = 0;
		for(int i = 0;i<other.size();i++) {
			addLast((T) other.get(i));
		}

}
