import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class test_4{

    public static void main(String[] args) {
        try {
            // Load the original image
            BufferedImage originalImage = ImageIO.read(new File("./company1.png"));
            
            // Create a new image with the same dimensions
            BufferedImage falseColorImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            
            // Apply false color mapping
            long start=System.nanoTime();
            for (int x = 0; x < originalImage.getWidth(); x++) {
                 for (int y = 0; y < originalImage.getHeight(); y++) {
                    int rgb = originalImage.getRGB(x, y);
                    // int intensity_r = (rgb >> 16) & 0xFF; // Extract red channel intensity
                    // int intensity_g = (rgb >> 8) & 0xFF;
                    // int intensity_b = (rgb) & 0xFF;
                    
                    // Apply your false color mapping logic here
                    // if(intensity_r<127&&intensity_g<127&&intensity_b<127){
                    //     int falseColorRGB = mapIntensityToRGB(intensity_r);
                    //     falseColorImage.setRGB(x, y, falseColorRGB);
                    // }
                    falseColorImage.setRGB(x,y,rgb+10);
                }
            }
            long end=System.nanoTime();
            System.out.println("array "+(end-start)+" nano seconds");
            // Save the false color image
            ImageIO.write(falseColorImage, "png", new File("./spatial_out.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Runtime r=Runtime.getRuntime();
        long usedmemory=r.totalMemory()-r.freeMemory();
        System.out.println(usedmemory+" bytes");
    }
}