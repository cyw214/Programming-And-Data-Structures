/* 
CSE 17 
Charles Wallace 
cyw214  
Homework #6 DEADLINE: November 20, 2014 
Program: Quick sort comparison
*/ 

import java.lang.Math;
import java.lang.Integer;
import java.util.Random;

/** The generic QuickSort class extends comparable to create a quick sort method with partition and recurseive helper along with a method to 
  * generate random numbers in an array*/
public class GenericQuickSort<E extends Comparable<E>>{

  /**A generic implementation of quick sort. If smartPivot is false, then the pivot is always 
  the first element in the list. Otherwise, the algorithm chooses the pivot to be the 
  median value among the first, middle, and last elements of the list.*/
  public static <E extends Comparable<E>> void quickSort(E[] list, boolean smartPivot)
  {
    quickSort(list, 0, list.length - 1, smartPivot);
  }
  
  /** The recursive helper method for quick sort.*/
  private static <E extends Comparable<E>> void quickSort(E[] list, int first, int last, boolean smartPivot)
  {

      // determine whether or not center value or last value might be used over first value
      if (last > first) {
  
        int pivotIndex = partition(list, first, last, smartPivot);
        quickSort(list, first, pivotIndex - 1, smartPivot);            // sort the lower partition
        quickSort(list, pivotIndex + 1, last, smartPivot);             // sort the upper partition
    }
  }

  /** Choose a pivot and partition the list into two sets: the elements less than the pivot and the 
  elements greater than the pivot. Place the pivot between these two sets and return its 
  index. If smartPivot is false, then the pivot is always the first element in the list. 
  Otherwise, the algorithm chooses the pivot to be the median value among the first, 
  middle, and last elements of the list. */
  private static <E extends Comparable<E>> int partition(E[] list, int first, int last, boolean smartPivot)
  { 
    int low = first + 1;
    int center =((first+last)/2);
    int high = last;
    
    E pivot = null;
    int piv = 0;
    
    if (smartPivot == true)
      {
        piv = 0;
        if(((list[first].compareTo(list[center]) <= 0) && (list[first].compareTo(list[last]) >= 0)) || ((list[center].compareTo(list[first]) >= 0) && (list[first].compareTo(list[last]) <= 0)))
        {
          pivot = list[first];
          piv  = first;
        }
        else if((list[center].compareTo(list[last]) <= 0) && (list[center].compareTo(list[first]) >= 0 ) || (list[center].compareTo(list[last]) >= 0) && (list[center].compareTo(list[first]) <= 0))
        {
          pivot = list[center];
          piv = center;
        }
        else
        {
          pivot = list[last];
          piv = last;
        }
    
      E temp  = list[piv];
      list[piv] = list[first];
      list[first] = temp;
    }
    else if(smartPivot == false)
    {
      pivot = list[first]; 
    }

    while (high > low) {
      // look for the leftmost element > pivot
      while (low <= high && (pivot.compareTo(list[low]) >= 0))
        low++;
      // look for the rightmost element <= pivot
      while (low <= high && (pivot.compareTo(list[high]) < 0))
        high--;
      
      // if we found a pair of out-of-place elements, swap them
      if (high > low) {
        E temp2 = list[high];
        list[high] = list[low];
        list[low] = temp2;
      }
    }
    
    // find where pivot needs to be placed (move high down until it is < pivot)
    while (high > first && ((list[high].compareTo(pivot) >= 0)))
      high--;
    
    // swap pivot with list[high]
    if (pivot.compareTo(list[high]) > 0) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else                  // this case is needed if the low partition is empty
      return first;
  }
   
  
  /**Returns an array containing size random integers between 0 and 999,999 inclusive.*/  
  public Integer[] makeRandomIntList(int size)
  {
        Integer[] intarray = new Integer[size];
        Random randint = new Random();
        int item = 0;
        long startTime = System.currentTimeMillis(); 
        for(int i=0;i<size;i++){
            item = randint.nextInt(1000000); 
            intarray[i] = item;
         }
        return intarray;

  }
  
  public static void main(String[] args)
  {
    GenericQuickSort<Integer> sortable = new <Integer>GenericQuickSort();

    long startTime;
    long endTime;
    long[] executionTimeD = new long[5];
    long[] executionTimeS = new long[5];
    
    // List of 100,000 integers
    Integer[] newlist1 = sortable.makeRandomIntList(100000);
    Integer[] listcopy1 = new Integer[newlist1.length];
    System.arraycopy(newlist1,0,listcopy1,0, newlist1.length);
    
    // List of 250,000 integers
    Integer[] newlist2 = sortable.makeRandomIntList(250000);
    Integer[] listcopy2 = new Integer[newlist2.length];
    System.arraycopy(newlist2,0,listcopy2,0, newlist2.length);
    
    // List of 500,000 integers
    Integer[] newlist3 = sortable.makeRandomIntList(500000);
    Integer[] listcopy3 = new Integer[newlist3.length];
    System.arraycopy(newlist3,0,listcopy3,0, newlist3.length);
    
    // List of 750,000 integers
    Integer[] newlist4 = sortable.makeRandomIntList(750000);
    Integer[] listcopy4 = new Integer[newlist4.length];
    System.arraycopy(newlist4,0,listcopy4,0, newlist4.length);
    
    // List of 1,000,000 integers
    Integer[] newlist5 = sortable.makeRandomIntList(1000000);
    Integer[] listcopy5 = new Integer[newlist5.length];
    System.arraycopy(newlist5,0,listcopy5,0, newlist5.length);
    
    //Sort test comparison for 100,000 elements
    startTime = System.currentTimeMillis(); 
    sortable.quickSort(newlist1,true);
    endTime = System.currentTimeMillis();
    executionTimeS[0] = endTime - startTime;
    
    startTime = System.currentTimeMillis(); 
    sortable.quickSort(listcopy1,false);
    endTime = System.currentTimeMillis();
    executionTimeD[0] = endTime - startTime;
    
    //Sort test comparison for 250,000 elements
    startTime = System.currentTimeMillis(); 
    sortable.quickSort(newlist2,true);
    endTime = System.currentTimeMillis();
    executionTimeS[1] = endTime - startTime;
    
    startTime = System.currentTimeMillis(); 
    sortable.quickSort(listcopy2,false);
    endTime = System.currentTimeMillis();
    executionTimeD[1] = endTime - startTime;
    
    //Sort test comparison for 500,000 elements
    startTime = System.currentTimeMillis(); 
    sortable.quickSort(newlist3,true);
    endTime = System.currentTimeMillis();
    executionTimeS[2] = endTime - startTime;
    
    startTime = System.currentTimeMillis(); 
    sortable.quickSort(listcopy3,false);
    endTime = System.currentTimeMillis();
    executionTimeD[2] = endTime - startTime;
    
    //Sort test comparison for 750,000 elements
    startTime = System.currentTimeMillis(); 
    sortable.quickSort(newlist4,true);
    endTime = System.currentTimeMillis();
    executionTimeS[3] = endTime - startTime;
    
    startTime = System.currentTimeMillis(); 
    sortable.quickSort(listcopy4,false);
    endTime = System.currentTimeMillis();
    executionTimeD[3] = endTime - startTime;
    
    //Sort test comparison for 1,000,000 elements
    startTime = System.currentTimeMillis(); 
    sortable.quickSort(newlist5,true);
    endTime = System.currentTimeMillis();
    executionTimeS[4] = endTime - startTime;
    
    startTime = System.currentTimeMillis(); 
    sortable.quickSort(listcopy5,false);
    endTime = System.currentTimeMillis();
    executionTimeD[4] = endTime - startTime;
    
    
    
    System.out.println("Comparing sorts on lists of integers: ");
    System.out.println("Size     " + "Quick Sort (default)"+"     Quick Sort (smart pivot)");
    System.out.println("100000   " + executionTimeD[0] + "                       " + executionTimeS[0]);
    System.out.println("250000   " + executionTimeD[1] + "                       " + executionTimeS[1]);
    System.out.println("500000   " + executionTimeD[2] + "                      " + executionTimeS[2]);
    System.out.println("750000   " + executionTimeD[3] + "                      " + executionTimeS[3]);
    System.out.println("1000000  " + executionTimeD[4] + "                      " + executionTimeS[4]);
    
  }

}