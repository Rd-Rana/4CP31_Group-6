
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StarFluxCalculator {
    BufferedImage img;

    // Function to calculate flux from centroid coordinates
    public double calculateFlux(int centroidX, int centroidY, BufferedImage image, int apertureSize) {
        // Calculate boundaries for the aperture
        int startX = Math.max(0, centroidX - apertureSize / 2);
        int endX = Math.min(image.getWidth() - 1, centroidX + apertureSize / 2);
        int startY = Math.max(0, centroidY - apertureSize / 2);
        int endY = Math.min(image.getHeight() - 1, centroidY + apertureSize / 2);

        // Calculate total flux within the defined aperture
        double totalFlux = 0.0;
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                totalFlux += getPixelIntensity(image, i, j);
            }
        }

        return totalFlux;
    }

    // Function to get pixel intensity from a BufferedImage
    private int getPixelIntensity(BufferedImage image, int x, int y) {
        return image.getRGB(x, y) & 0xff; // Assuming grayscale image
    }

    public double returnflux(int X, int Y) {
        int centroidX = X; // Replace with your centroid X coordinate
        int centroidY = Y; // Replace with your centroid Y coordinate
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("D:\\Project\\image\\gray_space_image.jpg")); // Replace with your/

        } catch (Exception e) {
        }
        int apertureSize = 5; // Replace with your desired aperture size

        StarFluxCalculator fluxCalculator = new StarFluxCalculator();
        double flux = fluxCalculator.calculateFlux(centroidX, centroidY, img, apertureSize);

//        System.out.println("Done + flux);
        return flux;
    }

    public double[] fluxes(String path) {
        
        
        List<Point> starCordinate = new ArrayList<>();
        StarLocalization1 s = new StarLocalization1();
        
        starCordinate = s.extra(path);
                                                      

        int i = 0;
        StarFluxCalculator fluxCalculator = new StarFluxCalculator();
        int apertureSize = 5; // Replace with your desired aperture size
        try{
         img =  ImageIO.read(new File(path));
        }catch(Exception e){
            
        }
              System.out.println("1");                                

        double rflux[] = new double[starCordinate.size()];

        for (Point coordinate : starCordinate) {
////              System.out.println("2");                                
//
   double flux = fluxCalculator.calculateFlux((int)coordinate.x,(int)coordinate.y, img, apertureSize);
//             System.out.println("Star Coordinate: (" + coordinate.x + ", " + coordinate.y
//             + ")");
//                          System.out.println(flux);                                

            rflux[i] = flux;
            i++;
//              System.out.println(i);                                
        }
        return rflux;

    }

    public static void main(String[] args) {
        // Example centroid coordinates and buffered image object
        // StarFluxCalculator m1 = new StarFluxCalculator();
        // m1.returnflux();
    }
}