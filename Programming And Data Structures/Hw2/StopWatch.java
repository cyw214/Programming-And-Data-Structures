/*
CSE 17 
Charles Wallace 
cyw214 
Homework #1 DEADLINE: Sept. 07, 2014 
Program: Stop Watch and Math Test
*/


import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class StopWatch
{
  double startTime;
  double timedMs;
  boolean running;
  
  /**
   * Constructs a StopWatch object without arguments.
  */
  StopWatch()
  { 
    Date current = new Date();
    startTime = current.getTime();
    timedMs = 0;
    running = false;
  }
  
  /**
   * Sets startTime instance variable to the current time and
   * sets the running instance variable to true. to start
   * the stopWatch.
  */
  public void start()
  {
    Date current = new Date();
    startTime = current.getTime();
    running = true;
  }
  
  /**
   * Sets the timedMS instanve variable to the
   * total time elapsed by subtrating the current time
   * from the start time. Also sets the running instanve variable to zero.
  */
  public void stop()
  { 
    Date current = new Date();
    running = false;
    timedMs = (current.getTime() - startTime);
  }
  
  /**
   * Returns the elapsed time between the start
   * of the stopWatch and the stop in seconds if 
   * running is false.
  */
  public double getElapsedTime()
  {
    if (running == false)
    {  
      double elapsedsec = ((timedMs)/1000);
      return elapsedsec;
    }
    else
      return 0;
  }
  
  /**
   * Main method asks user for name, and asks how many multiplication problems
   * the user would like to solve. Problems are presented to the user
   * and Clock objects are used to time how long
   * it takes to solve each math problem.
  */
  public static void main(String[] args)
  {
    StopWatch clock = new StopWatch();
    Scanner input = new Scanner(System.in);
    
    clock.start();
    //Ask user for name
    System.out.print("Please Enter Your Name: ");
    String Name = input.next();
    
    //Print user's name
    System.out.println("Hello " + Name);
    
    //Request desired number of math problems
    System.out.println("How many math Problems would you like to solve?");
    int numproblems = input.nextInt();  
   
    clock.stop();
    
    //Notification that the math quiz is about to start
    System.out.printf("Starting quiz after %4.1f seconds.\n", clock.getElapsedTime());
    
    //loop to generate ranom problems and time how long it takes the user to solve them.
    int i;
    for(i = numproblems; i > 0; --i)
    {
      Random integer1 = new Random();
      int firstint = (integer1.nextInt(10) +1);
      
      Random integer2 = new Random();
      int secondint = (integer2.nextInt(10) + 1);
     
      
      System.out.println("What is " + firstint + "x" + secondint + " ?");
      
      clock.start();
      
      int companswer = ((firstint)*(secondint)); 
      int useranswer = input.nextInt();
      if(companswer == useranswer)
      { 
        clock.stop();
        System.out.printf("That Is Correct! It took you %4.1f seconds to solve that problem.\n", clock.getElapsedTime()  );
      }
      if (companswer != useranswer)
      { 
        clock.stop();
        System.out.printf("That Is Wrong! It took you %4.1f seconds to screw that up.\n", clock.getElapsedTime());
      }
    }
  }
}

