/* 
CSE 17 
Charles Wallace 
cyw 214
Program #4 DEADLINE: November 13, 2014 
Program: T9 Text Messaging
*/ 

import java.util.ArrayList;

/** This class is used to sort an ArrayList using Selection Sort.*/
public class SelectionSort<E>{
  /** This is a generic method that sorts list using the Selection Sort 
  algorithm.*/
  public static <E extends Comparable<E>> void sort(ArrayList<E> list)
  {
    int min;
    for(int i = 0; i < list.size(); i++)
    {
     min = i;
     for(int j = i+1; j < list.size(); j++)
     {
       if((list.get(j)).compareTo(list.get(min))<0)
         min = j;
     }
     E temp = list.get(i);
     list.set(i, list.get(min));
     list.set(min,temp);
    }
  }
}