public interface Queue{
	public int size();
	public boolean isEmpty();
	public void enqueue(Object item);
	public Object dequeue();
	public Object front();
}