/* 
CSE 17 
Charles Wallace 
cyw214 
Homework #5 DEADLINE: November 4, 2014 
Program: Recursive Sets
*/ 

/**This class represents a collection of unique elements. and stores elements in a set
on which the set operations union and intersect may be performed. The intersect and union operations are implemented
using recursion. The class implements the Cloneable interface. */
import java.util.ArrayList;

public class RecursiveSet implements Cloneable{

  /**  The elements of the set. Any kind of object can be stored.  there are no duplicates in this list. */
  private ArrayList<Object> members;
  
  /** The constructor. initializes the object. */
  public RecursiveSet()
  {
    members = new ArrayList<>();
  }
  
  /** Adds an object e to the set. If e is already in the set (as determined by its equals method), the operation is ignored. */
  public void add(Object e)
  {
      if(!hasElement(e))
        members.add(e);
   }
  
  /** Returns true if e is in the set, otherwise returns false. */  
  public boolean hasElement(Object e)
  {
      for(int i = 0; i < members.size(); i++)
        if(e.equals(members.get(i)))
          return true;
 
      return false;
  }
  
  /** Returns the element at index i in the set. */
  public Object get(int i)
  {
    return members.get(i);
  }
  
  /**  Returns the number of elements in the set.*/  
  public int size()
  {
    return members.size();
  }
  /** Returns a string of the form { e1, e2, ... , en} where each ei is the toString of one element of the set. */
  public String toString()
  {
    String list = members.toString();
    String listwithoutbrackets = "{" + list.substring(1,list.length()-1) + "}";
    return listwithoutbrackets;
  }
  
  /** Makes a copy of the set and returns it. catches the CloneNotSupportedException. */
  @SuppressWarnings("unchecked")
  public Object clone()
  {
     try{
      RecursiveSet setclone = (RecursiveSet)super.clone();
      setclone.members = (ArrayList<Object>)(members.clone());
        return setclone;
    }
    catch(CloneNotSupportedException ex){
      System.out.println("You Broke it");
      return ex.getMessage();
    }
  }
  /** Uses recursion to calculate the intersection of this set with set2. */
  public RecursiveSet intersect(RecursiveSet set2)
  {
    RecursiveSet Iset = new RecursiveSet();
    return intersect(set2,Iset,set2.size()-1);
  }
  
  /** Recursive helper function helps out the other union recursive function with tail recursion*/
  private RecursiveSet intersect(RecursiveSet set2, RecursiveSet Iset, int index)
  {
    if(this.hasElement(set2.get(index)))
      Iset.add(set2.get(index));
    if(index == 0)
      return Iset;
    return intersect(set2,Iset,index-1);
   }
  
  /** Uses recursion to calculate the union of this set with set2. */ 
  public RecursiveSet union(RecursiveSet set2)
  {
    RecursiveSet Uset = new RecursiveSet();
    Uset = (RecursiveSet)this.clone();
    return union(set2,Uset,set2.size()-1);
  }
  
  /** Recursive helper function helps out the other union recursive function with tail recursion*/
  private RecursiveSet union(RecursiveSet set2, RecursiveSet Uset, int index)
  { 
    if(!Uset.hasElement(set2.get(index)))
      Uset.add(set2.get(index));
    if(index == 0)
      return Uset;
    return union(set2,Uset,(index-1));
  }
    
  /** Returns true if o is equivalent to the current set.*/ 
  public boolean equals(Object o)
  {
    for(int i = 0; i < ((RecursiveSet)o).size(); i++)
      if(!this.hasElement(((RecursiveSet)o).get(i)))
           return false;
    for(int i = 0; i < this.size(); i++)
      if(!((RecursiveSet)o).hasElement(this.get(i)))
        return false;
    return true;
  }
  
  /** Tests All the Methods*/
  public static void main(String[] args)
  {
    RecursiveSet A = new RecursiveSet();
    A.add("a");
    A.add("b");
    A.add("c");
    System.out.println("A = " + A.toString());
    RecursiveSet B = new RecursiveSet();
    B.add("c");
    B.add("d");
    B.add("b");
    System.out.println("b is in A? " + A.hasElement("b"));
    System.out.println("d is in A? " + A.hasElement("d"));
    RecursiveSet C = A.intersect(B);
    System.out.println("C = A intersect B = " + C.toString());
    RecursiveSet D = B.union(A);
    System.out.println("D = B union A = " + D.toString());
    System.out.println("A = " + A.toString());
    System.out.println("B = " + B.toString());
    RecursiveSet E = new RecursiveSet();
    E.add("c");
    E.add("b");
    System.out.println("E = " + E.toString());
    System.out.println("E = C? " + E.equals(C));
    System.out.println("E = A? " + E.equals(A));
    System.out.println("D = A? " + D.equals(A));
    System.out.println("");
    RecursiveSet N1 = new RecursiveSet();
    N1.add(1);
    N1.add(3);
    N1.add(5);
    N1.add(7);
    System.out.println("N1 = " + N1.toString());
    RecursiveSet N2 = new RecursiveSet();
    N2.add(2);
    N2.add(4);
    N2.add(8);
    System.out.println("N2 = " + N2.toString());
    System.out.println("N1 intersect N2 = " + N1.intersect(N2));
    System.out.println("N1 union N2 = " + N1.union(N2));
    System.out.println("");
    RecursiveSet MA = new RecursiveSet();
    MA.add(A);
    MA.add(E);
    System.out.println("MA = " + MA.toString());
    RecursiveSet MB = new RecursiveSet();
    MB.add(B);
    MB.add(C);
    MB.add(D);
    System.out.println("MB = " + MB.toString());
    System.out.println("MA union MB = " + MA.union(MB)); 
    System.out.println("MA intersect MB = " + MA.intersect(MB));
    System.out.println("MB union MA = " + MB.union(MA)); 
  }
}