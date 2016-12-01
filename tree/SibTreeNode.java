class SibTreeNode {
	Object item;
	boolean valid;
	SibTree myTree;
	SibTreeNode parent;
	SibTreeNode firstChild;
	SibTreeNode nextSibling;

	public SibTreeNode(){
		this(null,false,null,null,null,null);
	}
	public SibTreeNode(Object i,boolean v,SibTree tree,SibTreeNode p,SibTreeNode f,SibTreeNode n){
		item=i;
		valid=v;
		myTree=tree;
		parent=p;
		firstChild=f;
		nextSibling=n;
	}

	public boolean isValidNode(){
		return valid;
	}
	public SibTreeNode parent(){
		if(parent==null)
			return new SibTreeNode();
		return this.parent;
	}

	public SibTreeNode insertChild(Object i,int c){
		if(this.isValidNode()){
			SibTreeNode newset=new SibTreeNode(i,true,myTree,this,null,null);

			if(firstChild==null){//added in the firstChild no matter what c is
				this.firstChild=newset;
				myTree.size++;
				return newset;
			}
			if(c<=1 && firstChild.nextSibling==null){//swap to the firstChild
				SibTreeNode temp=firstChild;
				firstChild=newset;
				firstChild.nextSibling=temp;
				myTree.size++;
				return newset;
			}
			if(c>1 && firstChild.nextSibling==null){//added in nextSibling 
				firstChild.nextSibling=newset;
				myTree.size++;
				return newset;
			}
			 if(c<=1 && firstChild.nextSibling!=null){//swap to first position while none were null
			 	SibTreeNode temp=firstChild;
			 	firstChild=newset;
			 	newset.nextSibling=temp;
			 	myTree.size++;
			 	return newset;
			 }
			 if(c>1 && firstChild.nextSibling!=null){
			 	SibTreeNode temp=firstChild;
			 	int counter=1;
			 	while(temp.nextSibling!=null){
			 		if((counter+1)==c){
			 			newset.nextSibling=temp.nextSibling;
			 			temp.nextSibling=newset;
			 			myTree.size++;
			 			return newset;
			 		}
			 		counter++;
			 		temp=temp.nextSibling;
			 	}
			 	temp.nextSibling=newset;
			 	myTree.size++;
			 	return newset;
			 }
			}else{
				System.out.println("Invalid Node");
			}
			return new SibTreeNode();
		}

	public SibTreeNode removeLeaf(){
		if (isValidNode() && firstChild==null){
				this.myTree.size--;

				SibTreeNode temp=this.parent.firstChild;

				//if it is the firstChild
				if(this.equals(temp)){
					this.parent.firstChild=this.parent.firstChild.nextSibling;
				}
				while(temp!=null){
					if(this.equals(temp.nextSibling)){
						temp.nextSibling=temp.nextSibling.nextSibling;
					}
					temp=temp.nextSibling;
				}

				this.valid=false;
				this.myTree=null;
				this.parent=null;
				this.firstChild=null;
				this.nextSibling=null;
				
				return new SibTreeNode();
		}
		else{
			System.out.println("Invalid node");
		}
		return new SibTreeNode();
	}

	public void preOrder(){
		System.out.println(item);
		if(firstChild!=null){
			System.out.print("  ");
			firstChild.preOrder();
		}
		if(nextSibling!=null){
			System.out.print("  ");
			nextSibling.preOrder();
		}

	}
}