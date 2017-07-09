/* 
CSE 17 
Charles Wallace 
cyw214
Homework #4 DEADLINE: October 7, 2014 
Program: Media Library 
*/ 

/**the MP3 class extends the media class and adds additional atrributes through data fields to represent the MP3 media type*/
public class MP3 extends Media
{
  private double bitrate;
  private boolean adaptive;
  private String encoder;
  
/**MP3 constructor initializes the data fields in a dvd object particular to the MP3 class as well as the fields from it's super class*/
  MP3(int id, String title, double length, double bitrate, boolean adaptive, String encoder)
  {
    super(id,title,length);
    this.bitrate = bitrate;
    this.adaptive = adaptive;
    this.encoder = encoder;
  }

/**Returns the value of the bitrate instance variable*/
  public double  getBitrate()
  {
    return bitrate;
  }

/**Returns the value of the adaptive instance variable*/
  public boolean getAdaptive()
  {
    return adaptive;
  }

/**Returns the value of the encoder instance variable*/
  public String getEncoder()
  {
    return encoder;
  }
}