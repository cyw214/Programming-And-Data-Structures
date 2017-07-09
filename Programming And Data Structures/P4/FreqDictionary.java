/* 
CSE 17 
Charles Wallace 
cyw 214
Program #4 DEADLINE: November 13, 2014 
Program: T9 Text Messaging
*/ 

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/** A dictionary of words and their frequencies. The dictionary is 
organized to support efficient translation of key sequences to 
words. */
public class FreqDictionary{
  /** A constant for the length of the longest word that will appear in 
  the dictionary.*/
  public static final int MAX_LENGTH = 10;
  /** An array of lists of words. */
  private ArrayList<Word>[] wordLists;
  /** The constructor. initializes the ArrayLists in wordLists.*/
  @SuppressWarnings("unchecked")
  public FreqDictionary()
  {
    wordLists =  (ArrayList<Word>[]) new ArrayList[MAX_LENGTH];
  }
  /** Reads from a text file formatted as described above and adds the 
  words into the appropriate element of wordLists depending on 
  lengths. Any words that are too long are skipped. After all lists 
  are created, uses selection sort to sort them first by their key press 
  sequence (ascending) and then by descending frequency. It should 
  throw the FileNotFoundException if unable to open the file.  */
  public void loadFromTextFile(File freqFile) throws FileNotFoundException
  {
    Scanner newfile  = new Scanner(freqFile);
    String word;
    int frequency;
    
    for(int i = 0; i < MAX_LENGTH; i++)
      wordLists[i] = new ArrayList<Word>();
    
   while(newfile.hasNext())
   { 
      newfile.nextInt();
      word = newfile.next();
      newfile.next();
      frequency = newfile.nextInt();
      newfile.nextLine();
      
      if(word.length() <= 10)
        (wordLists[word.length()-1]).add(new Word(word, frequency)); 
    }
   
   SelectionSort sel = new SelectionSort();
   for(int i = 0; i < MAX_LENGTH; i++)
   { 
    sel.sort(wordLists[i]);
   }
  }
  /** For the given sequence of presses keySeq, returns up to k Words that best match the sequence, in order of descending frequency. 
  uses a binary search to locate a corresponding word in the appropriate element of wordLists. It 
  locates the most frequent words with that sequence, and then find the next k-1 most frequent words. The 
  length of the returned array should be the same as the number of matching elements, which may be less than k*/
  public Word[] getTopKWords(String keSeq, int k)
  {
    ArrayList<Word> topwords = new ArrayList<Word>(); 
    
   if((keSeq.length() > 0 && (keSeq.length() <= 10  ))){
    int mid = 0;
    int low = 0;
    int high = (wordLists[keSeq.length()-1]).size()-1;
  
    while((high >= low) && (mid >= 0))
    { 
      mid = (low + high)/2;     
      if(keSeq.compareTo(((wordLists[keSeq.length()-1]).get(mid)).getKeySequence()) < 0)
      {
        high = mid-1;
      }
      else if(keSeq.compareTo(((wordLists[keSeq.length()-1]).get(mid)).getKeySequence()) == 0)
      { 
        topwords.add((wordLists[keSeq.length()-1]).get(mid));
        int upperdex = mid + 1;
        int lowerdex = mid - 1;
        
        
        //searches for equal keysequences above the mid
        if(mid >1 && mid != high){
          while((((wordLists[keSeq.length()-1]).get(mid)).getKeySequence()).equals(((wordLists[keSeq.length()-1]).get(upperdex)).getKeySequence()))
          { 
            topwords.add((wordLists[keSeq.length()-1]).get(upperdex));
            upperdex = upperdex + 1;
          }
        }
        //serches for equal keysequences below the mid
        if(mid >1){
          while((((wordLists[keSeq.length()-1]).get(mid)).getKeySequence()).equals(((wordLists[keSeq.length()-1]).get(lowerdex)).getKeySequence()))
          { 
            topwords.add((wordLists[keSeq.length()-1]).get(lowerdex));
            lowerdex = lowerdex - 1;
          }
        }
        SelectionSort sel = new SelectionSort();
        sel.sort(topwords);
        
        Word[] toparray = new Word[topwords.size()];
        topwords.toArray(toparray);
        
        if(toparray.length <= k)
          return toparray;
        else if(toparray.length > k)
        {
          Word[] karray = new Word[k];
          for(int i = 0; i < k; i++)
          {
            karray[i] = toparray[i];
          }
          return karray;
        }
       }
      else 
      {
        low = mid + 1;
      }
    }
   }
     Word[] empty = new Word[k];
     return null;
  }
  /** Returns the most frequent word that matches the presses keySeq. */
  public String decodeWord(String keySeq)
  {
    Word[] decode = this.getTopKWords(keySeq,1);
    if(decode == null)
    {
      String returnstring = "";
      for(int i = 0; i < keySeq.length(); i++)
      {
        returnstring = returnstring + "?";
      }
      return returnstring;
    }
    else
    {
      String decoded = (decode[0]).getWord();
      return decoded;
    }
  }
 }