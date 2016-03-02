import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void grayscale()
  {
	  int average;
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] row : pixels)
		  for(Pixel pixel : row)
		  {
			  average = (pixel.getBlue() + pixel.getRed() + pixel.getGreen()) / 3;
			  pixel.setBlue(average);
			  pixel.setRed(average);
			  pixel.setGreen(average);
		  }
  }
  
  public void negate()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] row : pixels)
		  for(Pixel pixel : row)
		  {
			  pixel.setBlue(255 - pixel.getBlue());
			  pixel.setRed(255 - pixel.getRed());
			  pixel.setGreen(255 - pixel.getGreen());
		  }
  }
  
  public void fixUnderwater()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] row : pixels)
		  for(Pixel pixel : row)
		  {
			  if(pixel.getGreen() < pixel.getBlue())
			  {
				 pixel.setBlue(pixel.getBlue() + 30);
				  pixel.setRed(pixel.getRed() + 30);
				 pixel.setGreen(pixel.getGreen() + 30);
			  }
			  else
			  {
				  int average = (pixel.getBlue() + pixel.getRed() + pixel.getGreen()) / 3;
				  pixel.setBlue(average);
				  pixel.setRed(average);
				  pixel.setGreen(average);
			  }
		  }
  }
  
  public void mirrorDiagonal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int lowDim;
	  if(pixels.length > pixels[0].length)
		  lowDim = pixels[0].length - 1;
	  else
		  lowDim = pixels.length - 1;
	  for(int diag = lowDim; diag > 0; diag --)
		  for(int row = diag - 1; row >= 0; row --)
			  pixels[row][diag].setColor(pixels[diag][row].getColor());
	  for(int diag = lowDim; diag > 0; diag--)
		  for(int row = 0; row < lowDim; row++)
			  pixels[row][diag].setColor(pixels[diag][row].getColor());
  }
  
  public void mirrorArms()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int lowRow = 159;
	  int highRow = 190;
	  int lowCol = 105;
	  int highCol = 169;
	  
	  int lowRow2 = 172;
	  int highRow2 = 195;
	  int lowCol2 = 239;
	  int highCol2 = 293;
	  
	  for(int row = lowRow; row < highRow; row++)
		  for(int col = lowCol; col <= highCol; col++)
			  pixels[row+2 * (highRow - row)][col].setColor(pixels[row][col].getColor());
	  for(int row = lowRow2; row < highRow2; row++)
		  for(int col = lowCol2; col <= highCol2; col++)
			  pixels[row + 2 * (highRow2 - row) - 5][col].setColor(pixels[row][col].getColor());
			  
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
      System.out.print(count + "pixels changed");
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy(Picture fromPic, int placeRow, int placeCol, int startRow, int startCol, int endRow, int endCol)
  {
	  Pixel[][] toPixels = this.getPixels2D();
	  Pixel[][] fromPixels = fromPic.getPixels2D();
	  for(int fromRow = startRow, toRow = placeRow; 
			  fromRow < fromPixels.length && fromRow < endRow && toRow < toPixels.length; 
			  fromRow++, toRow++)
		  for(int fromCol = startCol, toCol = placeCol;
				  fromCol < fromPixels[0].length && fromCol < endCol && toCol < toPixels[0].length;
				  fromCol++, toCol++)
			  toPixels[toRow][toCol].setColor(fromPixels[fromRow][fromCol].getColor());
		  
	  
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture koala = new Picture("koala.jpg");
    Picture barbara = new Picture("BarbaraS.jpg");
    this.copy(koala,0,0);
    this.copy(barbara, 130, 250, 10, 20, 100, 90);
    //this.copy(koala,200,0);
    Picture flowerNoBlue = new Picture(barbara);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,75,65);
   // this.copy(koala,400,0);
   // this.copy(barbara,500,0);
    this.mirrorDiagonal();
    //this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        Pixel downPixel = pixels[row+1][col];
        Color downColor = downPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist 
        		&& leftPixel.colorDistance(downColor) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else if(leftPixel.colorDistance(rightColor) > edgeDist
        		|| leftPixel.colorDistance(downColor) > edgeDist)
        	leftPixel.setColor(Color.GRAY);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    for(int row = 0; row < pixels.length - 1; row++)
    {
    	leftPixel = pixels[row][pixels[0].length-1];
    	if(leftPixel.colorDistance(pixels[row+1][pixels[0].length-1].getColor()) > edgeDist)
    		leftPixel.setColor(Color.BLACK);
    	else
    		leftPixel.setColor(Color.WHITE);
    }
    for(int col = 0; col < pixels[0].length - 1; col++)
    {
    	leftPixel = pixels[pixels.length-1][col];
    	if(leftPixel.colorDistance(pixels[pixels.length-1][col+1].getColor()) > edgeDist)
    		leftPixel.setColor(Color.BLACK);
    	else
    		leftPixel.setColor(Color.WHITE);
    }
    pixels[pixels.length-1][pixels[0].length-1].setColor(Color.WHITE);
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
	//Picture p = new SimplePicture();
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
