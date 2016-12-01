/* HashTableChained.java */

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/
import java.util.*;
public class HashTableChained implements Dictionary {
  public int hashSize;
  protected SList[] hashList;
  protected int entryNumber=0;
  public int collision=0;




  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public HashTableChained(int sizeEstimate) {
    LOOP:
    for(int i=sizeEstimate;;i++){
      for(int j=2;j<Math.sqrt(i);j++){
        if(i%j==0)
          continue;
      }
      hashSize=i;
      break;
    }
    // Your solution here.
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    hashSize=101;
    arrayInit();
  }

  protected void arrayInit(){
    hashList=new SList[hashSize];
    for(int i=0;i<hashSize;i++)
      hashList[i]=new SList();
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    return Math.abs(code%hashSize);
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    return entryNumber;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    return entryNumber==0;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    Entry item=new Entry();
    item.key=key;
    item.value=value;
    SList hashNode=hashList[compFunction(key.hashCode())];
    if(!hashNode.isEmpty())
      collision++;
    hashNode.insertFront(item);
    entryNumber++;
    return item;
    }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    SList hashNode=hashList[compFunction(key.hashCode())];
    SListNode currentNode=hashNode.front();

     try{
      while(currentNode.isValidNode()){
      if(currentNode.item() instanceof Entry && ((Entry)currentNode.item()).key().equals(key)){
        return ((Entry)currentNode.item());
       }
       else{
        currentNode=currentNode.next;
       }
     }
     }catch(NullPointerException e){
      System.out.println("Not Found");
     }
     
    return null;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    SList hashNode=hashList[compFunction(key.hashCode())];
    SListNode currentNode=hashNode.front();
    try{
      while(currentNode.isValidNode()){
        if(currentNode.item() instanceof Entry && ((Entry)currentNode.item()).key().equals(key)){
          Entry entry=(Entry)currentNode.item();
          hashNode.remove(currentNode);
          entryNumber--;
          return entry;
        }
        else{
          currentNode=currentNode.next;
        }
      }
    }catch(NullPointerException e){
      System.out.println("Not Found");
    }
    return null;
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
  }
  public String toString(){
    String hashString="";
    for(int i=0;i<hashSize;i++){
      if(!hashList[i].isEmpty()){
        hashString+=i+":"+hashList[i]+" size:"+hashList[i].size+"\n";
        
      }
    }
    return hashString;
  }

  public static void main(String[] args) {
    HashTableChained hash=new HashTableChained();
    Random rand=new Random();
    for(int i=20;i>0;i--){
      int number=Math.abs(rand.nextInt(10));
      //System.out.println(number);
      hash.insert(number,i);
    }

    System.out.println(hash);
    System.out.println(hash.collision);
    System.out.println(hash.find(1));
    
    System.out.println(hash.remove(1));
    System.out.println(hash);
    System.out.println(hash.remove(1));
    System.out.println(hash);
  }


}
