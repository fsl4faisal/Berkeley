public class SListNode{
	Object item;
	SListNode next;

	public SListNode(Object i){
		this(i,null);
	}
	public SListNode(Object i,SListNode n){
		item=i;
		next=n;
	}
	// public String toString(){
	// 	return (String)item;
	// }
}