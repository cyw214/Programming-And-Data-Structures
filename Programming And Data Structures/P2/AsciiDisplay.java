/* 
CSE 17 
Charles Wallace 
cyw214  
Program #2 DEADLINE: October 16, 2014 
Program: Ascii Draw
*/

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**The AsciiDisplay class provides a window onto which objects may be drawn*/
public class AsciiDisplay
{
  private char grid[][];
  private ArrayList<Shape> shapes;
  
  /** The AsciiDisplay constructor. Initializes grid and shapes.*/
  AsciiDisplay()
  {
    grid = new char[15][30];
    shapes = new ArrayList<>();
   }
  
  /**the addShape method Adds a Shape object to shapes*/
  public void addShape(Shape s)
  {
    shapes.add(s);
  }
  
  /**The method moveShape moves a shape with a given id to newLoc and returns 0. If the 
  shape is not in shapes then returns -1. */
  public int moveShape(String id, Coordinate newLoc)
  { 
    Shape temp1 = new Shape(id, newLoc);
    Shape temp2;
    for(int i =0; i < shapes.size(); i++)
    { 
      temp2 = shapes.get(i);
      if(temp1.equals(temp2))
      { 
        temp2.move(newLoc);
        shapes.remove(i);
        shapes.add(i, temp2);
        return 0;
      }
    }
    return -1;
  }
  
  /** the printGrid method Calls updateGrid() and then prints the contents of grid*/
  public void printGrid()
  {
    updateGrid(); 
    System.out.print("+");
    for(int i = 0; i < grid.length; i++)
    {
      System.out.print("--");
    }
    System.out.print("+\n");
    for(int j = 0; j < grid.length; j ++)
    {   System.out.print("|");
      for(int k = 0; k < grid[j].length; k++)
      {
        System.out.print(grid[j][k]);
      }
      System.out.println("|");
    } 
    System.out.print("+");
    for(int l = 0; l < grid.length; l++)
    {
      System.out.print("--");
    }
    System.out.print("+\n");
    
  }
  
  /** Deletes all objects from shapes.*/
  public void deleteAll()
  {
    if(!shapes.isEmpty())
    {
      for(int i = (shapes.size()-1); i >= 0; i--)
      {
        shapes.remove(i);
      }
    }
  }
  
   /** The putCharAt method puts a character c at a specific (x,y) location on the grid. The 
  location (0,0) is the top-left corner of the display, while x
  specifies the column, and y specifies the row.*/
  void putCharAt(int x, int y, char c)
  {
    grid[y][x] = c;
  }
  
  /** The updateGrid() method clears grid then draws each element of shapes in it. Does not print 
  anything to the screen. If objects overlap, then the most recently 
  added object is placed on top.*/
  private void updateGrid()
  {
    for(int i = 0; i < grid.length; i ++)
    {
      for(int j = 0; j < grid[i].length; j++)
      {
        grid[i][j] = ' ';
      }
    }
    for(int j = 0; j < (shapes.size()); j++)
    {
      Shape temp;
      temp = shapes.get(j);
      temp.draw(this);
    }
  }
  
  /**  The main method checks that the number of command-line arguments is one exiting if it is not,  opens a scanner on the file,
  creates an AsciiDisplay object, reads from the file which consists of a series of “commands”, one per line, that tell it 
  w hat to draw to the AsciiDisplay object */
  public static void main(String[] args) 
  { 
    if (args.length != 1)
    {
      System.out.println("Usage: java AsciiDisplay filename");
      System.exit(1);
    }
    else {
      try {
        
        
        AsciiDisplay D = new AsciiDisplay();
        File newfile = new File(args[0]);
        
        Scanner input = new Scanner(newfile);
        
        String commandtype;
        Coordinate C;
        Shape S;
        
        
        while(input.hasNext())
        {
          commandtype = input.next();
          if(commandtype.equals("P"))
          {
            String aid = input.next();
            int X = input.nextInt();
            int Y = input.nextInt();
            C = new Coordinate(X,Y);
            S = new Point(aid,C);
            D.addShape(S);
          }
          else if(commandtype.equals("R"))
          {
            String aid = input.next();
            int X = input.nextInt();
            int Y = input.nextInt();
            int length = input.nextInt();
            int height = input.nextInt();
            C = new Coordinate(X,Y);
            S = new Rectangle(aid,C,length,height);
            D.addShape(S);
          }
          else if(commandtype.equals("S"))
          {
            String aid = input.next();
            int X = input.nextInt();
            int Y = input.nextInt();
            int size = input.nextInt();
            C = new Coordinate(X,Y);
            S = new Square(aid, C, size);
            D.addShape(S);
          }
          else if(commandtype.equals("M"))
          {
            String aid = input.next();
            int X = input.nextInt();
            int Y = input.nextInt();
            C = new Coordinate(X,Y);
            D.moveShape(aid,C);
          }
          else if(commandtype.equals("E"))
          {
            D.deleteAll();
          }
          else if(commandtype.equals("D"))
          {
            D.printGrid();
          }
          else
          {
            System.out.println("Invalid command: " + commandtype);
            input.nextLine();
          }
        }
      }
      
      catch (FileNotFoundException ex)
      {
        System.out.println("ERROR: Couldn't open file: " + args[0]);
      }
    }
  }
}