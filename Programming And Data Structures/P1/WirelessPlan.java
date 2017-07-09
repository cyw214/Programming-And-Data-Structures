/*
CSE 17 
Charles Wallace 
cyw214 
Program #1 DEADLINE: Sept. 16, 2014 
Program: Wireless Plan
*/

import java.util.Scanner;
import java.lang.Math;
import java.lang.Integer;

public class WirelessPlan
{
  private String company;
  private String planname;
  private double price;
  private int datalimit;
  private double dataoveragecharge;
  private int dataoverageunit; 
  
  /**
   * Constructs a WirelessPlan object with arguments for the company, planname, price, datalimit, dataoveragecharge,
   * and dataoverageunit data fields.
  */
  WirelessPlan(String acompany, String aplanname, double aprice, int adatalimit, double adataoveragecharge, int adataoverageunit)
  {
    company = acompany;
    planname = aplanname;
    price = aprice;
    datalimit = adatalimit;
    dataoveragecharge = adataoveragecharge;
    dataoverageunit = adataoverageunit;
  }
  
  /**
   * returns the company name
  */
  public String getcompany()
  {
    return company;
  }
   /**
   * returns the plan name
  */
   public String getplanname()
  {
    return planname;
  }
  /**
   * returns the price of a plan for one month
  */
   public double getprice()
  {
    return price;
  }
  /**
   * returns the data limit for a plan
  */ 
  public int getdatalimit()
  {
    return datalimit;
  }
  /**
   * returns the the amount charged per data unit for overages
  */
  public double getdataoveragecharge()
  {
    return dataoveragecharge;
  }
  /**
   * returns the unit for overage fees
  */ 
  public int getdataoverageunit()
  {
    return dataoverageunit;
  }
  /**
   * sets the price instance variable for a WirelessPlan object
  */
  public void setprice(double aprice)
  {
    price = aprice;
  }
  /**
   * class method takes in an array of integers representing monthly Usage with an integer value and returns a double
   * with the total calculated cost for a plan based on datalimit, dataoveragecharges, and overage units
   * associated with a wireless object
  */
  public double calculateTotalCost(int[] monthlyUsage)
  {
    double cost = 0;
    int i;
    for(i=0 ; i <6 ; i++)
    { 
      
      if((monthlyUsage[i] <= datalimit) || (datalimit == Integer.MAX_VALUE)) 
      {
        cost = cost + price;
      }
      else if((monthlyUsage[i] > datalimit) && (dataoveragecharge == Integer.MAX_VALUE))
      {
        cost = Integer.MAX_VALUE;
        return cost;
      }
      else
      { 
        double overunitratio = (((monthlyUsage[i]-datalimit)*1.0)/(dataoverageunit));
        double extra = Math.ceil(overunitratio)*(dataoveragecharge);
        cost = cost + price + extra;
      }
    }
    return cost;
  }
  /**
   * class method prints details about a plan in a row to a standard output device.
  */
  public void printPlanRow(double cost)
  {
    if(datalimit == Integer.MAX_VALUE && (dataoverageunit == -1))
    { 
      String output = String.format("%-10s%10s%1s%10.2f%8s%1s%-18s%8.2f",company,planname," ",price,"n/a"," ","n/a",cost);
      System.out.println(output);
    }
    else if(((dataoveragecharge == Integer.MAX_VALUE) && (dataoverageunit == -2)))
    {
      String output = String.format("%-10s%10s%1s%10.2f%8d%1s%-18s%8.2f",company,planname," ",price,datalimit," ","n/a",cost);
      System.out.println(output);
    }
    else if(cost == Integer.MAX_VALUE && (dataoverageunit == -3))
    {
      String output = String.format("%-10s%10s%1s%10.2f%8d%1s%-18s%8s",company,planname," ",price,datalimit," ","n/a","n/a");
      System.out.println(output);
    }
    else if(dataoveragecharge < 1)
    {
      String output = String.format("%-10s%10s%1s%10.2f%8d%2s%5.3f%5s%4d%4s%7.2f",company,planname," ",price,datalimit," $",dataoveragecharge," per ",dataoverageunit," MB ",cost);
      System.out.println(output);
    }
    else
    {
      String output = String.format("%-10s%10s%1s%10.2f%8d%2s%5.2f%5s%4d%4s%7.2f",company,planname," ",price,datalimit," $",dataoveragecharge," per ",dataoverageunit," MB ",cost);
      System.out.println(output);
    }
  }
  /**
   * static method takes in two arrays, one of Wireless plan objects, and another of plan costs, then 
   * prints an ascending sorted list of Wireless plans organized by cost.
  */
  public static void sortPlansAndCosts(WirelessPlan[] plans, double[] planCosts)
  {
    WirelessPlan tempwire;
    for(int i=0; i < planCosts.length-1; i++)
    {
      double currentmin = planCosts[i];
      int currentminindex = i;
      
      for(int j=(i+1); j<planCosts.length; j++)
      {
        if(currentmin > planCosts[j])
        {
          currentmin = planCosts[j];
          currentminindex = j;
        }
      }
      
        if(currentminindex != i)
        {
          planCosts[currentminindex] = planCosts[i];
          planCosts[i] = currentmin;
          
          int intindex = currentminindex;
          tempwire = plans[intindex];
          plans[currentminindex] = plans[i];
          plans[i]= tempwire;
        }
      }
    
    for(int k=0; k<plans.length ; k++)
    {
      WirelessPlan tempplan = plans[k];
      tempplan.printPlanRow(planCosts[k]);
    }
  }
  
  /**
   * static main method requests user input for data usage over six months then uses plans
   * hard coded in an array, along with an array of doubles calculating the cost of each plan
   * based off of user input to display an ascending sorted list of plan information by cost.
  */
  public static void main(String[] args)
  {
    int[] myArray = new int[6];
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter your wireless usage (in MB) for 6 months.");
    for(int i = 0; i< 6; i++)
    {
      myArray[i] = input.nextInt(); 
    }
    double[] costarray;
    costarray = new double[15];
        
    WirelessPlan[] myPlans = {
    new WirelessPlan("AT&T", "300", 60.0, 300, 20.0, 300),
    new WirelessPlan("AT&T", "1000", 65.0, 1000, 20.0, 500),
    new WirelessPlan("AT&T", "2000", 80.0, 2000, 15.0, 1000),
    new WirelessPlan("AT&T", "4000", 110.0, 4000, 15.0, 1000),
    new WirelessPlan("Sprint", "1000", 77.0, 1000, 0.015, 1),
    new WirelessPlan("Sprint", "3000", 87.0, 3000, 0.015, 1),
    new WirelessPlan("Sprint", "Unlimited", 97.0, Integer.MAX_VALUE, Integer.MAX_VALUE, -1),
    new WirelessPlan("T-Mobile", "500", 65.0, 500, Integer.MAX_VALUE, -3),
    new WirelessPlan("T-Mobile", "3000", 75.0, 3000, Integer.MAX_VALUE, -2),
    new WirelessPlan("T-Mobile", "5000", 95.0, 5000, Integer.MAX_VALUE, -2),
    new WirelessPlan("Verizon", "250", 55.0, 250, 15, 200),
    new WirelessPlan("Verizon", "500", 70.0, 500, 15, 500),
    new WirelessPlan("Verizon", "1000", 80.0, 1000, 15, 1000),
    new WirelessPlan("Verizon", "2000", 90.0, 2000, 15, 1000),
    new WirelessPlan("Verizon", "4000", 110.0, 4000, 15, 1000) };
  
    for(int i=0; i<15 ; i++)
    {
      WirelessPlan tempplan = myPlans[i];
      costarray[i] = tempplan.calculateTotalCost(myArray);
    }
    
    System.out.println("Here is our estimate cost of plans for you\n");
    
    String output = String.format("%-10s%10s%1s%10s%-8s%1s%-18s%8s","Company","Plan"," ","$ per Mo.","Data(MB)"," ","Overages","Total($)");
    System.out.println(output);
    sortPlansAndCosts(myPlans, costarray);    
  }  
}

