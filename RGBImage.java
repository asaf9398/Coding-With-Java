/**
 * Represents an image that built from pixels - each pixel has it's own color.
 * @author Asaf Yosef
 * @version 24/04/2021
 */
public class RGBImage
{
    private RGBColor[][] _image;//creating new array of RGBColor[][];
    /**
     * Initialize a new RGBImage object - all cells are black 
     * @param rows It's the number of the rows in the array
     * @param cols It's the number of the cols in the array
     */
    public RGBImage(int rows, int cols)
    {
    _image=new RGBColor[rows][cols];//updating rows&cols
    for(int k=0;k<_image.length;k++)
        {
            for(int i=0;i<_image[0].length;i++)    
            {
                _image[k][i]=new RGBColor();//updating all cells to be black
            }
        }
    }
    /**
     * Initialize a new RGBImage object - copying all cells from other array 
     * @param pixels It's the array that we are copying from     
     */
   public RGBImage(RGBColor[][] pixels)
   {
       int rows=pixels.length;
       int cols=pixels[0].length;
       _image=new RGBColor[rows][cols]; //avoiding aliasing
       
    for(int k=0;k<_image.length;k++)
        {
            for(int i=0;i<_image[0].length;i++)    
            {
                RGBColor newPixel =new RGBColor(pixels[k][i]);//avoiding aliasing
                _image[k][i]=newPixel;
            }
        }           
   }
   /**
     * Initialize a new RGBImage object - copying all cells from other RGBImage object 
     * @param other It's the other object that we are copying from     
     */
   public RGBImage(RGBImage other)
   {
       _image=new RGBColor[other.getHeight()][other.getWidth()];
       for(int k=0;k<_image.length;k++)
            {
                for(int i=0;i<_image[0].length;i++)    
                {
                    _image[k][i]=other.getPixel(k,i);//putting the pixel in the array
                }
            }           
   }
   /**
     * Return the array height 
     * @return RGBImage array height     
     */
    public int getHeight()
    {
        int height=_image.length;
        return height;
    }
    /**
     * Return the array width 
     * @return RGBImage array width     
     */
    public int getWidth()
    {
        int width = _image[0].length;
        return width ;
    }
    /**
     * Return a specific pixel in the array, if there is not any pixel in the index - returns black pixel
     * @param row Its the row that you want to get the pixel from
     * @param col Its the col that you want to get the pixel from
     * @return RGBColor pixel     
     */
    public RGBColor getPixel(int row,int col)
    {
    if(row>=_image.length||col>=_image[0].length)//if there is not index in the arary - return black
    {
        RGBColor black=new RGBColor();
        return(black);
    }
    else//if it's inside the aray - return it 
    {
        RGBColor color=new RGBColor(_image[row][col]);//avoiding aliasing
        return color ;
    }
    }
    /**
     * Sets an other color in a specific index in the array
     * @param row Its the row that you want to set the pixel to
     * @param col Its the col that you want to set the pixel to
     * @param pixel Its the pixel you want to set in the array
     */
    public void setPixel(int row, int col, RGBColor pixel)
    {
        if(row>=_image.length||col>=_image[0].length)
        {
            //do nothing
        }
        else
        {
            RGBColor color=new RGBColor(pixel);//avoiding aliasing
            _image[row][col]=color;
        }
    }
    /**
     * Return a True/False if the arrays are identical 
     * @param other Its the other array
     * @return match True/False if the arrays match     
     */
    public boolean equals(RGBImage other)
    {
        if(_image.length!=other.getWidth()||_image[0].length!=other.getHeight())//if the arrays does not have the same size they can't be identical - return false
        {
            boolean match=false;
            return match;
        }
        else
        {
            for(int k=0;k<other.getWidth();k++)
            {
                for(int i=0;i<other.getHeight();i++)
                {
                    if(_image[k][i]!=other.getPixel(k,i))
                    {
                        boolean match=false;//if even one pixel not match - return false
                        return match;
                    }
                }
            }
    
            boolean match=true;//if all pixels are matching - return true    
            return match;
        }
   
    }
    /**
     * Updating the array to be flipped horizontal    
     */
    public void flipHorizontal()
    {
        int k=1;
        RGBImage _image2=new RGBImage(_image);//creating new obect identical to _image
        for(int i=0;i<_image.length;i++)
            {
                for(int j=0;j<_image[0].length;j++)
                {
                    _image[i][j]=_image2.getPixel(i,_image[0].length-k);//flipping and updating the first array
                    k++;
                }
                k=1;
            }        
    }
    /**
     * Updating the array to be flipped vertical    
     */
    public void flipVertical()
    {
        int k=1;        
        RGBColor[][] _image2=new RGBColor[_image.length][_image[0].length];//creating another array that will save the values
        for(int m=0;m<_image2.length;m++)
        {
            for(int n=0;n<_image2[0].length;n++)
            {
                _image2[m][n]=new RGBColor(_image[m][n]);
            }
        }
        for(int i=0;i<_image[0].length;i++)
            {
                for(int j=0;j<_image.length;j++)
                {
                    _image[j][i]=_image2[_image.length-k][i];//flipping and updating the first array
                    k++;
                }
                k=1;
            }      
        
    }
    /**
     * Updating all the colors of the pixels in the array to their subtraction from 255     
     */
    public void invertColors()
    {
     for(int i=0;i<_image[0].length;i++)
            {
                for(int j=0;j<_image.length;j++)
                {
                    //putting new objects in the pixels with new colors
                    _image[j][i]=new RGBColor(255-_image[j][i].getRed(),255-_image[j][i].getGreen(),255-_image[j][i].getBlue());
                }
                
            }      
    }
    /**
     * Rotating the array with 90 degrees to the right(closckwise)     
     */
    public void rotateClockwise()
    {
        int cols= _image[0].length;//the original number of cols
        int rows= _image.length;//the original number of rows
        int newCols=rows;//the new number of cols
        int newRows=cols;//the new number of rows
        RGBColor[][] _image2=new RGBColor[newRows][newCols];//creating rotated new array
        for(int k=0;k<_image[0].length;k++)
        {
            for(int i=0;i<_image.length;i++)
            {
                _image2[k][_image.length-1-i]=_image[i][k];//rotating the array
            }                    
        }
        
        //avoiding aliasing - putting all _image2 in to _image
        _image=new RGBColor[_image2.length][_image2[0].length];
        for(int m=0;m<_image2.length;m++)
        {
            for(int n=0;n<_image2[0].length;n++)
            {
                _image[m][n]=new RGBColor(_image2[m][n]);//creating new RGBColor - avoiding alisaing
            }
        }
    }
    /**
     * Rotating the array with 90 degrees to the left(CounterClockwise)     
     */
    public void rotateCounterClockwise()
    {
        //rotating 3 times to the right = 1 time to the left
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();    
    }
    /**
     * The method gets an offset parameter and shifts the collums of the array according to the variable(positive/negative)
     * @param offset Its the number of collums that you want to move the array - positive = right, negative= left
     */
    public void shiftCol(int offset)
    {
        if(_image[0].length==offset)//if offset == to the array numebr of collums - make all pixels black
        {
            for(int i=0;i<_image.length;i++)
            {
                for(int k=0;k<_image[0].length;k++)
                {
                    _image[i][k]=new RGBColor();//makes all pixel black
                }
            }
        
        }
        else
        {
            if(offset>_image[0].length)//if offset is bigger than number of collums - do nothing
            {
                //do nothing
            }
            else
            {
                
                 
                if(offset>0)//if offset is positive -move right 
                {   RGBColor[][] _image2=new RGBColor[_image.length][_image[0].length+offset];
                    //move all right
                    for(int j=0;j<_image2[0].length;j++)
                    {
                        for(int t=0;t<_image.length;t++)
                        {
                            if(j<offset)
                            {
                                _image2[t][j]=new RGBColor();
                            }
                            else
                            {
                                _image2[t][j]=_image[t][j-offset];  
                            }
                        }
                    }
                    
                    
                    //avoiding aliasing - putting all _image2 in to _image
                    _image=new RGBColor[_image2.length][_image2[0].length];
                    for(int m=0;m<_image2.length;m++)
                    {   
                        for(int n=0;n<_image2[0].length;n++)
                        {
                            _image[m][n]=new RGBColor(_image2[m][n]);//creating new RGBColor - avoiding alisaing
                        }
                    }
                }
                else//if offset is negative= left
                {
                    offset=Math.abs(offset);
                    RGBColor[][] _image2=new RGBColor[_image.length][_image[0].length+offset];
                    //move all left
                    for(int h=0;h<_image.length;h++)
                    {
                        for(int l=0;l<_image[0].length;l++)
                        {
                            _image2[h][l]=_image[h][l];
                        }
                    
                    }
                    for(int g=0;g<_image2.length;g++)
                    {
                        for(int k=_image[0].length;k<_image2[0].length;k++)
                        {
                            _image2[g][k]=new RGBColor();
                        }
                    }                
                    //avoiding aliasing - putting all _image2 in to _image
                    _image=new RGBColor[_image2.length][_image2[0].length];
                    for(int m=0;m<_image2.length;m++)
                    {
                        for(int n=0;n<_image2[0].length;n++)
                        {
                            _image[m][n]=new RGBColor(_image2[m][n]);//creating new RGBColor - avoiding alisaing
                        }
                    }
                }
        
            }   

        }
    }
    /**
     * The method gets an offset parameter and shifts the collums of the array according to the variable(positive/negative)
     * @param offset Its the number of rows that you want to move the array - positive = down, negative= up
     */
    public void shiftRow(int offset)
    {
        if(_image.length==offset)//if offset == to the array numebr of rows - make all pixels black
        {
            for(int i=0;i<_image.length;i++)
            {
                for(int k=0;k<_image[0].length;k++)
                {
                    _image[i][k]=new RGBColor();//makes all black
                }
            }
        
        }
        else
        {
            if(offset>_image.length)//if offset is bigger than number of rows - do nothing
            {
                //do nothing
            }
            else
            {
                
                 
                if(offset>0)
                {   RGBColor[][] _image2=new RGBColor[_image.length+offset][_image[0].length];
                    //move all down and than make the offset rows black
                    for(int k =0;k<_image.length;k++)
                    {
                        for(int j=0;j<_image[0].length;j++)
                        {
                            _image2[offset+k][j]=_image[k][j];
                        }
                    }
                    //making the offset rows black
                    for(int m=0;m<offset;m++)
                    {
                        for(int n=0;n<_image[0].length;n++)
                        {
                            _image2[m][n]=new RGBColor();
                        }
                    }
                    //avoiding aliasing - putting all _image2 in to _image
                    _image=new RGBColor[_image2.length][_image2[0].length];
                    for(int m=0;m<_image2.length;m++)
                    {
                        for(int n=0;n<_image2[0].length;n++)
                        {
                            _image[m][n]=new RGBColor(_image2[m][n]);//creating new RGBColor - avoiding alisaing
                        }
                    }
                }
                else
                {   
                    offset=offset*-1;
                    RGBColor[][] _image2=new RGBColor[_image.length+offset][_image[0].length];
                    //move all up
                    //copying the array and adding offset black rows                    
                    for(int k=0;k<_image.length;k++)
                    {
                        for(int j=0;j<_image[0].length;j++)
                        {
                               _image2[k][j]=new RGBColor(_image[k][j]); 
                        }
                    }
                    for(int t=0;t<offset;t++)
                    {
                        for(int g=0;g<_image2[0].length;g++)
                        {
                           _image2[t][g]=new RGBColor(); //making the last offset rows black
                        }
                    }
                    //avoiding aliasing - putting all _image2 in to _image
                    _image=new RGBColor[_image2.length][_image2[0].length];
                    for(int m=0;m<_image2.length;m++)
                    {
                        for(int n=0;n<_image2[0].length;n++)
                        {
                            _image[m][n]=new RGBColor(_image2[m][n]);//creating new RGBColor - avoiding alisaing
                        }
                    }
                }
        
            }   

        }
    }
    /**
     * The method reutrns an array of double variables that contains the gray color of every pixel 
     * @return grayScaleArray[][] Is an array of double variables that contains the gray color of every pixel 
     */
    public double[][] toGrayscaleArray()
    {
        double[][] grayscaleArray=new double[_image.length][_image[0].length];
        for(int k=0;k<_image.length;k++)        
        {
            for(int i=0;i<_image[0].length;i++)
            {
                grayscaleArray[k][i]=_image[k][i].convertToGrayscale();
            }
        }
        return grayscaleArray;
    }
    /**
     * The method reutrns an array of String variables that contains the value of each color like : (Red,Green,Blue)
     * @return str The string of the array presentation 
     */
    public String toString()
    {
        String str="";//putting first value
        for(int k=0;k<_image.length;k++)
        {
            for(int i=0;i<_image[0].length;i++)
            {
                if(i==_image[0].length-1)//if getting to the end of the line - move one line down
                {
                    str+="("+_image[k][i].getRed()+","+_image[k][i].getGreen()+","+_image[k][i].getBlue()+")"+"\n" ;
                }
                else//if the line did not ended - add space between the strings
                {
                    str+="("+_image[k][i].getRed()+","+_image[k][i].getGreen()+","+_image[k][i].getBlue()+")"+" " ;
                }
            }
        }
        return str;
    }
    /**
     * The method reutrns an array of RGBColor objects
     * @return _image2 Is the RGBColor[][] array 
     */
    public RGBColor[][] toRGBColorArray()
    {
        RGBColor[][] _image2=new RGBColor[_image.length][_image[0].length];
        for(int k=0;k<_image.length;k++)
        {
            for(int i=0;i<_image[0].length;i++)
            {
                _image2[k][i]=_image[k][i];
            }
        }
        return _image2;
    }
    
    
    
   
    
    
    
    
    
}
