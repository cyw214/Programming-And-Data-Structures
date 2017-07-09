/* 
CSE 17 
Charles Wallace 
cyw214  
Program #2 DEADLINE: October 16, 2014 
Program: Ascii Draw
*/ 

/** The Rectangle class is a subclass of Shape. it represents a rectangle. */
public class Rectangle extends Shape 
{
  private int length;
  private int height;
  
  /** initializes rectangle object with the data fields inherited from shape as well as additional length and height fields.*/
  public Rectangle(String id, Coordinate loc, int length, int height) 
  {
   super(id, loc);
   this.length = length;
   this.height = height;
  }
 
  /** the draw() method updates the grid of dis by drawing a filled in rectangle with topleft 
  corner loc that is height characters tall and length 
  characters wide. The borders and interior of the rectangle 
  should be filled with ‘#’ characters.*/
  public void draw(AsciiDisplay dis)
  {
    for(int i=0; i < length; i++)
    {
      for(int j=0; j < height; j++)
      {
        dis.putCharAt((location.getX() + i-1),(location.getY() + j-1),'#');
      }
    }
  }
}