/* 
CSE 17 
Charles Wallace 
cyw214
Homework #4 DEADLINE: October 7, 2014 
Program: Media Library 
*/ 

/**the DVD class extends the media class and adds additional atrributes through data fields to represent the dvd media type*/
public class DVD extends Media
{
  private String resolution;
  private String aspectRatio;
  private String videoCodec;
  
/**DVD constructor initializes the data fields in a dvd object particular to the DVD class as well as the fields from it's super class*/
  DVD(int id, String title, double length, String resolution, String aspectRatio, String videoCodec)
  {
    super(id,title,length);
    this.resolution = resolution;
    this.aspectRatio = aspectRatio;
    this.videoCodec = videoCodec;
    
  }
  
/**Returns the value of the resolution instance variable*/
  public String  getResolution()
  {
    return resolution;
  }
  
/**Returns the value of the aspectratio instance variable*/
  public String  getAspectRatio()
  {
    return aspectRatio;
  }

/**Returns the value of the video codec instance variable*/
  public String  getVideoCodec()
  {
    return videoCodec;
  }
}