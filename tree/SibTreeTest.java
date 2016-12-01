 class SibTree{
	SibTreeNode root;
	int size;

	public SibTree(){
		root=null;
		size=0;
	}

	
}

class SibTreeTest {
	public static void main(String[] args) {
		SibTree tree=new SibTree();
		SibTreeNode r=new SibTreeNode("61b",true,tree,null,null,null);
		tree.root=r;
		tree.size++;
		System.out.println("preOrder traversal");
		r.preOrder();
		SibTreeNode hw=r.insertChild("hw",1);
		System.out.println("preOrder traversal");
		r.preOrder();
		SibTreeNode index=r.insertChild("index.html",2);
		SibTreeNode lab=r.insertChild("lab",3);
		SibTreeNode lec=r.insertChild("lec",4);
		SibTreeNode practice=r.insertChild("practice",5);
		SibTreeNode test=r.insertChild("test",56);

		SibTreeNode hw1=hw.insertChild("hw1",1);
		System.out.println("hw1.parent.item: "+hw1.parent.item);
		


		System.out.println("preOrder traversal");
		r.preOrder();
		System.out.println(tree.size);
		test=test.removeLeaf();
		System.out.println(tree.size+" "+test.isValidNode());
		System.out.println("preOrder traversal");
		r.preOrder();
		System.out.println(tree.size);
	}
}