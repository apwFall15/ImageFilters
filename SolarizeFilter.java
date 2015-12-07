import java.awt.Color;

/**
 * A simple solarize filter that compares pixel color values less than 128 and increases them to 
 * 255, leaving values larger than 128 alone.
 * 
 * @author Andrew Worthington
 * @version 12/7/15
 */
public class SolarizeFilter extends Filter
{
    // instance variables - replace the example below with your own
    // constants:
    private final static int SCALE = 20;   // this defines the strenght of the filter
    private final static double TWO_PI = 2 * Math.PI;

    /**
     * Constructor for objects of class SolarizeFilter
     */
    public SolarizeFilter(String name)
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
                grn = currentPixel.getGreen() < 128 ? 255 : currentPixel.getGreen();
                red = currentPixel.getRed() < 128 ? 255 : currentPixel.getRed();
                blu = currentPixel.getBlue() < 128 ? 255 : currentPixel.getBlue();
                image.setPixel(x, y, new Color(red,blu,grn));
            }
        }
    }


}
