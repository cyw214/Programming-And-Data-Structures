/* 
CSE 17 
Charles Wallace 
cyw 214
Program #4 DEADLINE: November 13, 2014 
Program: T9 Text Messaging
*/ 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/** This is the main class of the application. */
public class TextDecoder{
  
  /** The entry point to the application. Loads a FreqDictionary from 
  the file wordFreq.txt. prompts the user to enter a line of numeric key presses, with each 
  “word” separated by spaces. It then translates these numbers into a 
  text message where each word is predicted to be the most frequent 
  word that matches the key sequence */
  public static void main(String[] args) throws FileNotFoundException
  {
    File newfile = new File("wordFreq.txt");
    FreqDictionary dic = new FreqDictionary();
    dic.loadFromTextFile(newfile);
   
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a sequence of key presses (separate words by spaces): ");
    String s = scan.nextLine();
    
    char space = ' ';
    ArrayList<String> stringlist = new ArrayList<String>();
    int placeholder = 0;
    for(int i = 0; i < s.length(); i++)
    {
      if((s.charAt(i) == space))
      {
        stringlist.add(s.substring(placeholder,i)); 
        placeholder = i+1;
      }
      if((i == (s.length() - 1)) && (s.charAt(i) != space))
      {
        stringlist.add(s.substring(placeholder,i+1));
      }
    }
    
   System.out.println("Your Text Message is: ");
   for(int i = 0; i < stringlist.size(); i++)
   {
     if(stringlist.get(i) != null)
     System.out.print(dic.decodeWord(stringlist.get(i)) + " ");
     
   }
   System.out.println("");
     
  }
}