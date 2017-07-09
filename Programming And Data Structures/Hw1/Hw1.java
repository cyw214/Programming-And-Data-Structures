/*
CSE 17 
Charles Wallace 
cyw214 
Homework #1 DEADLINE: August 28, 2014 
Program: My Autobiography 
*/

package hw1;

public class Hw1 
{
  public static void main(String[] args) 
  {
    // Array of strings containing autobigraphical information
      String[] bio = 
    {"My name is Charles Wallace", 
         "I am a transfer student entering lehigh as a Computer Science For Engineering major with the "
              + "intention of minoring in Electrical Engineering",
         "I am origionally from North Carolina and have lived in the lehigh valley for close to 3 years."
    };
     
    int i=3;
    
    //loop to print strings from array containing autobiographical information
    for(i=0; i<3 ; ++i)
    {
      System.out.println(bio[i]);
    }
   }
 }
