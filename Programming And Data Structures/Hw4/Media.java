/* 
CSE 17 
Charles Wallace 
cyw214
Homework #4 DEADLINE: October 7, 2014 
Program: Media Library 
*/ 

/** Media is a class that represents general attributes of most digital media through three data fields*/
public class Media
{
  private int id;
  private String title;
  private double length;

/**Media constructor initializes the data fields in media subclasses*/
  Media(int id, String title, double length)
  {
    this.id = id;
    this.title = title;
    this.length = length;
  }

/**Returns the value of the ID instance variable*/
  public int getId()
  {
    return id;
  }

/**Returns the value of the title instance variable*/  
  public String getTitle()
  {
    return title;
  }

/**Returns the value of the length instance variable*/
  public double getLength()
  {
    return length;
  }
}