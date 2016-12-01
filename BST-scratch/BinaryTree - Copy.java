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

  public Entry insert(Object key, Object value) {
    System.out.println("Inserting:"+key);
    Entry entry=new Entry(key,value);

    if(root==null){
      BinaryTreeNode node=new BinaryTreeNode(entry,null,null,null);
      root=node;
      size++;
      return entry;
    }

    BinaryTreeNode temp=root;
    Comparable comparableKey=(Comparable)key;
    while(temp!=null){
      if(comparableKey.compareTo(temp.entry.key)<=0 && temp.leftChild!=null)
        temp=temp.leftChild;
      else if(comparableKey.compareTo(temp.entry.key)>=0 && temp.rightChild!=null)
        temp=temp.rightChild;
      else
        break;
    }


    if(comparableKey.compareTo(temp.entry.key)<=0){
      BinaryTreeNode node=new BinaryTreeNode(entry,temp,null,null);
      temp.leftChild=node;
      size++;
      return entry;
    }

    else if(comparableKey.compareTo(temp.entry.key)>=0){
      BinaryTreeNode node=new BinaryTreeNode(entry,temp,null,null);
      temp.rightChild=node;
      size++;
      return entry;
    }
    return entry;

  }

  public Entry find(Object key) {
    Comparable comparableKey=(Comparable)key;
    BinaryTreeNode temp=root;

    while(temp!=null){
     if(comparableKey.compareTo(temp.entry.key)==0)
      return temp.entry;
    else if(comparableKey.compareTo(temp.entry.key)<0)
      temp=temp.leftChild;
    else if(comparableKey.compareTo(temp.entry.key)>0)
      temp=temp.rightChild;
  }
  return null;
}


public Entry remove(Object key) {
  Comparable comparableKey=(Comparable)key;
  BinaryTreeNode node=root;
  Entry entry=null;
  boolean left=false,right=false;
  while(true){
    //if not found then node will be equal to null
    if(node==null){
      return entry;
    }
    if(comparableKey.compareTo(node.entry.key)==0){
      entry=node.entry;
      break;
    }
    else if(comparableKey.compareTo(node.entry.key)<0){
      node=node.leftChild;
      left=true;
      right=false;
    }
    else if(comparableKey.compareTo(node.entry.key)>0){
      node=node.rightChild;
      left=false;
      right=true;
    }
  }

    //deleting node with no child
  if(node.leftChild==null && node.rightChild==null){
    if(left==true){
      node.parent.leftChild=null;
      node.entry=null;
      size--;
      return entry;
    }
    else if(right==true){
      node.parent.rightChild=null;
      node.entry=null;
      size--;
      return entry;
    }
  }

  //deleting node with one child
  if(node.leftChild==null && node.rightChild!=null){
    if(left==true){
      node.parent.leftChild=node.rightChild;
      size--;
      return entry;
    }
    else if(right==true){
      node.parent.rightChild=node.rightChild;
      size--;
      return entry;
    }
  }

  if(node.leftChild!=null && node.rightChild==null){
    if(left==true){
      node.parent.leftChild=node.leftChild;
      size--;
      return entry;
    }
    else if(right==true){
      node.parent.rightChild=node.leftChild;
      size--;
      return entry;
    }
  }
  //deleting node with 2 children
  if(node.leftChild!=null && node.rightChild!=null){
    //find the which is largest in its right subtree
    BinaryTreeNode temp=node.rightChild;
    while(temp.leftChild!=null){
      temp=temp.leftChild;
    }
    //temp is the largest key in right subtree
    if(left==true){

    }else if(right==true){

    }
  }

  return entry;
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

public static void main(String[] args) {
  BinaryTree tree = new BinaryTree();

  tree.insert(new Integer(18), "");
  tree.insert(new Integer(12), "");
  tree.insert(new Integer(25), "");
  tree.insert(new Integer(4), "");
  tree.insert(new Integer(15), "");
  tree.insert(new Integer(13), "");
  //tree.insert(new Integer(3), "K");
  
    //tree.insert(new Integer(1), "L");
  System.out.println("The tree is:  " + tree);
  System.out.println("In order traversal of keys");
  tree.root.inOrder();
  System.out.println("Size:" + tree.size());
  System.out.println("find():"+tree.find(9));
  System.out.println("first():"+tree.first());
  System.out.println("last():"+tree.last());
  System.out.println("remove():"+tree.remove(25));
  System.out.println("In order traversal of keys");
  tree.root.inOrder();
  System.out.println("Size:" + tree.size());
  }


}
