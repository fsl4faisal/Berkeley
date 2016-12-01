
class SListNode{
	Object item;
	SListNode next;

	public SListNode(){}

	public SListNode(Object i){
		this(i,null);
	}
	public SListNode(Object i,SListNode n){
		item=i;
		next=n;
	}

	public boolean isValidNode(){
		if(this.item!=null)
			return true;
		else 
			return false;
	}

	public Object item(){
		return item;
	}
	
	public String toString(){
		return this.item().toString();
	}
	public void prev(){

	}
}

class SList {
	SListNode head;
	int size;

	public boolean isEmpty(){
		return size==0;
	}
	public void insertFront(Object item){
		SListNode newest;
		if(head==null){
			newest=new SListNode(item,null);
			head=newest;
		}else{
			newest=new SListNode(item,head);
			head=newest;
		}
		size++;
	}

	public SListNode front(){
		return this.head;
	}
	
	public void remove(SListNode node){
		System.out.println("Removing node");
		SListNode temp=head;
		if(node.item.equals(head.item)){//removeFirst()
			head=head.next;
			size--;
			return;
		}
		while(temp.next!=null){
			if(temp.next.item.equals(node.item)){
				temp.next=temp.next.next;
				size--;
				return;
			}
			temp=temp.next;
		}		

		
	}

	public String toString(){
		//System.out.println("custom toString");
		String list="";
		//System.out.println(this.size);
		SListNode temp=head;
		
		if(isEmpty()){
			list="List Empty";
			return list;
		}
		
		while(temp!=null){
			list+=temp.item().toString();
			list+="->";
			temp=temp.next;
		}
		return list;
	}

}