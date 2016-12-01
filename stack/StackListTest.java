class StackList implements Stack{
	private SListNode head;
	private int size;

	public StackList(){
		head=null;
		size=0;

	}
	public boolean isEmpty(){
		return size==0;
	}

	public int size(){
		return size;
	}

	public void push(Object item){
		SListNode temp=new SListNode(item,head);
		head=temp;
		size++;
	}
	public Object pop(){
		if(head==null){
			System.out.println("List empty");
			return null;
		}
		SListNode temp=head;
		head=head.next;
		size--;
		return temp.item;
	}

	public Object top(){
		if(head==null){
			System.out.println("List empty");
			return null;
		}
		
		return head.item;	
	}
	public String toString(){
		String line="";
		SListNode temp=head;
		while(temp!=null){
			line+=temp.item+"->";
			temp=temp.next;
		}
		return line;
	}

}

public class StackListTest{
	public static void main(String[] args) {
		StackList stack=new StackList();
		stack.push(1);
		System.out.println("stack.top():"+stack.top());
		stack.push(2);
		System.out.println(stack);
		System.out.println("stack.top():"+stack.top());
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		stack.push(6);
		System.out.println(stack);
		stack.push(16);
		System.out.println(stack);
		System.out.println(stack.size());

	}
}