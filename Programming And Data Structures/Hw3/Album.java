/* 
CSE 17 
Charles Wallace 
cyw214  
Homework #3 DEADLINE: September 24, 2014 
Program: Album Rankings 
*/ 


/** Album is a class that represents an album with a title artst year and rank*/
public class Album
{
  
  private String title;
  private String artist;
  private int year;
  private int rank;
  
  /** Creates a Album constructor passing two strings consistting of an artist and a title
    * along with two integers representing a year and a ranking to initialize the corresponding
    * datafields within the object.
    */
  Album(String title, String artist, int year, int rank)
  {
    this.title = title;
    this.artist = artist;
    this.year = year;
    this.rank = rank;
  }
  
   /** Creates a Album constructor passing two strings consistting of an artist and a title
   * along with one integers representing a year to initialize the corresponding
   * datafields within the object. automatically initializes rank to -1 to represent an unranked album
   */
  Album(String title, String artist, int year)
  {
    this.title = title;
    this.artist = artist;
    this.year = year;
    this.rank = -1;
   }
  
  /** returns the title of the album
  */
  public String getTitle()
  {
    return title;
  }
  /** returns the artist that composed the album
  */
  public String getArtist()
  {
    return artist;
  }
  /** returns the year that the album was recorded
  */
  public int getYear()
  {
    return year;
  }
  /** returns the Rank of the album
  */
  public int getRank()
  {
    return rank;
  }
  
  /**Sets the rank of the album
   */
  public void setRank(int rank)
  {
    this.rank = rank;
  } 
}

