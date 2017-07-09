/* 
CSE 17 
Charles Wallace 
cyw214
Homework #4 DEADLINE: October 7, 2014 
Program: Media Library 
*/ 

/** Stores an array of dvds and mp3s beggining with an initial capacity of 10 and doubling each time the capacity is reached
  * contains methods to both add new dvds to the arrays and print them. 
  */
public class Library
{
  private DVD[] dvds;
  private MP3[] mp3s;
  
  private int sizedvds;
  private int sizemp3s;
  
  private int dvdcount = 0;
  private int mp3count = 0;
  
  public static final int DEFAULT_CAPACITY = 10;

/** initializes a library object with with two arrays for dvds and mp3s set at the default capacity*/
  Library()
  {
    dvds = new DVD[DEFAULT_CAPACITY];
    mp3s = new MP3[DEFAULT_CAPACITY];
  }
  
/**adds a dvd to the dvd array in the library object*/
  public void addDVD(DVD newDvd)
  { 
    ++dvdcount;
    if (sizedvds >= dvds.length) 
    {
      DVD[] temp = new DVD[dvds.length * 2];
      System.arraycopy(dvds, 0, temp, 0, dvds.length);
      dvds = temp;
    }
    
    dvds[sizedvds] = newDvd;
    sizedvds++;
  }
 
/**adds a mp3 to the mp3 array in the library object*/
  public void addMP3(MP3 newMp3)
  { 
    ++mp3count;
    if (sizemp3s >= mp3s.length) 
    {
      MP3[] temp = new MP3[mp3s.length * 2];
      System.arraycopy(mp3s, 0, temp, 0, mp3s.length);
      mp3s = temp;
    }
    
    mp3s[sizemp3s] = newMp3;
    sizemp3s++;
  }

/**prints list of dvds*/
  public void printDVDS()
  {
    DVD temp;
    String output1;
    for(int i=0; i<(dvdcount); i++)
    {
      temp = dvds[i];
      output1 = String.format("%4s%-5d%-20s%10s%-10.00f%9s%-6s%-13s%-7s%-9s%10s","Id: ",temp.getId(),temp.getTitle(),"Runtime: ",temp.getLength(),"Resolution: ",temp.getResolution(),"Ascpect Ratio: ",temp.getAspectRatio(), "Codec: ",temp.getVideoCodec());
      System.out.println(output1);
    }
  }

/**prints list of mp3s*/
  public void printMP3s()
  {
    String output1;
    String output2;
    MP3 temp; 
    for(int i=0; i<(mp3count); i++)
    {
      temp = mp3s[i];
      if (temp.getAdaptive())
      {  
        output1 = String.format("%4s%-5d%-20s%10s%-10.00f%9s%-6.00f%17s%17s%10s","Id: ",temp.getId(),temp.getTitle(),"Runtime: ",temp.getLength(),"Bitrate: ",temp.getBitrate(),"Adaptive", "Encoder: ",temp.getEncoder());
        System.out.println(output1);
      }
      else
      {  
        output2 = String.format("%4s%-5d%-20s%10s%-10.00f%9s%-6.00f%17s%17s%10s","Id: ",temp.getId(),temp.getTitle(),"Runtime: ",temp.getLength(),"Bitrate: ",temp.getBitrate(),"Not Adaptive", "Encoder: ",temp.getEncoder());
        System.out.println(output2);
      }
        
    }
  }
  
  /**tests the library, media, dvd and mp3 classes*/
  public static void main(String[] args)
  {
    DVD D1 = new DVD(1,"Patton", 172.0, "480i", "16:9","DivX");
    DVD D2 = new DVD(2,"Raging Bull", 129.0, "1080i", "16:9","DivX");
    DVD D3 = new DVD(3,"The God Father", 200.0, "720i", "16:9","Xvid");
    MP3 M1 = new MP3(1,"Atmosphere", 4.83, 192, false, "Fraunhofer");
    MP3 M2 = new MP3(2,"Space Oddity", 5.26, 240, true, "Blade Enc");
    MP3 M3 = new MP3(3,"Astral Weeks", 7.11, 384, false, "Lame");
    Library lib = new Library();
    
    lib.addDVD(D1);
    lib.addDVD(D2);
    lib.addDVD(D3);
    
    lib.addMP3(M1);
    lib.addMP3(M2);
    lib.addMP3(M3);
    
   
    System.out.println("DVDs----------------------------------------------------------------------------------------------------------------");
    lib.printDVDS();
    
    System.out.println("MP3s----------------------------------------------------------------------------------------------------------------");
    lib.printMP3s();
    
  }
  
}