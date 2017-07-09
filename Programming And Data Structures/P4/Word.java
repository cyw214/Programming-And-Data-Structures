/* 
CSE 17 
Charles Wallace 
cyw 214
Program #4 DEADLINE: November 13, 2014 
Program: T9 Text Messaging
*/ 

/** A simple class representing an entry in our word dictionary. 
Implements the Comparable<Word> interface.  */
public class Word implements Comparable<Word>{

  private String word;
  private int freq;
  
  /** The constructor. Sets word and freq*/
  public Word(String word, int freq)
  {
    this.word = word;
    this.freq = freq;
  }
  /** Returns the word*/
  public String getWord()
  {
    return word;
  }
  /** Returns the Frequency*/
  public int getFreq()
  {
    return freq;
  }
  /** Returns the sequence of numbers that would be used to enter the 
  word as a text message in T9*/
  public String getKeySequence()
  {
    String keysequence = "";
    for(int i = 0; i<word.length();i++)
    {
      keysequence = keysequence + encode(word.charAt(i));
    }
    return keysequence;
  }
  /** Returns a string of the form : word(code= keySeqm freq= freq)) Where word and freq are the fiedls of the word and the k
  key sequence corresponds to the sequence of the word*/
  public String toString()
  {
    return word + "(" + "code = " + getKeySequence() + ", " + "freq = " + getFreq() + ")";
  }
  /** Implements the standard semantics of compareTo. The current 
  word is less than w if its key sequence comes before w or if they 
  have the same key sequence and its frequency is higher than w’s. 
  The word is greater than w if its key sequence comes after w or if 
  they have the same key sequence and its frequency is less than 
  w’s. Otherwise, the two words are equal.*/
  public int compareTo(Word w)
  {
    if(((this.getKeySequence()).compareTo(w.getKeySequence()) >= 1) || (((this.getKeySequence()).equals(w.getKeySequence()))&&(this.getFreq() < w.getFreq())))
      return 1;
    else if (((this.getKeySequence()).compareTo(w.getKeySequence()) <= -1) || (((this.getKeySequence()).equals(w.getKeySequence()))&&(this.getFreq() > w.getFreq())))
      return -1; 
    else 
      return 0;
  }
  /** Given a character c, returns the character for the corresponding 
  numeric key press. For example, if c=’A’ or c=’B’ or c=’C’ then 
  returns the character ‘2’. */
  public char encode(char c)
  {
    char newc = Character.toLowerCase(c);
    if((newc == 'a')||(newc == 'b')||(newc == 'c'))
      return '2'; 
    else if((newc == 'd')||(c == 'e')||(c == 'f'))
      return '3'; 
    else if((newc == 'g')||(newc == 'h')||(newc == 'i'))
      return '4';   
    else if((newc == 'j')||(newc == 'k')||(newc == 'l'))
      return '5'; 
    else if((newc == 'm')||(newc == 'n')||(newc == 'o'))
      return '6'; 
    else if((newc == 'p')||(newc == 'q')||(newc == 'r')||(newc == 's'))
      return '7'; 
    else if((newc == 't')||(newc == 'u')||(newc == 'v'))
      return '8'; 
    else if((newc == 'w')||(newc == 'x')||(newc == 'y')||(newc == 'z'))
      return '9'; 
    else
      return ' ';
  }
}