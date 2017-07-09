/* 
CSE 17 
Charles Wallace 
cyw214  
Program #2 DEADLINE: October 16, 2014 
Program: Ascii Draw
*/ 

/**  the Point class is a subclass of Shape. it represents a single point with a location and id*/
public class Point extends Shape
{
  /** point constructor initializes the data fields id and loc inheritied from shape.*/
  public Point(String id, Coordinate loc)
  {
    super(id,loc);
  }
  
  /** the draw() method draws a ‘*’ at location on the grid of dis*/
  public void draw(AsciiDisplay dis)
  {
    dis.putCharAt(location.getX()-1,location.getY()-1,'*');
  }
}