class QueueList implements Queue {
	private SListNode head;
	private int size;

	public QueueList(){
		head=null;
		size=0;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}

	public void enqueue(Object i){
		SListNode newest=new SListNode(i);
		if(head==null){
			head=newest;
			size++;
			return;
		}
		SListNode temp=head;
		while(temp.next!=null)
			temp=temp.next;
		temp.next=newest;
		size++;
		return;
	}

	public Object dequeue(){
		if(head==null){
			System.out.println("List Empty");
			return null;
		}
		Object item=head.item;
		head=head.next;
		size--;
		return item;
	}

	public Object front(){
		if(head==null){
			System.out.println("List Empty");
			return null;
		}
		Object item=head.item;
		return item;
	}

	public String toString(){
		String list="";
		SListNode temp=head;
		while(temp!=null){
			list+=temp.item+"->";
			temp=temp.next;
		}
		return list;
	}
}
public class QueueListTest {
	public static void main(String[] args) {
		QueueList queue=new QueueList();
		System.out.println("isEmpty():"+queue.isEmpty());
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println("isEmpty():"+queue.isEmpty());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(1);
		System.out.println(queue.front());
		System.out.println(queue);
		System.out.println("size:"+queue.size());


	}

}