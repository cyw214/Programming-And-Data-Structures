/* 
CSE 17 
Charles Wallace 
cyw214  
Program #2 DEADLINE: October 16, 2014 
Program: Ascii Draw
*/ 

/** The Coordinate Class represents a (x,y) coordinate on the display */
public class Coordinate
{
  private int x;
  private int y;
  
  /** Constructor. Initializes the coordinate object and its data fields x and y. */
  public Coordinate(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  
  /** The getX method returns the value of x*/
  public int getX()
  {
    return x;
  }
  
  /** The getY method returns the value of y*/
  public int getY()
  {
    return y;
  }
}