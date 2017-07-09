/* 
CSE 17 
Charles Wallace 
cyw214  
Program #2 DEADLINE: October 16, 2014 
Program: Ascii Draw
*/ 

/** Square is a subclass of Rectangle. it represents a square*/
public class Square extends Rectangle
{
 
 /**  Initializes a square object. size is the length of all sides of 
 the square. */
 public Square(String id, Coordinate loc, int size)
 {
  super(id, loc, size, size);
 }
}