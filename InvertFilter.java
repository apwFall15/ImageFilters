import java.awt.Color;

/**
 * A filter that simply inverts the color values of each pixel.
 * 
 * @author Andrew Worthington
 * @version 12/7/15
 */
public class InvertFilter extends Filter
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class InvertFilter
     */
    public InvertFilter(String name)
    {
        super(name);
    }

     /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        OFImage original = new OFImage(image);
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color currentPixel = original.getPixel(x,y);
                int grn,blu,red;
                grn = 255 - currentPixel.getGreen();
                red = 255 - currentPixel.getRed();
                blu = 255 - currentPixel.getBlue();
                image.setPixel(x, y, new Color(red,blu,grn));
            }
        }
    }
    
}
