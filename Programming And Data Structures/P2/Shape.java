/* 
CSE 17 
Charles Wallace 
cyw214  
Program #2 DEADLINE: October 16, 2014 
Program: Ascii Draw
*/ 

/** This is the class of all of the objects that can be drawn to the 
display. */
public class Shape
{
  protected String id;
  protected Coordinate location;
  
  /** constructor initializes a shape object and its data fields id and location*/
  public Shape(String id, Coordinate location)
  {
    this.id = id;
    this.location = location;
  }
  
  /** Draws a question mark at location on the grid of dis*/
  public void draw(AsciiDisplay dis)
  {
    dis.putCharAt(location.getX(),location.getY(),'?');
  }
  
  /** Change’s the object’s location to newLoc.*/
  public void move(Coordinate newLoc)
  {
    location = newLoc;
  }
  
  /** Returns true if the actual parameter is a Shape with the same id. 
  Overrides Object’s equals() method. */
  public boolean equals(Object obj)
  {
    if(obj instanceof Shape)
    {
      return id.equals(((Shape)obj).id);
    }
    return false;
  }
}