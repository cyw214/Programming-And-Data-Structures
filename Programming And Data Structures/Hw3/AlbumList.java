/* 
CSE 17 
Charles Wallace 
cyw214  
Homework #3 DEADLINE: September 24, 2014 
Program: Album Rankings 
*/ 
import java.io.File;
import java.util.Scanner;

/** Album list is a class that represents a collection of albums*/
public class AlbumList
{
  public static final int MAX_ALBUMS = 50;
  private int numAlbums;
  private Album[] albums;
  
  /** the empty parameter AlbumList constructor instantiates an object containing a list of Albums set to the value of max albums
    * it initializes the value of num albums to zero
    */
  AlbumList()
  {
   albums = new Album[MAX_ALBUMS];
   numAlbums = 0;
  }
  
   /** The AlbumList constructor with the integer capacity parameter instantiates an object containing a list of Albums set to the value of
    * the capacity parameter.
    */
  AlbumList(int capacity)
  {
    albums = new Album[capacity];
    numAlbums = 0;
  }
  
  
   /** The readAlbumsFromFile method takes in a text file containing album information and reads the data into
     * an albums array contained within an object.  It also increments the numAlbum counter.
    */
  public void readAlbumsFromFile(java.io.File inFile) throws Exception
  {
   
    int[] countarray = new int[albums.length];
    String[] artistarray = new String[albums.length];
    Album tempalbum2;
    
    Scanner input = new Scanner(inFile);

    input.useDelimiter("\\t|[\\n\\r\\f]+");
    
    while(input.hasNext())
    {

     int arank = input.nextInt();
     String aartist = input.next();
     String atitle = input.next();
     int ayear = input.nextInt();
     
     Album tempalbum = new Album(atitle, aartist, ayear, arank);
     albums[numAlbums] = tempalbum;
     numAlbums = numAlbums + 1;
    } 
    
  }
   /** The printAlbums method prints data from the albums array 
    */
  public void printAlbums()
  { 
    Album tempalbum;
    
    String output1 = String.format("%4s%-30s%-20s%4s","Rank"," Title"," Artist"," Year");
    System.out.println(output1);
    
    String output2 = String.format("%4s%-30s%-20s%4s","----"," ----------------------------"," ------------------"," ----");
    System.out.println(output2);
    
    for(int i = 0; i < numAlbums; ++i)
    {
      tempalbum = albums[i];
      String output3 = String.format("%4d%s%-30s%-20s%4d",tempalbum.getRank()," ",tempalbum.getTitle(),tempalbum.getArtist(),tempalbum.getYear());
      System.out.println(output3);
    }
  }
  
  /** TheprintArtistAlbumCount method counts the number of times an artist appears in a list, matches the the count to each artist
    * and prints a list of artists with the corresponding count in two columns.
  */
  public void printArtistAlbumCount()
  {
    String[] artistarray = new String[numAlbums];
    int[] albumcount = new int[numAlbums];
    
    //create array of lartists from albums array. 
    Album tempalbum;
    for(int i=0; i < numAlbums; i++)
    {
      tempalbum = albums[i];
      artistarray[i] = tempalbum.getArtist();
    }
    

    //counts the number of times each artist appears in the list    
    for(int j=0; j < numAlbums ; j++)
    {
      int count = 0;
      tempalbum = albums[j];
      String s1 = tempalbum.getArtist();
      Album tempalbum2;
      
      for(int k = 0; k < numAlbums; k++)
      { 
        tempalbum2 = albums[k];
        String s2 = tempalbum2.getArtist();
        if(s1.equals(s2))
        {
          count = count + 1;
        }
        
      }
      albumcount[j] = count;
     }
 
    //replaces any repeated artists with a string consisting of an empty space
    for(int m=0; m < numAlbums; m++)
    { 
      String s1 = artistarray[m];
      
      for(int n=0; n< numAlbums; n++)
      { 
        String s2 = artistarray[n];
        if(s1.equals(s2)&&(albumcount[n]!=1))
        {
           artistarray[m] = artistarray[n];
           artistarray[n] = " ";
        }
      }
    }
    
    //counts artists repeated in list by incrementing each time a space is encountered through a loop
    int duplicates = 0;
    for(int l = 0; l < numAlbums; l++)
    {
     String s1 = artistarray[l];
     if(s1.equals(" "))
     {
       duplicates= duplicates + 1;
     }
    }
    
    //removes spaced items in the artist array and shifts unrepeated artists to the bottom of the list while mainting consistency with album count array
    //repeats one artist at the begging of the list a number of times equal to the number of spaces inserted. 
    for(int p = 0; p < numAlbums; p++)
    {
      String s1 = artistarray[p];
      
      if(s1.equals(" ")&&(albumcount[p]!=1))
      { 
        
        for(int q = p; q > 0; q--)
        {
          artistarray[q] = artistarray[q-1];
          albumcount[q] = albumcount[q-1];
        }
      }
    }
    
    //removes repeated artists by loading unrepeated artist into another array
    String[] artistarray2 = new String[numAlbums - duplicates];
    int[] albumcount2 = new int[numAlbums - duplicates];
    int index = 0;
    
    for(int r = (duplicates); r < (numAlbums); r ++)
    { 
      artistarray2[index] = artistarray[r];
       albumcount2[index] = albumcount[r];
       index = index + 1;
     }
    
    
    //Prints list of artists with corresponding count
    System.out.println("\n");
    System.out.println("Artist Summary");
    String output1 = String.format("%-20s%5s","Artist","Count");
    System.out.println(output1);
    String output2 = String.format("%-20s%5s","------------------- ","-----");
    System.out.println(output2);
    
    for(int t=0; t < albumcount2.length; t++)
    {
    String output3 = String.format("%-20s%-5d",artistarray2[t],albumcount2[t]);
    System.out.println(output3);
    }
  }
  
  /** checks if there is a command-line argument and exits with a
    * error message if not. When given an argument, it reads a set of albums from the file
    * declared as an argument, prints the list of albums from the file, and prints
    * the number of albums in the list by each artist.
   */
  public static void main(String[] args) throws Exception{

      AlbumList albl = new AlbumList();
      File newfile = new File(args[0]);
      albl.readAlbumsFromFile(newfile);
      albl.printAlbums();
      albl.printArtistAlbumCount();
  }
}