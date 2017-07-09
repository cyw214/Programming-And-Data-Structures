/*
 CSE 17
 Charles Wallace
 cyw214
 Program #5 DEADLINE: December 4, 2014
 Program: WebRentz Movie Rental System
 */ 

import java.util.ArrayList;
import java.io.File;
import java.text.ParseException;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/** A class representing the WebRentz business.*/
public class VideoBiz{
  
  /** A list of all movies owned by WebRentz.*/
  private ArrayList<Movie> movies;
  
  /** A list of all of WebRentz’s customers.*/
  private ArrayList<Customer> customers; 
  
  /** Reads in the customers and movies from the files customers.txt and movies.txt respectively. See below
    for details of file formats. If there is an error while reading either file, the program terminates gracefully.*/
  public VideoBiz()
  {
    
    movies = new ArrayList<Movie>();
    customers = new ArrayList<Customer>();
    
    try {
      File customerText = new File(
                                   "customers.txt");
      File movieText = new File("movies.txt");
      
      Scanner input = new Scanner(customerText);
      Scanner input2 = new Scanner(movieText);
      
      
      input.useDelimiter("\\t|[\\n\\r\\f]+");
      while (input.hasNext()) {
        int id; 
        String name;
        id = input.nextInt();
        name = input.next();
        
        Customer customer = new Customer(id, name);
        customers.add(customer);
      }
      
      
      input2.useDelimiter("\\t|[\\n\\r\\f]+");
      while (input2.hasNext()) {
        int id;
        String title;
        int copies;
        id = input2.nextInt();
        title = input2.next();
        copies = input2.nextInt();
        
        Movie movie = new Movie(id, title, copies);
        movies.add(movie);
      }
    } catch (FileNotFoundException e) {
      System.exit(1);
    }
    
    
    
  }
  
  /** If there are available copies of the movie specified by the requestTrans, then creates a rental transaction with
    the same date and processes it. Otherwise adds the customer to the end of the wait list.*/
  public void processNewRequest(NewRequest requestTrans)
  {
    Customer rCustomer = requestTrans.getCustomer();
    Movie rMovie = requestTrans.getMovie();
    Date rDate = requestTrans.getDate();
    if (rMovie.getNumAvailable() == 0) {
      rMovie.addToWaitList(rCustomer);
    } else {
      
      Rental r = new Rental(rCustomer,
                            rMovie, rDate);
      rMovie.processRental(r);
    }
  }
  
  /** Given returnTrans, removes the rental for the movie (increasing the number of available copies), and rents
    the movie to the next person (if any) on the wait list by creating a rental transaction with the same date and
    processing it.*/
  public void processReturn(Return returnTrans)
  {
    Movie rMovie = returnTrans.getMovie();
    Customer rCustomer = rMovie.getNextCustomerFromWaitList();
    Date rDate = returnTrans.getDate();
    rMovie.processReturn(returnTrans);
    Rental r = new Rental(rCustomer, rMovie,
                          rDate);
    rMovie.processRental(r);
  } 
  
  /** Reads a set of new request and return transactions from the given file and processes them. Any transactions
    that have invalid values for their fields (including incorrect customer or movie ids) should be ignored.
    However, you may assume that every transaction has the required four fields. See below for a description of
    the file.*/
  public void processTransactionFile(File transFile) throws FileNotFoundException
  {
    Scanner s = new Scanner(transFile);
    
    String d;
    String t;
    int cid;
    int mid;
    while (s.hasNext()) {
      try {
        d = s.next();
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = format.parse(d);
        t = s.next();
        cid = s.nextInt();
        mid = s.nextInt();
        Customer customer = getCustomerById(cid);
        Movie movie = getMovieById(mid);
        if (t.equals("N")) {
          NewRequest newrequest = new NewRequest(customer,
                                                 movie, date);
          processNewRequest(newrequest);
        }
        if (t.equals("R")) {
          Return ret = new Return(customer,
                                  movie, date);
          processReturn(ret);
        }
      } catch (Exception ex) {
        s.nextLine();
      }
    }
    
    
    
  }
  
  /** Returns the Customer object for the customer with the given id. Returns null if there is no such customer.*/
  public Customer getCustomerById(int id)
  {
    
    for (int i = 0; i < customers.size(); i++) {
      if (customers.get(i).getId() == id) 
        return customers.get(i);
      
    }
    return null;
    
    
  }
  
  /** Returns the Movie object for the movie with the given id. Returns null if there is no such movie.*/
  public Movie getMovieById(int id)
  {
    for (int i = 0; i < movies.size(); i++) {
      if (movies.get(i).getId() == id) 
        return movies.get(i);
      
    }
    return null;
  }
  
  /** Uses Movie’s printMovieDetails method to print information for each movie held by the company.*/
  public void printMovieReport()
  {
    
    for (int i = 0; i < movies.size(); i++) {
      movies.get(i).printMovieDetails();
    }
  }
  
  /** Creates a new VideoBiz object and reads in both the movies.txt and customers.txt files. Then processes
    the transaction file named as the sole command-line argument. If there are an incorrect number of
    command-line arguments, or the file cannot be opened, then the program terminates gracefully. After
    all transactions are processed, the method prints the movie report. See below for a sample output.*/
  public static void main(String[] args)
  {
    if (args.length != 1) {
      System.exit(0);
    } else {
      try {
        VideoBiz videobiz = new VideoBiz();
        File file = new File(args[0]);
        videobiz.processTransactionFile(file);
        System.out.println("Web Rentz Inventory");
        videobiz.printMovieReport();
      } catch (FileNotFoundException e) {
        System.exit(1);
      }
    }
    
  }
  
}