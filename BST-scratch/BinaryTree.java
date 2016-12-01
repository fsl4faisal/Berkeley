public class BinaryTree {

  protected int size;
  protected BinaryTreeNode root;

  public BinaryTree() {
    makeEmpty();
  }


  public void makeEmpty() {
    size = 0;
    root = null;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public BinaryTreeNode findNode(Object key){
    BinaryTreeNode node=findHelper((Comparable)key,root);
    if(node==null)
      return null;
    else
      return node;
  }

  public Entry remove(Object key){
    BinaryTreeNode node=this.findNode(key);
    removeHelper(node);
    size--;
    return node.entry;
  }

  public void removeHelper(BinaryTreeNode node){
    if(node!=root){// node is not a root node
      BinaryTreeNode parentNode=node.parent;

      if(node.leftChild==null && node.rightChild==null){//no child
        if(parentNode.leftChild==node)
          parentNode.leftChild=null;
        else
          parentNode.rightChild=null;
        //in both cases set node's parent to null--> remember the tree is actually a double linked list
        node.parent=null;
      }

      else if(node.leftChild==null || node.rightChild==null){//any one child is null
        if(parentNode.leftChild==node)
          parentNode.leftChild=removeOneChild(node);
        else
          parentNode.rightChild=removeOneChild(node);
      }
      else{//node has both children
        BinaryTreeNode bin=findLeftMostChild(node.rightChild);

        //setting parent node's child first
        if(parentNode.leftChild==node){
          parentNode.leftChild=bin;
        }
        else{
          parentNode.rightChild=bin;
        }
        bin.parent=parentNode;

        //setting new node's children now

        bin.leftChild=node.leftChild;
        bin.rightChild=node.rightChild;

        //setting bin's child's parent to bin
        if(bin.leftChild!=null)
          bin.leftChild.parent=bin;
        if(bin.rightChild!=null)
          bin.rightChild.parent=bin;

        return;

      }
    }

    else{// node is root node
      if(size==1) root=null;// if only root is there
      else if(node.leftChild==null || node.rightChild==null){//check if it has only one branch
        if(node.leftChild==null){//left branch is active
          node.rightChild.parent=null;
          root=node.rightChild;
          return;
        }
        else{
          node.leftChild.parent=null;
          root=node.leftChild;
          return;
        }
      }
      else{//both children present
        BinaryTreeNode bin=findLeftMostChild(node.rightChild);
        
        //setting bin's new children
        bin.leftChild=node.leftChild;
        bin.rightChild=node.rightChild;

        //giving bin's new children a new parent which is bin

        bin.leftChild.parent=bin;
        bin.rightChild.parent=bin;

        //removing bin's parent and setting it to null

        bin.parent=null;

        //and finally the nail in the coffin
        root=bin;
        return;

      }
  }
}

  private BinaryTreeNode removeOneChild(BinaryTreeNode node){
    if(node.leftChild==null){
      node.rightChild.parent=node.parent;
      return node.rightChild;
    }
    else{
      node.leftChild.parent=node.parent;
      return node.leftChild;
    }
  }

  private BinaryTreeNode findLeftMostChild(BinaryTreeNode node){
    BinaryTreeNode temp=node;

    while(temp.leftChild!=null)
      temp=temp.leftChild;
    removeHelper(temp);
    return temp;
  }


  public BinaryTreeNode findHelper(Comparable key,BinaryTreeNode node){
    if(node==null)
      return null;
    else if(key.compareTo(node.entry.key)==0)
      return node;
    else if(key.compareTo(node.entry.key)<0)
      return findHelper(key,node.leftChild);
    else if(key.compareTo(node.entry.key)>0)
      return findHelper(key,node.rightChild);
    return null;
  }
  public Entry find(Object key) {

    BinaryTreeNode node=findHelper((Comparable)key,root);
    if(node!=null){
      return node.entry;
    }
    return null;
    
  }

  public String toString() {
    if (root == null) {
      return "";
    } else {
      return root.toString();
    }
  }

  public Entry first(){
    BinaryTreeNode temp=root;
    while(temp.leftChild!=null){
      temp=temp.leftChild;
    }
    return temp.entry;
  }

  public Entry last(){
    BinaryTreeNode temp=root;
    while(temp.rightChild!=null){
      temp=temp.rightChild;
    }
    return temp.entry;
  }


  public void insertHelper(Entry entry,Comparable key,BinaryTreeNode node){
    if(key.compareTo(node.entry.key)<=0){
      if(node.leftChild==null){
        node.leftChild=new BinaryTreeNode(entry,node);
      }else{
        insertHelper(entry,key,node.leftChild);
      }
    }
    else{
      if(node.rightChild==null){
        node.rightChild=new BinaryTreeNode(entry,node);
      }else{
        insertHelper(entry,key,node.rightChild);
      }
    }
  }

  public Entry insert(Object key, Object value){
    Entry entry=new Entry(key,value);


    if(root==null){
      root=new BinaryTreeNode(entry);
    }else{
      insertHelper(entry,(Comparable) key,root);
    }
    size++;
    return entry;
  }






  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    tree.insert(new Integer(15), "");
    tree.insert(new Integer(10), "");
    tree.insert(new Integer(20), "");
    tree.insert(new Integer(8), "");
    tree.insert(new Integer(12), "");
    tree.insert(new Integer(17), "");
    tree.insert(new Integer(16), "");

    System.out.println("The tree is:  " + tree);
    System.out.println("Size:" + tree.size());

    System.out.println("In order traversal of keys");
    tree.root.inOrder();
    System.out.println();
    System.out.println("find(15):"+tree.find(15));
    System.out.println("find(20):"+tree.find(20));
    System.out.println("find(8):"+tree.find(8));
    //System.out.println("remove():"+tree.remove(20));

    System.out.println("The tree is:  " + tree);
    System.out.println("Size:" + tree.size());
    System.out.println("In order traversal of keys");
    tree.root.inOrder();


    System.out.println("\nremove():"+tree.remove(15));

    System.out.println("The tree is:  " + tree);
    System.out.println("Size:" + tree.size());
    System.out.println("In order traversal of keys");
    tree.root.inOrder();



  }
}
